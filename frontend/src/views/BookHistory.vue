<template>
  <div class="container-body">
    <div class="card w-90" id="noDoctorList" v-if="bookExist === false">
      <div class="card-body">
        <h5 class="card-title">예약 내역이 없습니다.</h5>
        </div>
    </div>
    <div v-else>
      <h1>{{userName}} 님의 예약내역</h1>
      <div class="container-card" v-for="(list, idx) in bookList" :key="idx">
        <AppointmentCard :data=list :index=idx @deleteList="deleteList"/>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import AppointmentCard from '../components/AppointmentCard.vue';

export default {
  data() {
    return {
      bookList: [],
      bookExist: false,
      userId : localStorage.getItem('userId'),
      userName : localStorage.getItem('userName'),
    };
  },
  components: {
    AppointmentCard: AppointmentCard,
  },
  computed: {
    ...mapState(['user1']),
  },
  async created() {
    //로그인한 user가 의사면 안보여줌 => 의사로그인시 403 에러남(참고)
    const { data } = await this.$store.dispatch('getBookList');
    if (data.message !== 'no data') {
      this.bookExist = true;
      const openList = data.filter(({ status }) => status === 'OPEN');
      const waitList = data.filter(({ status }) => status === 'WAITING');
      const pendingPreList = data.filter(({ status }) => status === 'PENDING_PRESCRIPTION');
      const pendingCancelDocList = data.filter(({ status }) => status === 'PENDING_CANCEL_DOCTOR');
      const pendingCancelPatList = data.filter(({ status }) => status === 'PENDING_CANCEL_PATIENT');
      const finishedList = data.filter(({ status }) => status === 'FINISHED');
      const absentList = data.filter(({ status }) => status === 'DOCTOR_ABSENT' || status === 'PATIENT_ABSENT');
      const cancelList = data.filter(({ status }) => status === 'CANCELED');
      this.bookList = [...openList, ...waitList, ...pendingPreList, ...pendingCancelDocList, ...pendingCancelPatList, ...finishedList, ...absentList, ...cancelList];
    }
  },
  methods: {
    deleteList(index){
      console.log(index);
      // this.bookList.splice(index, 1);
    }
  }
}
</script>

<style>

.card{
  margin:10px;
  }

  .card-title{
    font-size: 25px;
    font-weight: bold;
  }
  .container-card{
    width: 100%;
  }

  .card-body {
    position: relative;
  }

  #detail {
    position: absolute;
    right: 16px;
    top: 20px;
    padding:10px;
  }

  #cancel {
    position: absolute;
    right: 96px;
    top: 20px;
    padding:10px;
  }

  .info-box {
    display: flex;

  }

  .half-box {
    width: 50%;
    margin: 10px;
 }

  .doctorImg{
    width:60%;
    height:60%;
  }

  #cancel:hover{
    cursor: pointer;
  }
</style>
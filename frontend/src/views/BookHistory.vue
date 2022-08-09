<template>
  <div class="container-body">
    <h1>{{userId}} 님의 예약내역</h1>
    <div class="card w-90" id="noDoctorList" v-if="bookExist === false">
      <div class="card-body">
        <h5 class="card-title">예약 내역이 없습니다.</h5>
        </div>
    </div>
    <div class="container-card" v-for="(list, idx) in bookList" :key="idx">
      <AppointmentCard :data=list :index=idx @deleteList="deleteList"/>
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
    console.log(data)
    if (data) {
      this.bookExist = true;
      const openList = data.filter(({ status }) => status === 'OPEN');
      const doneList = data.filter(({ status }) => status === 'FINISHED' || status === 'CANCELED');
      const others = data.filter(({ status }) => status !== 'OPEN' && status !== 'FINISHED' && status !== 'CANCELED');
      this.bookList = [...openList, ...others, ...doneList];
    }
  },
  methods: {
    deleteList(index){
      console.log('옴');
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
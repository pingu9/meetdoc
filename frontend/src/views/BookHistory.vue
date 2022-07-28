<template>
  <div class="container-body">
    <h1>{{user1.name}} 님의 예약 내역</h1>
    <div class="container-card" v-for="(list, idx) in bookList" :key="idx">
      <AppointmentCard :data=list />
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import AppointmentCard from '../components/AppointmentCard.vue';

export default {
  data() {
    return {
      bookList: []
    };
  },
  components: {
    AppointmentCard: AppointmentCard,
  },
  computed: {
    ...mapState(['user1']),
  },
  async created(){
    const { data } = await this.$store.dispatch('getBookList');
    if (data) {
      const openList = data.filter(({ status }) => status === 'Open');
      const doneList = data.filter(({ status }) => status === 'Done');
      const others = data.filter(({ status }) => status !== 'Done' && status !== 'Open');
      this.bookList = [...openList, ...others, ...doneList];
    }
  },
  methods: {
    
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

  #cancel {
    position: absolute;
    right: 16px;
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
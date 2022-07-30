<template>
  <div class="container-body">
    <h1>{{$store.state.chartList[0].doctorName}} 님의 진료내역</h1>
    <div class="card w-90" v-for="(chart, idx) in $store.state.chartList" :key="idx" id="container-card">
        <div class="card-body">
        <h5 class="card-title">{{chart.patientName}}</h5>
        <p class="card-text">{{chart.appointmentTime}}</p>
        <a :href="`/chart/detail/${chart.appointmentId}`" class="btn btn-primary">상세보기</a>
        </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
  data(){
    return {
      doctorName: '',
    }
  },
  components: {
  },
  computed: {
    ...mapState(['chartList'])
  },
  created() {
    //doctorId가 보내져야하는데 user8은 환자여서 user1 하드코딩
    const doctorId = localStorage.getItem('userId');
    this.$store.dispatch('getChartList', doctorId);

  },
  methods:{
    sendApptId(){

    }
  }
}
</script>

<style>
</style>
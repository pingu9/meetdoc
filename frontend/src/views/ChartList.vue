<template>
  <div class="container-body">
    <h1>Chart List</h1>
    <div class="card w-90" v-for="(chart, idx) in $store.state.chartList" :key="idx" id="container-card">
        <div class="card-body">
        <h5 class="card-title">{{chart.userName}}</h5>
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
    return{
    }
  },
  components: {
  },
  computed: {
    ...mapState(['chartList'])
  },
  created() {
    this.$store.dispatch('getChartList', 'user1');
  },
  methods:{
    sendApptId(){

    }
  }
}
</script>

<style>
</style>
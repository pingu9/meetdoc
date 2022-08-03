<template>
  <div class="container-body">
    <h1>{{$store.state.chartList[0].doctorName}} 님의 진료내역</h1>
    <div class="card w-90" v-for="(chart, idx) in $store.state.chartList" :key="idx" id="container-card">
        <div class="card-body" style="display:flex; justifiy-content:space-between;">
          <div class="circle1" v-if="chart.status === 'Before' || chart.status === 'accpted'">진료전</div>
          <div class="circle2" v-if="chart.status === 'Open'">진료중</div>
          <div class="circle3" v-if="chart.status === 'Done'">진료완료</div>
          <div class="circle4" v-if="chart.status === 'Canceled' || chart.status === 'Rejected'">진료취소</div>
          <div style="width:60%; text-align: left; margin-left: 30px;">
            <h5 class="card-title" style="line-height: 40px;">{{chart.patientName}}</h5>
            <p class="card-text" style="line-height: 40px;">{{chart.appointmentTime}}</p>
          </div>
          <div style="line-height: 100px; width:20%;"><a :href="`/chart/detail/${chart.appointmentId}`" class="btn btn-primary">상세보기</a></div>
        <!-- <h5 class="card-title">{{chart.patientName}}</h5>
        <p class="card-text">{{chart.appointmentTime}}</p>
        <a :href="`/chart/detail/${chart.appointmentId}`" class="btn btn-primary">상세보기</a> -->
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
.circle1{
  background-color: gold;
  width: 100px;
  height: 100px;
  border-radius: 50px;
  border: 1px solid gold;
  line-height: 100px;
  font-size: 20px;
  color: white;
}

.circle2{
  background-color: green;
  width: 100px;
  height: 100px;
  border-radius: 50px;
  border: 1px solid green;
  line-height: 100px;
  font-size: 20px;
  color: white;
}

.circle3{
  background-color: gray;
  width: 100px;
  height: 100px;
  border-radius: 50px;
  border: 1px solid gray;
  line-height: 100px;
  font-size: 20px;
  color: white;
}

.circle4{
  background-color: red;
  width: 100px;
  height: 100px;
  border-radius: 50px;
  border: 1px solid red;
  line-height: 100px;
  font-size: 20px;
  color: white;
}
</style>
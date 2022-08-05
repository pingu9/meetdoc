<template>
  <div class="container-body">
    <h1>{{$store.state.chartList[0].doctorName}} 님의 진료내역</h1>
    <div class="card w-90" v-for="(chart, idx) in $store.state.chartList" :key="idx" id="container-card">
        <div class="card-body" style="display:flex; justifiy-content:space-between; height:100px;">
        <div class="container-status" v-if="chart.status === 'Before' || chart.status === 'accpted'">
          <div class="circle before"></div><div class="status before">진료전</div>
        </div>
        <div class="container-status" v-if="chart.status === 'Open'">
          <div class="circle open"></div><div class="status open">진료중</div>
        </div>
        <div class="container-status" v-if="chart.status === 'Done'">
          <div class="circle done"></div><div class="status done">진료완료</div>
        </div>
        <div class="container-status" v-if="chart.status === 'Canceled' || chart.status === 'Rejected'">
          <div class="circle canceled"></div><div class="status canceled">진료취소</div>
        </div>
          <div style="width:60%; text-align: left; margin-left: 30px; vertical-align: middle; ">
            <h5 class="card-title" >{{chart.patientName}}</h5>
            <p class="card-text" >{{chart.appointmentTime}}</p>
          </div>
          <div style="line-height: 65px; width:20%;"><a :href="`/chart/detail/${chart.appointmentId}`" class="btn btn-primary">상세보기</a></div>
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
.circle{
  width:20px;
  height: 20px;
  border-radius: 10px;
  border: 3px solid;
  margin-top: 23px;
}

.status{
  font-weight: bold;
  margin-left: 5px;
  line-height:65px;
}

.container-status{
  width: 15%;
  display:flex; 
  vertical-align: middle; 
  line-height: 100px;
}

.before{
  border-color: gold;
  color: gold;
}
.open{
  border-color: green;
  color: green;
}

.done{
  border-color: gray;
  color: gray;
}
.canceled{
  border-color: red;
  color: red;
}
</style>
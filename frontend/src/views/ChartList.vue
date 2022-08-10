<template>
  <div class="container-body">
    <div class="card w-90" id="noDoctorList" v-if="noData === true">
      <div class="card-body">
        <h5 class="card-title">진료 내역이 없습니다.</h5>
      </div>
    </div>

    <div v-else>
    <h1>{{$store.state.chartList[0].doctorName}} 님의 진료내역</h1>
      <div class="card w-100" v-for="(chart, idx) in $store.state.chartList" :key="idx" id="container-card">
        <div class="card-body" style="display:flex; height:100px;">
          <div class="container-status" v-if="chart.status === 'WAITING'">
            <div class="circle before"></div><div class="status before">진료대기</div>
          </div>
          <div class="container-status" v-if="chart.status === 'OPEN'">
            <div class="circle open"></div><div class="status open">진료중</div>
          </div>
          <div class="container-status" v-if="chart.status === 'FINISHED'">
            <div class="circle done"></div><div class="status done">진료완료</div>
          </div>
          <div class="container-status" v-if="chart.status === 'CANCELED'">
            <div class="circle done"></div><div class="status done">취소완료</div>
          </div>
          <div class="container-status" v-if="chart.status === 'PENDING_CANCEL_PATIENT'">
            <div class="circle canceled"></div><div class="status canceled">환자 취소대기</div>
          </div>
          <div class="container-status" v-if="chart.status === 'PENDING_CANCEL_DOCTOR'">
            <div class="circle canceled"></div><div class="status canceled">의사 취소대기</div>
          </div>
          <div class="container-status" v-if="chart.status === 'PENDING_PRESCRIPTION'">
            <div class="circle pending"></div><div class="status pending">처방전 작성대기</div>
          </div>
          <div style="width:50%; text-align: left;">
            <h5 class="card-title" >{{chart.patientName}}</h5>
            <p class="card-text" >{{chart.appointmentTime}}</p>
          </div>
          <div style="line-height: 65px; width:15%;">
            <button class="btn btn-secondary"  v-if="chart.status === 'PENDING_CANCEL_PATIENT'" @click="apprCancel(chart)">취소확인</button>
            <button class="btn btn-danger" v-if="chart.status === 'WAITING'" @click="cancelAppt(chart)">진료취소</button>
            <button class="btn btn-success" v-if="chart.status === 'OPEN'" @click="enterRoom(chart)">진료입장</button>
          </div>
          <div style="line-height: 65px; width:15%;"><a :href="`/chart/detail/${chart.appointmentId}`" class="btn btn-primary">상세보기</a></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapMutations, mapState } from 'vuex';
export default {
  data(){
    return {
      doctorName: '',
      noData: false,
    }
  },
  components: {
  },
  computed: {
    ...mapState(['chartList'])
  },
  created() {
    console.log(this.$store.state.chartList.length)
    const doctorId = localStorage.getItem('userId');
    this.$store.dispatch('getChartList', doctorId).then((res) => {
      console.log(res.data);
      this.setChartList(res.data);
      if (res.data.message === 'no data') {
        this.noData = true;
      }else {
      this.doctorName = this.$store.state.chartList[0].doctorName;
    }
    });
    console.log(this.noData);
  },
  methods:{
    ...mapMutations(['setChartList']),
    apprCancel(appointment) {
      console.log(appointment);
      if(appointment.status === 'PENDING_CANCEL_PATIENT') {
        this.$store.dispatch('approveCancelByDoctor', appointment.appointmentId).then((res) => {
          console.log(res.data);
          alert("진료가 취소되었습니다.");
          appointment.status = 'CANCELED';
        }).catch(e => console.log(e))
      }
    },
    cancelAppt(appointment) {
      console.log(appointment);
      if(confirm("진료를 취소하시겠습니까?")){
        if(appointment.status === 'WAITING') {
          this.$store.dispatch('cancelApptByDoctor', appointment.appointmentId).then((res) => {
            console.log(res.data);
            alert('진료 취소 요청을 성공적으로 실행했습니다..');
            appointment.status = 'PENDING_CANCEL_DOCTOR';
          }).catch(e => console.log(e))
        }
      }
    },
    enterRoom(appointment) {
      if(appointment.status === 'OPEN') {
        this.$router.push({name: 'meetingRoom', params:{appointmentId: appointment.appointmentId, userType: 'U', myUserName: this.doctorName}});
      }
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
  width: 20%;
  display:flex;
  line-height: 100px;
}

.before{
  border-color: darkorange;
  color: darkorange;
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

.pending{
  border-color: darkblue;
  color: darkblue;
}
</style>
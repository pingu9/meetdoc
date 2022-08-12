<template>
  <div class="container-body">
    <div class="card w-90" id="noDoctorList" v-if="noData === true">
      <div class="card-body">
        <h5 class="card-title">진료 내역이 없습니다.</h5>
      </div>
    </div>

    <div v-else>
    <h1>{{doctorName}} 님의 진료내역</h1>
      <div class="card w-100" v-for="(chart, idx) in chartList" :key="idx" id="container-card">
        <div class="card-body" style="display:flex; height:100px;">
          <div class="container-status">
            <div :class="`circle ${chart.classname}`"></div><div :class="`status ${chart.classname}`">{{chart.title}}</div>
          </div>
          <div style="width:45%; text-align: left;">
            <h5 class="card-title" style="margin-top:5px">{{chart.patientName}}</h5>
            <p class="card-text" >{{chart.appointmentTime}}</p>
          </div>
          <div style="line-height: 65px; width:120px;">
          <!-- 리팩토링 필요-->
            <button class="btn btn-secondary" v-if="chart.status === 'PENDING_CANCEL_PATIENT'" @click="apprCancel(chart)">취소확인</button>
            <button class="btn btn-danger" v-else-if="chart.status === 'WAITING'" @click="cancelAppt(chart)">진료취소</button>
            <button class="btn btn-success" v-else-if="chart.status === 'OPEN'" @click="enterRoom(chart)">진료입장</button>
            <button class="btn btn-info" v-else-if="chart.status === 'PENDING_PRESCRIPTION'" @click="prescription(chart)" style="width:110px;">처방전작성</button>
          </div>
          <div style="line-height: 65px; width:120px;"><a :href="`/chart/detail/${chart.appointmentId}`" class="btn btn-primary">상세보기</a></div>
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
      chartList: [],
    }
  },
  components: {
  },
  computed: {
    ...mapState(['chartList'])
  },
  created() {
    const doctorId = localStorage.getItem('userId');
    this.$store.dispatch('getChartList', doctorId).then((res) => {
      console.log(res.data);
      //리스트 순서정렬, classname, title 지정
      if (res.data.message === 'no data') {
        this.noData = true;
      } else {
        const { data } = res;
        const openList = data.filter(({ status }) => status === 'OPEN').map(chart => {
          chart.classname = 'open';
          chart.title = '진료중';
          return chart;
        });
        const waitList = data.filter(({ status }) => status === 'WAITING').map(chart => {
          chart.classname = 'before';
          chart.title = '진료대기';
          return chart;
        });
        const pendingPreList = data.filter(({ status }) => status === 'PENDING_PRESCRIPTION').map((chart) => {
          chart.classname = 'pending';
          chart.title = '처방전 작성대기';
          return chart;
        });
        const pendingCancelPatList = data.filter(({ status }) => status === 'PENDING_CANCEL_PATIENT').map((chart) => {
          chart.classname = 'pendingPatient';
          chart.title = '환자 취소대기';
          return chart;
        });
        const pendingCancelDocList = data.filter(({ status }) => status === 'PENDING_CANCEL_DOCTOR').map((chart) => {
          chart.classname = 'pending';
          chart.title = '의사 취소대기';
          return chart;
        });
        const finishedList = data.filter(({ status }) => status === 'FINISHED').map((chart) => {
          chart.classname = 'done';
          chart.title = '진료완료';
          return chart;
        });
        const absentDocList = data.filter(({ status }) => status === 'DOCTOR_ABSENT').map((chart) => {
          chart.classname = 'canceled';
          chart.title = '의사 미접속';
          return chart;
        });
        const absentPatiList = data.filter(({ status }) => status === 'PATIENT_ABSENT').map((chart) => {
          chart.classname = 'canceled';
          chart.title = '환자 미접속';
          return chart;
        });
        const cancelList = data.filter(({ status }) => status === 'CANCELED').map((chart) => {
          chart.classname = 'canceled';
          chart.title = '취소완료';
          return chart;
        });
        this.chartList = [...openList, ...waitList, ...pendingPreList, ...pendingCancelPatList, ...pendingCancelDocList, ...finishedList, ...absentDocList, ...absentPatiList, ...cancelList];
        this.setChartList(res.data);
        this.doctorName = this.chartList[0].doctorName;
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
        this.$router.push({name: 'meetingRoom', params:{appointmentId: appointment.appointmentId, userType: localStorage.getItem('userType'), myUserName: this.doctorName}});
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
  width: 200px;
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
  border-color: black;
  color: black;
}

.pending{
  border-color: darkblue;
  color: darkblue;
}

.pendingPatient{
  border-color: red;
  color: red;
}
</style>
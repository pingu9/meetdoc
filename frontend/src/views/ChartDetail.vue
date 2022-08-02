<template>
<div class="container-body">
    <h1>진료 내역 상세</h1>
    <div class="container-card">
      <div class="card">
        <div class="card-body">
           <div class="card">
            <div class="card-body">
                <p class="card-title">환자 및 의사 정보</p>
                <div class="info-body">
                    <div class="row">
                        <div class="col"><p class="chartDetailData">환자명 : {{$store.state.chartDetail.patientName}}</p></div>
                        <div class="col"><p class="chartDetailData">생년월일 : {{$store.state.chartDetail.patientBirthdate}}</p></div>
                    </div>
                    <div class="row">
                        <div class="col"><p class="chartDetailData">병원명 : {{$store.state.chartDetail.hospitalName}}</p></div>
                        <div class="col"><p class="chartDetailData">병원 전화번호 : {{$store.state.chartDetail.hospitalPhone}}</p></div>
                    </div>
                    <div class="row">
                        <div class="col"><p class="chartDetailData">의사명 : {{$store.state.chartDetail.doctorName}}</p></div>
                    <div class="col"><p class="chartDetailData">면허번호 : {{$store.state.chartDetail.licenseNumber}}</p></div>
                    </div>
                    <div class="row">
                        <div class="col"><p class="chartDetailData">진료일 : {{$store.state.chartDetail.appointmentTime}}</p></div>
                        <div class="col"><p class="chartDetailData">병명 진단: {{$store.state.chartDetail.icd}}</p></div>
                    </div>
                </div>
            </div>
          </div>
          <div class="card">
            <div class="card-body">
                <p class="card-title">환자증상</p>
                <div class="symptom">
                    <p class="chartDetailData">{{$store.state.chartDetail.symptom}}</p>
                </div>
            </div>
          </div>
          <div class="card">
            <div class="card-body">
                <p class="card-title">처방전</p>
                <div class="prescription">
                    <p class="chartDetailData">{{$store.state.chartDetail.prescriptionDescription}}</p>
                </div>
            </div>
          </div>
          <div class="card">
            <div class="card-body">
            <p class="card-title">진료비</p>
            <div class="charge">
                <h4>Charge : ${{$store.state.chartDetail.charge}}</h4>
            </div>
            </div>
        </div>
        </div>
      </div>
    </div>
    <button @click="this.$router.go(-1)" class="btn btn-primary">확인</button>
  </div>
</template>

<script>
import { mapState, mapMutations } from 'vuex'
export default {
    computed: {
        ...mapState(['chartDetail']),
    },
    methods: {
    ...mapMutations(['setChartDetail',]),
    },
    created(){
        this.$store.dispatch('getChartDetail', this.$route.params.appointmentId).then((res) => {
            console.log(res.data);
            this.setChartDetail(res.data);
        })
    },

}
</script>

<style>

h3{
    text-align: right;
    margin: 10px;
}

.chartDetailData{
    text-align: left;
}

</style>
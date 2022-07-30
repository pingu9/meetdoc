<template>
  <div class="container-body">
    <h1>예약완료</h1>
    <div class="container-card">
     <div class="card">
        <div class="card-body">
          <img src="../assets/images/check.png" alt="confirmed" class="confirmed"/>
          <p class="card-title" id="confirmBold">{{patientName}} 님의 예약이 완료되었습니다.</p>
          <div class="info-box">
            <div class="half-box">
              <p class="title-box">의사명</p>
              <p class="title-box">진료과목</p>
              <p class="title-box">결제금액</p>
            </div>
            <div class="half-box">
              <p class="content-box">{{doctorName}}</p>
              <p class="content-box">{{departmentName}}</p>
              <p class="content-box">{{charge}}원</p>
            </div>
          </div>
          <hr>
          <p class="card-title" style="margin:20px 0">{{appointmentTime}}</p>
          <div class="d-grid gap-2">
            <a href="/" class="btn btn-primary" style="margin:10px">닫기</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      patientName: this.$route.params.patientName,
      doctorName: this.$route.params.doctorName,
      departmentName: this.$route.params.departmentName,
      charge: this.$route.params.charge,
      appointmentTime: this.$route.params.appointmentTime,
    }
  },
}
</script>

<style>
.title-box{
  font-size: 25px;
  margin: 50px 0px;
}

.content-box{
  font-size: 25px;
  margin: 50px 0px;
}

.confirmed{
  width: 50px;
  height: 50px;
  margin: 20px 0px;
}

.confirmBold{
  font-weight: bold;
}

</style>
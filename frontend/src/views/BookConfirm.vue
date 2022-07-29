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
          <p class="card-title" style="margin:20px 0">{{appointment}}</p>
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
      appointment: '',
    }
  },
  created() {
    //2022-08-01 09:00 => 2022년 8월 01일 월요일 09:00
    const year = new Date(this.appointmentTime).getFullYear();
    const month = new Date(this.appointmentTime).getMonth() + 1;
    const date = new Date(this.appointmentTime).getDate();
    const daybefore = new Date(this.appointmentTime).getDay();
    let day = '';
    switch (daybefore) {
      case 1:
        day = '월요일 ';
        break;
      case 2:
        day = '화요일 ';
        break;
      case 3:
        day = '수요일 ';
        break;
      case 4:
        day = '목요일 ';
        break;
      case 5:
        day = '금요일 ';
        break;
    }
    const hour = new Date(this.appointmentTime).getHours();
    let minuates = new Date(this.appointmentTime).getMinutes();
    if (minuates === 0) {
      minuates = '00';
    }
    //console.log(year + '년 ' + month + '월 ' + date + '일 ' + day + hour + ':' + minuates);
    this.appointment = year + '년 ' + month + '월 ' + date + '일 ' + day + hour + ':' + minuates;
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
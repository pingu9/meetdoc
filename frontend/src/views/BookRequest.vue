<template>
  <div class="container-body">
    <h1>진료 신청서</h1>
  <div class="container-card">
      <div class="card">
        <div class="card-body">
          <img src="../assets/images/doctor.jpg" class="img-thumbnail" alt="doctorImg" id="doctorImg"/>
          <p class="card-title">{{doctorName}}</p>
          <div>
              <h3 style="text-align: center;">예약하실 날짜 : {{appointmentTime}}</h3>
          </div>
          <div class="info-box">
            <div class="half-box">
              <form name="해당 폼의 이름" action="값을 보낼 주소" method="post">
                <input type='date' name='userBirthday'  @change="datePicked()" v-model="date"/>
            </form>
            </div>
            <div class="half-box">
              <div v-for="i in timeList" :key="i" id="times" >
                <span class="badge rounded-pill bg-info text-white" id="badge" @click="time = i">{{i}}</span>
              </div>
            </div>
          </div>
          <div>
            <p class="card-title">증상 입력</p>
            <div class="form-floating">
              <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px" v-model="symptom"></textarea>
              <label for="floatingTextarea2">증상에 대해 자세히 입력해주세요.</label>
            </div>
          </div>
          <div class="d-grid gap-2">
            <a href="#" class="btn btn-primary" @click="bookRequest()">진료 예약하기</a>
          </div>
        </div>
      </div>
    </div>
  </div>  
</template>

<script>

import { mapMutations } from 'vuex';
export default {
  data() {
    return {
      date: '',
      time: '',
      addTime: 30,
      timeList: [''],
      symptom: '',
      doctorName: '',
      doctorId: '',
      departmentName: '',
      appointmentTime: '',
    }
  },
  computed: {
  },
  methods: {
    ...mapMutations(['setBookInfo','setDoctorId']),
    datePicked() {
      //날짜 선택하면 기능
      const param = {
        doctorId: this.doctorId,
        selectedDate: this.date,
      };
      console.log(param);
      this.$store.dispatch('setAvailTime', param).then((a) => {
        console.log(a.data);
        console.log(a.data.result);
        this.appointmentTime = a.data.result[0];
      });
    },
    bookRequest() {
      //시간 api 구현 미완으로 sample data...
      let timeChanged = this.time.split(':');
      if (timeChanged[0].length == 1) {
        timeChanged = ' 0' + this.time;
      } else {
        timeChanged = ' ' + this.time;
      }
      //let apptDate = this.date + timeChanged;
      let bookReqInfo = {
        "patientId": localStorage.getItem('userId'),
        "doctorId": this.doctorId,
        "appointmentTime": this.appointmentTime,
        "symptom": this.symptom,
        "departmentName": this.$route.params.departmentName,
        "charge": 0
      };
      console.log('bookreq')
      console.log(bookReqInfo);
      //validation 추가, date, symptom 없을 경우 못하게
      if (this.symptom === '') {
        alert('증상을 입력해주세요!');
        return;
      }
      this.$store.dispatch('setBookReq', bookReqInfo).then((a) => {
        console.log(a.data);
        this.$router.push({
          name: 'bookConfirm',
            params: {
            patientName: a.data.patientName,
            doctorName: a.data.doctorName,
            departmentName: a.data.departmentName,
            charge: a.data.charge,
            appointmentTime: a.data.appointmentTime,
          }
        });
      }).catch(error => {
        console.log(error)
        alert('해당 날짜에 예약이 불가합니다!');
      });
    }
  },
  created() {
    //파라미터 값들 저장
    this.doctorId = this.$route.params.doctorId;
    this.departmentName = this.$route.params.departmentName;
    this.doctorName = this.$route.params.doctorName;
    this.setDoctorId(this.$route.params.doctorId);
    //의사 상세정보 api
    this.$store.dispatch('getDoctorDetail', this.doctorId).then((a) => {
      console.log(a.data);
    });
    //오늘 날짜 설정
    let todayDate = new Date();
    let yy = String(todayDate.getFullYear());
    let month = todayDate.getMonth() + 1;
    let mm = month < 10 ? '0' + month : month;
    let dd = String(todayDate.getDate() < 10 ? '0' + todayDate.getDate() : todayDate.getDate());

    //data 값 입력
    let date = yy + '-' + mm + '-' + dd;
    this.date = date;

    this.datePicked();

    //현재시간으로부터 시간 10개 뿌리기
    // var minStandard = min;
    // var houStandard = Number(hou);
    // for (let i = 0; i < 9; i++) {
    //   let added = '';
    //   if (minStandard == 30) {
    //     houStandard += 1;
    //     minStandard = 0;
    //     added += String(houStandard) + ':00';
    //   } else {
    //     added += String(houStandard) + ':30';
    //     minStandard = 30;
    //   }
    //   this.timeList.push(added);
    // }
  },
}
</script>

<style>
#doctorImg{
  width:35%;
  height:35%;
  margin: 10px;
}

#times{
  display: inline;
  margin: 5px;
}

#badge{
  font-size: 15px;
  padding:10px 20px;
  margin: 10px 0px;
}

#badge:hover{
  cursor:pointer;
}

.form-floating{
  margin: 20px;
}
</style>
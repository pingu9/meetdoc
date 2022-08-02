<template>
  <div class="container-body">
    <h1>진료 신청서</h1>
  <div class="container-card">
      <div class="card">
        <div class="card-body">
          <img src="../assets/images/doctor.jpg" class="img-thumbnail" alt="doctorImg" id="doctorImg"/>
          <p class="card-title">{{doctorName}}</p>
          <div id="date-select">
            <label class="date-picker-label">예약 날짜</label>
            <div class="col-auto">
              <input type='date' class="form-control" @change="datePicked()" v-model="date"/>
            </div>
          </div>
          <div class="time-container" v-if="timeList.length !== 0">
            <div v-for="(time, idx) in allTime" :key="idx">
              <input type="radio" :id="`avail-time-${idx}`" name="avail-time"/>
              <label :class="`btn btn-outline-primary avail-time-label ${timeCheckList[idx] ? '' : 'time-disabled'}`" :for="`avail-time-${idx}`" @click="appointmentTime = time;">{{time}}</label>
            </div>
          </div>
          <div class="no-time-avail" v-else>
           휴무일이거나 예약 가능한 시간이 없습니다.
          </div>
          <div class="symptom-container">
            <div class="form-floating">
              <textarea placeholder="증상에 대해 자세히 입력해주세요." id="symptom-textarea" style="height: 100px" v-model="symptom"></textarea>
            </div>
          </div>
          <div class="d-grid gap-2 btn-container">
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
      allTime: ['9:00', '9:30', '10:00', '10:30',
        '11:00', '11:30', '13:00', '13:30',
        '14:00', '14:30', '15:00', '15:30',
        '16:00', '16:30', '17:00', '17:30'],
      timeList: [],
      timeCheckList:[],
      symptom: '',
      doctorName: '',
      doctorId: '',
      departmentName: '',
      appointmentTime: undefined,
      apptDateTime: '',
    }
  },
  computed: {
  },
  methods: {
    ...mapMutations(['setBookInfo', 'setDoctorId']),
    datePicked() {
      this.timeList = [];
      this.timeCheckList = [];
      //날짜 선택하면 기능
      const param = {
        doctorId: this.doctorId,
        selectedDate: this.date,
      };
      console.log(param);
      this.$store.dispatch('setAvailTime', param).then((a) => {
        console.log(a.data.result);
        //받아온 timeList 시간 추출
        let hour = '';
        let minuates = '';
        a.data.result.forEach(element => {
          hour = new Date(element).getHours();
          minuates = new Date(element).getMinutes();
          if (minuates === 0) {
            minuates = '00';
          }
          element = hour + ':' + minuates;
          this.timeList.push(element);
        });
        console.log(this.timeList);

        //예약이 있는 시간 리스트 추출, 예약 가능시 true, 불가시 false
        for (let i = 0; i < this.allTime.length; i++) {
          if (this.timeList.includes(this.allTime[i])) {
            this.timeCheckList.push(true);
          } else {
            this.timeCheckList.push(false);
          }
        }

        console.log([...this.timeCheckList]);

        //선택한 예약시간이 없을 경우(날짜 선택만 된 초기) 기본 default값 가장 첫번째 예약 가능시간으로 설정
        if (this.appointmentTime === '') {
          this.appointmentTime = a.data.result[0];
        }
        console.log(this.appointmentTime);
      });
    },
    bookRequest() {
      //validation 추가, date, symptom 없을 경우 못하게
      console.log(this.appointmentTime);
      if (this.symptom === '') {
        alert('증상을 입력해주세요!');
        return;
      } else if (!this.appointmentTime) {
        alert('예약 날짜와 시간을 선택해주세요!');
        return;
      }

      if (!confirm('예약을 확정하시겠습니까?')) {
        return;
      }

      if (this.appointmentTime.length === 4) {
        this.apptDateTime = this.date + ' 0' + this.appointmentTime;
      } else {
        this.apptDateTime = this.date + ' ' + this.appointmentTime;
      }
      let bookReqInfo = {
        "patientId": localStorage.getItem('userId'),
        "doctorId": this.doctorId,
        "appointmentTime": this.apptDateTime,
        "symptom": this.symptom,
        "departmentName": this.departmentName,
        "charge": 0
      };
      console.log(bookReqInfo);
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
    this.$store.state.doctorId = this.doctorId;
    console.log(this.$store.state.doctorId);
    this.departmentName = this.$route.params.departmentName;
    this.doctorName = this.$route.params.doctorName;
    this.setDoctorId(this.doctorId);
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

    //오늘 date 값 입력
    let date = yy + '-' + mm + '-' + dd;
    this.date = date;

    this.datePicked();
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

.btn-container {
  margin-top: 10px;
}

#date-select{
  display: flex;
  justify-content: center;
  align-items: center;
}

.time-container {
  margin-top: 20px;
	display: grid;
  gap: 10px;
	grid-template-columns: repeat(4, 1fr);
}

.time-container input {
  display: none;
}

.avail-time-label {
  width: 100%;
}

.time-container input:checked+label {
  color: #fff;
  background-color: #0d6efd;
}

.time-disabled{
  pointer-events: none;
  background-color: lightgray;
  color:rgb(148, 146, 146);
  border:1px solid rgb(148, 146, 146);
}

.symptom-container{
  margin-top: 20px;
}

#symptom-textarea{
  height: 120px;
  width: 100%;
  resize: none;
  border: 1px solid lightgray;
  padding: 10px;
  outline: none;
  border-radius: 5px;
}

.no-time-avail{
  margin-top: 20px;
  font-weight: bold;
  font-size: 20px;
}

.date-picker-label {
  margin-right: 10px;
}
</style>
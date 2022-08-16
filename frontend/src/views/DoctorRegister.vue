<template>
  <div class="container-body">
    <h1>의사 등록</h1>
    <div>
      <div class="textForm">
        <input name="hospital-name" type="text" class="input-field" placeholder="병원명" v-model="hospitalName">
      </div>
      <div class="textForm">
        <input name="hospital-phone" type="text" class="input-field" placeholder="병원 연락처" v-model="hospitalPhone">
      </div>
      <span v-show="!phoneValid && hospitalPhone" class="input-error">
        전화번호 형식에 맞게 정확히 입력해주세요.
      </span>
      <div class="textForm">
        <input name="hospital-address" type="text" class="input-field" placeholder="병원 주소" @click="execDaumPostcode()"
          v-model="hospitalAddress">
      </div>
      <div class="textForm">
        <input name="hospital-zipcode" type="text" class="input-field" placeholder="병원 우편번호" @click="execDaumPostcode()"
          v-model="hospitalZipcode">
      </div>
      <div class="textForm">
        <input name="hospital-description" type="text" class="input-field" placeholder="병원 상세 정보" maxlength="254"
          v-model="hospitalDescription">
      </div>
      <div class="textForm">
        <input name="license-number" type="text" class="input-field" placeholder="의사 면허 등록번호" v-model="licenseNumber">
      </div>

      <hr />
      <h3 class="text-center">진료과 선택</h3>
      <small>최소 1개 이상 선택해 주세요.</small><br /><br />
      <div>
        <div v-for="(department, idx) in $store.state.departments" :key="idx" class="form-check form-check-inline">
          <input class="form-check-input" type="checkbox" v-model="this.departments" :value="department">
          <label class="form-check-label" for="inlineCheckbox1">{{ department.departmentName }}</label>
        </div>
      </div>
      <hr />


      <h3 class="text-center">진료 시간 선택</h3>
      <small>30분 단위로 선택 가능합니다.<br/>점심시간은 1시간 입니다.</small><br /><br />
      <div id="opening-hours-select" class="col-md-3">
        <div id="selected-input" class="mb-3">
          <div class="select">
            <select class="form-select" aria-label="Default select example" v-model="selectedDay">
              <option selected>요일 선택</option>
              <option v-for="(day,idx) in dayOfWeeks" :value="day" :key="idx">{{day}}</option>
            </select>
          </div>
          <div class="select">
            <select class="form-select" aria-label="Default select example" v-model="selectedStartTime">
              <option selected>여는 시간</option>
              <option v-for="(hour,idx) in hours" :value="hour" :key="idx">{{hour}}</option>
            </select>
          </div>
          <div class="select">
            <select class="form-select" aria-label="Default select example" v-model="selectedEndTime">
              <option selected>닫는 시간</option>
              <option v-for="(hour,idx) in hours" :value="hour" :key="idx">{{hour}}</option>
            </select>
          </div>
          <div class="select">
            <select class="form-select" aria-label="Default select example" v-model="selectedLunchTime">
              <option selected>점심 시간</option>
              <option v-for="(hour,idx) in hours" :value="hour" :key="idx">{{hour}}</option>
            </select>
          </div>          
          <button class="btn btn-primary" @click="selectOpeningHours();">추가</button>
        </div>
        <div id="selected-data">
          <ul class="list-group">
            <li class="list-group-item hour-item" v-for="(item, idx) in openingHours" :key="idx">
              <div class="item">{{dayOfWeekConvert(item.dayOfTheWeek)}}</div>
              <div class="item">영업시간 : {{ item.open }} ~ {{ item.close }}</div>
              <div class="item">점심시간 : {{ item.lunchHour }}</div>
            </li>
          </ul>
        </div>
      </div>
      <hr />

      <button class="btn btn-primary registerDoctor" type="submit" @click="submitForm()">등록 완료</button>
      <div>

      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  data() {
    return {
      hospitalName: '',
      hospitalPhone: '',
      hospitalZipcode: '',
      hospitalAddress: '',
      hospitalDescription: '',
      departments: [],
      licenseNumber: '',
      openingHours: [], //샘플 데이터 { dayOfTheWeek: 'Mon', open: '5:00', close: '19:00', lunchHour: '12:00'}
      selectedDay : '요일 선택',
      selectedStartTime: '여는 시간',
      selectedEndTime: '닫는 시간',
      selectedLunchTime: '점심 시간',
      phoneValid: false,
      phoneHasError: false,
      dayOfWeeks: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
      isDayOfWeeksSelected: {'월요일' : false, '화요일' : false, '수요일' : false, '목요일' : false, '금요일' : false, '토요일' : false, '일요일' : false},
      hours: [
        '0:00','0:30','1:00','1:30','2:00','2:30','3:00','3:30','4:00','4:30',
        '5:00','5:30','6:00','6:30','7:00','7:30','8:00','8:30','9:00','9:30',
        '10:00','10:30', '11:00', '11:30', '12:00','12:30','13:00', '13:30',
        '14:00','14:30', '15:00', '15:30', '16:00', '16:30', '17:00', '17:30',
        '18:00','18:30','19:00','19:30','20:00','20:30','21:00','21:30','22:00',
        '22:30','23:00','23:30','24:00',
      ],
    }
  },
  computed: {
    ...mapState(['currentUser']),
  },
  methods: {
    submitForm() {
      if (!this.emptyColoumn() || !this.phoneValid) {
        alert("입력한 항목들을 확인해주세요. 항목들을 모두 입력해야 합니다.")
        return;
      }
      if (confirm("의사 등록 후에는 진료예약기능과 이전의 예약내역들을 확인할 수 없습니다.\n의사 등록을 하시겠습니까?")) {
        this.$store.dispatch('doctorRegist', {
          doctorId: this.currentUser.userId,
          hospitalName: this.hospitalName,
          hospitalPhone: this.hospitalPhone,
          hospitalZipcode: this.hospitalZipcode,
          hospitalAddress: this.hospitalAddress,
          hospitalDescription: this.hospitalDescription,
          departments: this.departments,
          licenseNumber: this.licenseNumber
        }).then(() => {
          this.$store.dispatch('setOpeningHour', {
            doctorId: this.currentUser.userId,
            openingHours: this.openingHours,
          })
        })
      }
    },
    emptyColoumn() {
      if (this.hospitalName && this.hospitalPhone && this.hospitalZipcode &&
        this.hospitalAddress && this.hospitalDescription && this.licenseNumber && this.departments.length > 0) return true;
      return false;
    },
    execDaumPostcode() {
      new window.daum.Postcode({
        oncomplete: (data) => {
          if (this.extraAddress !== "") {
            this.extraAddress = "";
          }
          if (data.userSelectedType === "R") {
            // 사용자가 도로명 주소를 선택했을 경우
            this.hospitalAddress = data.roadAddress;
          } else {
            // 사용자가 지번 주소를 선택했을 경우(J)
            this.hospitalAddress = data.jibunAddress;
          }

          // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
          if (data.userSelectedType === "R") {
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
              this.extraAddress += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if (data.buildingName !== "" && data.apartment === "Y") {
              this.extraAddress +=
                this.extraAddress !== ""
                  ? `, ${data.buildingName}`
                  : data.buildingName;
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if (this.extraAddress !== "") {
              this.extraAddress = `(${this.extraAddress})`;
            }
          } else {
            this.extraAddress = "";
          }
          // 우편번호를 입력한다.
          this.hospitalZipcode = data.zonecode;
        },
      }).open();
    },
    checkPhone() {
      const validatePhoneNumber = /^\d{2,3}-\d{3,4}-\d{4}$/;

      if (!validatePhoneNumber.test(this.hospitalPhone) || !this.hospitalPhone) {
        this.phoneValid = false;
        this.phoneHasError = true;
      }
      else {
        this.phoneValid = true;
        this.phoneHasError = false;
      }
    },    
		selectOpeningHours() {
      //빈칸 체크
      if((!this.selectedDay || this.selectedDay != '요일 선택') && (!this.selectedStartTime || this.selectedStartTime != '여는 시간')
      && (!this.selectedEndTime || this.selectedEndTime  != '닫는 시간') && (!this.selectedLunchTime || this.selectedLunchTime != '점심 시간')) {
        //pass
      } else {
        alert("시간을 모두 입력해주세요.")
        return
      }
      //요일 중복 확인
      if(this.isDayOfWeeksSelected[this.selectedDay]) {
        alert("이미 선택된 요일입니다.")
        return
      }
      //open close 시간 유효성 검사
      if(this.changeTimeToInt(this.selectedStartTime) >= this.changeTimeToInt(this.selectedEndTime)) {
        alert("여는 시간이 닫는 시간보다 빠르거나 같습니다.")
        return
      }
      //점심시간 유효성 검사
      if(this.changeTimeToInt(this.selectedStartTime) > this.changeTimeToInt(this.selectedLunchTime) || this.changeTimeToInt(this.selectedEndTime) <= this.changeTimeToInt(this.selectedLunchTime)) {
        alert("점심시간이 영업시간 중이 아닙니다.")
        return
      }
      this.openingHours.push({ "dayOfTheWeek" : this.dayOfWeekConvert(this.selectedDay), "open" : this.selectedStartTime, "close" : this.selectedEndTime, "lunchHour" : this.selectedLunchTime });
      this.isDayOfWeeksSelected[this.selectedDay] = true;
      console.log(this.isDayOfWeeksSelected);
		},
    dayOfWeekConvert(str) {
      if(str == '월요일') return 'Mon'
      else if(str == '화요일') return 'Tue'
      else if(str == '수요일') return 'Wed'
      else if(str == '목요일') return 'Thu'
      else if(str == '금요일') return 'Fri'
      else if(str == '토요일') return 'Sat'
      else if(str == '일요일') return 'Sun'
      else if(str == 'Mon') return '월'
      else if(str == 'Tue') return '화'
      else if(str == 'Wed') return '수'
      else if(str == 'Thu') return '목'
      else if(str == 'Fri') return '금'
      else if(str == 'Sat') return '토'
      else if(str == 'Sun') return '일'
    },    
		changeTimeToInt(target) {      
      return parseInt(target.replace(":"));
		}
  },
  created() {
    let userId = localStorage.getItem('userId');
    this.$store.dispatch('getCurrentUserInfo', userId);
    this.$store.dispatch('getDepartments');
  },
  watch: {
    'hospitalPhone': function () {
      this.checkPhone()
    }
  }
}
</script>

<style>
.registerDoctor {
  margin-top: 20px;
}

* {
  margin: 0px;
  padding: 0px;
  text-decoration: none;
  font-family: sans-serif;

}

body {
  background-image: #34495e;
}

.joinForm {
  position: absolute;
  width: 400px;
  height: 400px;
  padding: 30px, 20px;
  background-color: #FFFFFF;
  text-align: center;
  top: 40%;
  left: 50%;
  transform: translate(-50%, -50%);
  border-radius: 15px;
}

.textForm {
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}

.input-field {
  width: 100%;
  border: none;
  outline: none;
  color: #636e72;
  font-size: 16px;
  height: 25px;
  background: none;
}

.text-center {
  text-align: center;
}

#opening-hours-select {
  width: 100%;
}

#selected-input {
  display: flex;
}

.select {
  margin: auto auto auto 0;
}

.hour-item {
  display: flex;
  width: 100%;
}

.item {
  margin: auto;
}

#selected-data {
  white-space: pre;
  overflow-y: auto;
  height: 300px;
  border: 0.5px solid rgb(223, 223, 223);
}
</style>
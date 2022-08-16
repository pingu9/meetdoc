<template>
  <div class="container-body">
    <h1>의사 등록</h1>
    <form @submit.prevent="submitForm">
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
          <label for="selected-day" class="mr-sm-2">요일</label>
          <b-form-select id="selected-day" class="mb-2 mr-sm-2 mb-sm-0" :options="dayOption"></b-form-select>
          <label for="selected-start-time" class="mr-sm-2">시작 시간</label>
          <b-form-select id="selected-start-time" class="mb-2 mr-sm-2 mb-sm-0" :options="timeOption"></b-form-select>
           <label for="selected-end-time" class="mr-sm-2">종료 시간</label>
          <b-form-select id="selected-end-time" class="mb-2 mr-sm-2 mb-sm-0" :options="timeOption"></b-form-select>
           <label for="selected-lunch-time" class="mr-sm-2">점심 시간</label>
          <b-form-select id="selected-lunch-time" class="mb-2 mr-sm-2 mb-sm-0" :options="timeOption"></b-form-select>
          <button class="btn btn-primary" @click="selectOpeningHours();">추가</button>
        </div>
        <div id="selected-data">
          <b-list-group class="border-0" v-for="(item, idx) in openingHours" v-bind:key="idx">            
          
            <b-row no-gutters>
            <b-col md="2">
              <p>{{ item.day }}</p>
            </b-col>            
            <b-col md="10">
              <p>영업시간 : {{ item.startTime }} ~ {{ item.endTime }}</p>
              <p>점심시간 : {{ item.lunchTime }}</p>
            </b-col>               
            </b-row>
          </b-list-group>
        </div>
      </div>
      <hr />

      <button class="btn btn-primary registerDoctor" type="submit">등록 완료</button>
      <div>

      </div>
    </form>
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
      openingHours: [{ day: '월', startTime: '5:00', endTime: '19:00', lunchTime: '12:00' }], //샘플 데이터
      selectedDay : '',
      selectedStartTime: '',
      selectedEndTime: '',
      selectedLunchTime: '',
      timeOption: [{ text: '선택', value: null }, { text: '월', value: '월' }, { text: '화', value: '화' }, { text: '수', value: '수' }, { text: '목', value: '목' }, { text: '금', value: '금' }, { text: '토', value: '토' }, { text: '일', value: '일' }],
      dayOption: [{ text: '선택', value: null }, '월', '화', '수', '목', '금', '토', '일'],
      phoneValid: false,
      phoneHasError: false,
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
      this.openingHours.push({ "day" : this.selectedDay, "startTime" : this.selectedStartTime, "endTime" : this.selectedEndTime, "lunchTime" : this.selectedLunchTime });
		},
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

#selected-data {
  white-space: pre;
  overflow-y: auto;
  height: 300px;
  border: 1px solid gray;
}
</style>
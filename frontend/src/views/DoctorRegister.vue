<template>
  <div class="container-body">
    <h4>의사 등록하기</h4>
    <form @submit.prevent="submitForm">
      <div class="input-group mt-3 mb-3">
        <span class="input-group-text" id="basic-addon1">Doctor ID</span>
        <div type="text" class="form-control" placeholder='Doctor ID(MeetDoc ID)' aria-label="Username" aria-describedby="basic-addon1">{{currentUser.userId}}</div>
      </div>
      <div class="input-group mt-3">
        <span class="input-group-text" id="inputGroup-sizing-default">병원명</span>
        <input type="text" v-model="hospitalName" class="form-control" placeholder="" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
      </div>
      <div class="input-group mt-3">
        <span class="input-group-text" id="inputGroup-sizing-default">병원 연락처</span>
        <input type="text" v-model="hospitalPhone" class="form-control" placeholder="000-0000-0000" aria-label="Username">
      </div>
      <span v-show="!phoneValid && hospitalPhone" class="input-error">
          전화번호 형식에 맞게 정확히 입력해주세요.
      </span>
      <div class="input-group mt-3">
        <span class="input-group-text" id="inputGroup-sizing-default">주소</span>
        <input type="text" v-model="hospitalAddress" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" @click="execDaumPostcode()">
      </div>
      <div class="input-group mt-3">
        <span class="input-group-text" id="inputGroup-sizing-default">우편번호</span>
        <input type="text" v-model="hospitalZipcode" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" @click="execDaumPostcode()">
      </div>
      <div class="input-group mt-3">
        <span class="input-group-text" id="inputGroup-sizing-default">병원 상세정보</span>
        <input type="text" v-model="hospitalDescription" class="form-control" placeholder="255자" maxlength="254" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
      </div>
      <div class="input-group mt-3">
        <span class="input-group-text" id="inputGroup-sizing-default">의사면허 등록번호</span>
        <input type="text" v-model="licenseNumber" class="form-control" placeholder="000000-0000000" aria-label="Server">
      </div>
      <div>
        <div v-for="(department, idx) in $store.state.departments" :key="idx" class="form-check form-check-inline">
          <input class="form-check-input" type="checkbox" v-model="this.departments" :value="department" >
          <label class="form-check-label" for="inlineCheckbox1">{{department.departmentName}}</label>
        </div>
      </div>
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
      phoneValid: false,
      phoneHasError: false,
    }
  },
  computed: {
    ...mapState(['currentUser']),
  },
  methods: {
    submitForm () {
      if(!this.emptyColoumn() || !this.phoneValid){
        alert("입력한 항목들을 확인해주세요. 항목들을 모두 입력해야 합니다.")
        return;
      }
      if(confirm("의사 등록 후에는 진료예약기능과 이전의 예약내역들을 확인할 수 없습니다.\n의사 등록을 하시겠습니까?")){
        this.$store.dispatch('doctorRegist', {
          doctorId : this.currentUser.userId,
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
    emptyColoumn () {
      if(this.hospitalName && this.hospitalPhone && this.hospitalZipcode && 
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
.registerDoctor{
  margin-top: 20px;
}
</style>
<template>
  <div class="container-body">
    <h4>의사 등록하기</h4>
    <form @submit.prevent="submitForm">
      <div class="input-group mt-3 mb-3">
        <span class="input-group-text" id="basic-addon1">Doctor ID</span>
        <input type="text" class="form-control" v-model="doctorId"  placeholder='Doctor ID(MeetDoc ID)' aria-label="Username" aria-describedby="basic-addon1">
      </div>
      <div class="input-group mb-3">
        <span class="input-group-text" id="inputGroup-sizing-default">병원명</span>
        <input type="text" v-model="hospitalName" class="form-control" placeholder="" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
      </div>
      <div class="input-group mb-3">
        <span class="input-group-text" id="inputGroup-sizing-default">병원 연락처</span>
        <input type="text" v-model="hospitalPhone" class="form-control" placeholder="000-0000-0000" aria-label="Username">
      </div>
      <div class="input-group mb-3">
        <span class="input-group-text" id="inputGroup-sizing-default">주소</span>
        <input type="text" v-model="hospitalAddress" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
      </div>
      <div class="input-group mb-3">
        <span class="input-group-text" id="inputGroup-sizing-default">병원 상세정보</span>
        <input type="text" v-model="hospitalDescription" class="form-control" placeholder="" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
      </div>
      <div class="input-group mb-3">
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
      doctorId : '' ,
		  hospitalName: '',
		  hospitalPhone: '',
		  hospitalZipcode: '',
	    hospitalAddress: '',
		  hospitalDescription: '',
		  departments: [],
		  licenseNumber: '',
    }
  },
  computed: {
    ...mapState(['currentUser']),
  },
  methods: {
      submitForm () {
      console.log(this.doctorId)
      this.$store.dispatch('doctorRegist', {doctorId : this.doctorId, hospitalName: this.hospitalName,
      hospitalPhone: this.hospitalPhone, hospitalZipcode: this.hospitalZipcode, hospitalAddress: this.hospitalAddress,
      hospitalDescription: this.hospitalDescription, departments: this.departments, licenseNumber: this.licenseNumber})
    }
  },
  created() {
    this.$store.dispatch('getDepartments');
  }
}
</script>

<style>
.registerDoctor{
  margin-top: 20px;
}
</style>
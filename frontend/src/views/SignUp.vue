<template>
  <div class="container-body">
    <h4>Signup</h4>
    <form @submit.prevent="submitForm">
      <div class="input-group mt-3 mb-3">
        <span class="input-group-text" id="basic-addon1">Username</span>
        <input type="text" class="form-control" v-model="userId"  placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
        <button class="btn btn-outline-secondary" type="button" @click="checkId()" id="button-addon2">중복확인</button>
        <span v-if="errorMessages">{{errorMessages.idCheckMessage}}</span>
      </div>
      <div class="form-group mb-3">
        <label class="form-label" for="inputPass">비밀번호</label>
        <input type="password" v-model="password" class="form-control is-valid" id="inputPass">
        <div class="valid-feedback"></div>
      </div>
     
      <div class="input-group mb-3">
        <span class="input-group-text" id="inputGroup-sizing-default">이름</span>
        <input type="text" v-model="userName" class="form-control" placeholder="이름" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
      </div>
      <div class="input-group mb-3">
        <span class="input-group-text" id="inputGroup-sizing-default">주민등록번호</span>
        <input type="text" v-model="rrn" class="form-control" placeholder="123456-1234567" aria-label="Username">
      </div>
      <div class="input-group mb-3">
        <span class="input-group-text" id="inputGroup-sizing-default">주소</span>
        <input type="text" v-model="address" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
      </div>
      <div class="input-group mb-3">
        <span class="input-group-text" id="inputGroup-sizing-default">전화번호</span>
        <input type="text" v-model="phone" class="form-control" placeholder="010-0000-0000" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
      </div>
      <div class="input-group mb-3">
        <span class="input-group-text" id="inputGroup-sizing-default">email</span>
        <input type="text" v-model="email" class="form-control" placeholder="example@naver.com" aria-label="Server">
      </div>
      <button class="btn btn-primary btn-lg btn-block" type="submit">가입 완료</button>
    </form>
  </div>
</template>

<script>
import { mapState } from 'vuex'
export default {
  data() {
    return {
      userId: '',
      password: '',
      rrn: '',
      userName: '',
      phone:'',
      zipcode: '',	    
      address: '',
      email: '',
      birthdate: '',
      gender: '',
      userType: '',
    }
  },
  computed: {
    ...mapState(['errorMessages'])
  },

  methods: {
    checkId () {
      if (this.userId) {
        console.log(this.userId)
        this.$store.dispatch('checkId', this.userId)
      }
    },
    submitForm () {
      console.log('submit')
      console.log(this.userName)
      this.$store.dispatch('signUp', {userId : this.userId, password: this.password,
      rrn: this.rrn, userName: this.userName, phone: this.phone, zipcode: this.zipcode,
      address: this.address, email: this.email, birthdate: this.birthdate,
      gender: this.gender, userType: this.userType})
    }
  }
}
</script>

<style>

</style>
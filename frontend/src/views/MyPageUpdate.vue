<template>
  <div class="container-body">
    <h4>회원 정보 수정</h4>
    <form @submit.prevent="submitForm">
      <div class="input-group mt-3 mb-3">
        <span class="input-group-text" id="basic-addon1">Username</span>
        <span class="form-control" aria-label="UserId" aria-describedby="basic-addon1">{{currentUser.userId}}</span>
      </div>
      <div class="form-group mb-3">
        <label class="form-label" for="inputPass">새 비밀번호</label>
        <input type="password" v-model="password" class="form-control" id="inputPass">
        <div class="valid-feedback"></div>
        <p v-show="valid.password" class="">
          비밀번호를 정확히 입력해주세요.
        </p>
      </div>
     
      <div class="input-group mb-3">
        <span class="input-group-text" id="inputGroup-sizing-default">이름</span>
        <span class="form-control"   aria-label="Username" aria-describedby="basic-addon1">{{currentUser.userName}}</span>
      </div>
      <div class="input-group mb-3">
        <span class="input-group-text" id="inputGroup-sizing-default">주민등록번호</span>
        <span class="form-control"  placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">{{currentUser.rrn}}</span>
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
        <p
          v-show="valid.email"
          class="input-error">
          이메일 주소를 정확히 입력해주세요.
        </p>
      <button class="btn btn-primary btn-lg btn-block" type="submit">수정</button>
    </form>
  </div>
  
</template>

<script>
import { mapState } from 'vuex';
export default {

data() {
    return {
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
      valid: {
        password: false,
      },
      passwordHasError: false,
    }
  },
watch: {
    'password': function () {
      this.checkPass()
    },
    'email': function() {
      this.checkEmail()
    },
  },
computed: {
    ...mapState(['currentUser','errorMessages']),
  },
created() {
    let userId = localStorage.getItem('userId');
    this.$store.dispatch('getCurrentUserInfo', userId);
  },
methods: {
    checkPass () {
      const validatePassword = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/
      if (!validatePassword.test(this.password)|| !this.password) {
        this.valid.password = true
        this.emailHasError = true
        return
      } this.valid.password = false
        this.passwordHasError = false
    },
    checkEmail() {
      // 이메일 형식 검사
      const validateEmail = /^[A-Za-z0-9_\\.\\-]+@[A-Za-z0-9\\-]+\.[A-Za-z0-9\\-]+/

      if (!validateEmail.test(this.email) || !this.email) {
        this.valid.email = true
        this.emailHasError = true
        return
      } this.valid.email = false
        this.emailHasError = false
    },
    submitForm () {
      console.log('submit')
      console.log(this.userType)
      this.$store.dispatch('update', { password: this.password,
      rrn: this.rrn, userName: this.userName, phone: this.phone, zipcode: this.zipcode,
      address: this.address, email: this.email, birthdate: this.birthdate,
      gender: this.gender, userType: this.userType})
    }
}

}
</script>

<style>

</style>
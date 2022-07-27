<template>
  <div class="container-body">
    <h4>Signup</h4>
    <div class="input-group mb-3">
      <span class="input-group-text" id="basic-addon1">Username</span>
      <input type="text" class="form-control" v-model="username"  placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
      <button class="btn btn-outline-secondary" type="submit" @click="checkId()" id="button-addon2">중복확인</button>
      <span v-if="errorMessages">{{errorMessages.idCheckMessage}}</span>
    </div>
    <div class="form-group has-success">
      <label class="form-label" for="inputValid">비밀번호</label>
      <input type="password" class="form-control is-valid" id="inputValid">
      <div class="valid-feedback"></div>
    </div>
    <div class="form-group has-danger mb-3">
      <label class="form-label" for="inputValid">비밀번호 확인</label>
      <input type="password" class="form-control is-invalid" id="inputValid">
      <div class="invalid-feedback"></div>
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text" id="inputGroup-sizing-default">이름</span>
      <input type="text" class="form-control" placeholder="이름" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text" id="inputGroup-sizing-default">주민등록번호</span>
      <input type="text" class="form-control" placeholder="123456-1234567" aria-label="Username">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text" id="inputGroup-sizing-default">주소</span>
      <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text" id="inputGroup-sizing-default">전화번호</span>
      <input type="text" class="form-control" placeholder="010-0000-0000" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
    </div>
    <div class="input-group mb-3">
      <span class="input-group-text" id="inputGroup-sizing-default">email</span>
      <input type="text" class="form-control" placeholder="id" aria-label="Username">
      <span class="input-group-text">@</span>
      <input type="text" class="form-control" placeholder="naver.com" aria-label="Server">
    </div>
    <button class="btn btn-primary btn-lg btn-block" type="submit">가입 완료</button>



    <!-- 회원가입 2 -->
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3">회원가입2</h4>
        <form class="validation-form" novalidate>
          <div class="row">
            <div class="col-md-6 mb-3">
              <label for="name">이름</label>
              <input type="text" class="form-control" id="name" placeholder="" value="" required>
              <div class="invalid-feedback">
                이름을 입력해주세요.
              </div>
            </div>
            <div class="col-md-6 mb-3">
              <label for="nickname">별명</label>
              <input type="text" class="form-control" id="nickname" placeholder="" value="" required>
              <div class="invalid-feedback">
                별명을 입력해주세요.
              </div>
            </div>
          </div>

          <div class="mb-3">
            <label for="email">이메일</label>
            <input type="email" class="form-control" id="email" placeholder="you@example.com" required>
            <div class="invalid-feedback">
              이메일을 입력해주세요.
            </div>
          </div>

          <div class="mb-3">
            <label for="address">주소</label>
            <input type="text" class="form-control" id="address" placeholder="서울특별시 강남구" required>
            <div class="invalid-feedback">
              주소를 입력해주세요.
            </div>
          </div>

          <div class="mb-3">
            <label for="address2">상세주소<span class="text-muted">&nbsp;(필수 아님)</span></label>
            <input type="text" class="form-control" id="address2" placeholder="상세주소를 입력해주세요.">
          </div>

          
          <hr class="mb-4">
          <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="aggrement" required>
            <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
          </div>
          <div class="mb-4"></div>
          <button class="btn btn-primary btn-lg btn-block" type="submit">가입 완료</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex'
export default {
  data() {
    return {
      username: '',
      password1: '',
      password2: '',
    }
  },
  computed: {
    ...mapState(['errorMessages'])
  },

  methods: {
    checkId () {
      if (this.username) {
        console.log(this.username)
        this.$store.dispatch('checkId', this.username)
      }
    }
  }
}
</script>

<style>

</style>
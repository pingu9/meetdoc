<template>
<div class="modal fade" tabindex="-1" id="loginModal">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Login</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="form-floating mb-3">
        <input type="username" v-model="username" class="form-control" id="floatingInput" placeholder="Username">
        <label for="floatingInput">Username</label>
      </div>
      <div class="form-floating">
        <input type="password" v-model="password" class="form-control" id="floatingPassword" placeholder="Password">
        <label for="floatingPassword">Password</label>
        <a style="font-size: small; text-align: right;" href="">비밀번호 찾기</a>
      </div>
      <div class="modal-footer">
        <button type="submit" @click="clickLogin()" class="btn btn-primary">Login</button>
      </div>
    </div>
  </div>
</div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    clickLogin () {
      console.log(this.username)
      console.log(this.password)
      this.$store.dispatch('login',{userId: this.username, password: this.password})
    }
  }
}
</script>

<style>

</style>
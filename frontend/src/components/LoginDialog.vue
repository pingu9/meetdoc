<template>
<form @submit.prevent="loginForm" class="modal" tabindex="-1" id="loginModal">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">MeetDoc Login</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="form-floating mb-3">
        <input @keyup.enter="loginForm()" type="username" v-model="username" class="form-control" id="floatingInput" placeholder="Username">
        <label for="floatingInput">ID</label>
      </div>
      <div class="form-floating">
        <input @keyup.enter="loginForm()" type="password" v-model="password" class="form-control" id="floatingPassword" placeholder="Password">
        <label for="floatingPassword">비밀번호</label>
      </div>
      <div v-if="errorMessages">
        <span>{{errorMessages.loginErrorMessage}}</span>
      </div>
      <div class="modal-footer">
        <button type="submit" class="btn btn-primary">Login</button>
      <br>
      <span>
        <button type="button" class="btn btn-secondary">비밀번호 찾기</button>
      </span>
      </div>
    </div>
  </div>
</form>
</template>

<script>
import { mapState } from 'vuex'
export default {
  data() {
    return {
      username: '',
      password: '',
    }
  },
  computed: {
    ...mapState(['errorMessages'])
  },

  methods: {
    loginForm () {
      console.log(this.username)
      console.log(this.password)
      this.$store.dispatch('login',{userId: this.username, password: this.password})
      this.username=''
      this.password=''
    },
  }
}
</script>

<style>

</style>
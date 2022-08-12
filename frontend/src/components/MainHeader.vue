<template>
  <div class="container-header">
    <nav v-if="userType !== 'D'" class="navbar navbar-expand-lg navbar-dark bg-primary">
      <div class="container-fluid">
        <a class="navbar-brand font-do-hyeon" href="/">MeetDoc</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav" style="width:calc(100%- 82.43px)">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="/">Home</a>
            </li>
            <li class="nav-item" v-if="isLoggedIn && userType ==='D'">
              <a class="nav-link" href="/chart/list">진료 내역</a>
            </li>
            <li class="nav-item" v-if="isLoggedIn && userType ==='U'">
              <a class="nav-link" href="/book/list">예약 내역</a>
            </li>
            <li class="nav-item" v-if="isLoggedIn">
              <a class="nav-link" href="/mypage">MyPage</a>
            </li>
            <li class="nav-item" v-if="!isLoggedIn">
              <a class="nav-link" data-bs-toggle="modal" data-bs-target="#loginModal">Login</a>
            </li>
            <li class="nav-item" v-if="isLoggedIn">
              <a class="nav-link" @click="confirm()">Logout</a>
            </li>
            <li class="nav-item" v-if="!isLoggedIn">
              <a class="nav-link" href="/signup">Signup</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <nav v-if="userType === 'D'" class="navbar navbar-expand-lg navbar-dark bg-primary">
      <div class="container-fluid">
        <a class="navbar-brand" href="/chart/list">MeetDoc</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav" style="width:calc(100%- 82.43px)">
          <ul class="navbar-nav">
            <li class="nav-item" v-if="isLoggedIn && userType ==='D'">
              <a class="nav-link" href="/chart/list">진료 내역</a>
            </li>
            <li class="nav-item" v-if="isLoggedIn && userType ==='U'">
              <a class="nav-link" href="/book/list">예약 내역</a>
            </li>
            <li class="nav-item" v-if="isLoggedIn">
              <a class="nav-link" href="/mypage">MyPage</a>
            </li>
            <li class="nav-item" v-if="!isLoggedIn">
              <a class="nav-link" data-bs-toggle="modal" data-bs-target="#loginModal">login</a>
            </li>
            <li class="nav-item" v-if="isLoggedIn">
              <a class="nav-link" @click="confirm()">Logout</a>
            </li>
            <li class="nav-item" v-if="!isLoggedIn">
              <a class="nav-link" href="/signup">회원가입</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </div>
  <!-- <div class="container-header">
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
      <div class="container-fluid">
        <a class="navbar-brand" href="/">MeetDoc</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav" style="width:calc(100%- 82.43px)">
          <ul class="navbar-nav">
           
              <router-link class="nav-link active" :to="{name : home}">Home</router-link>
            
            <li class="nav-item" v-if="userType ==='D'">
              <a class="nav-link" href="/chart/list">진료 내역</a>
            </li>
            <li class="nav-item" v-if="userType ==='U'">
              <a class="nav-link" href="/book/list">예약 내역</a>
            </li>
            <li class="nav-item" v-if="token !== ''">
              <a class="nav-link" href="/mypage">MyPage</a>
            </li>
            <li class="nav-item" v-if="token === ''">
              <a class="nav-link" data-bs-toggle="modal" data-bs-target="#loginModal">login</a>
            </li>
            <li class="nav-item" v-if="token !== ''">
              <a class="nav-link" @click="confirm()">Logout</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/signup" v-if="token === ''">회원가입</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </div>
  <div><router-link class="nav-link active" :to="{name : home}">Home</router-link></div> -->
</template>

<script>
import { mapGetters, mapActions } from 'vuex';

export default {
  data() {
    return {
      get token() {
        return localStorage.getItem('token');
      },
      get userType() {
        return localStorage.getItem('userType')
      },
    }
  },

  methods: {
    //아래 부분 watcher로 수정해야함(중요)
    ...mapActions(['logout']),
    confirm() {
      this.logout()
      // if (confirm("로그아웃 하시겠습니까?")) {
      //   localStorage.setItem('token', '');
      //   localStorage.setItem('userId', '');
      //   localStorage.setItem('userType', '');
      //   // localStorage.setItem()
      //     alert("로그아웃 되었습니다.");
      //     this.$router.go();
      //     this.$router.push('/');
      //   } else {
      //   this.$router.push('/');
      //   }
    }
  },
  computed: {
      ...mapGetters(['isLoggedIn']),
  },
}
</script>

<style>

#navbarNav{
  justify-content: center;
  /* margin-left: 82.43px; */
  width: calc(100% - 82.43px);
}

#navbarNav li{
  margin: 0 20px;
}
</style>
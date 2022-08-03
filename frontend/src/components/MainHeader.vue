<template>
  <div class="container-header">
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">MeetDoc</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/">Home</a>
        </li>
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
        <!-- <li class="nav-item" v-if="!isLoggedIn">
          <a class="nav-link" data-bs-toggle="modal" data-bs-target="#loginModal">login33</a>
        </li>    -->
        <li class="nav-item" v-if="token !== ''">
          <a class="nav-link" @click="confirm()">Logout</a>
        </li>
        <li class="nav-item">
          <!-- <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">회원가입</a> -->
          <a class="nav-link" href="/signup" v-if="token === ''">회원가입</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
  </div>
</template>

<script>
export default {
  data() {
    return {
      token: '',
      userType: '',
    }
  },
  methods: {
    //아래 부분 watcher로 수정해야함(중요)
    confirm() {
      if (confirm("로그아웃 하시겠습니까?")) {
        localStorage.setItem('token', '')
        // localStorage.setItem()
          alert("로그아웃 되었습니다.");
          this.$router.go();
          this.$router.push('/');
        } else {
        this.$router.push('/');
        }
    }
  },

  created() {
    let token = localStorage.getItem('token');
    if (token != '') {
      console.log('token exists created');
      this.token = token;
      console.log(this.token);
    } else {
      console.log('no token created')
    }
    let userType = localStorage.getItem('userType');
    if (userType != '') {
      console.log(userType);
      this.userType = userType;
    }
  },
}
</script>

<style>

#navbarNav{
  justify-content: center;
}

#navbarNav li{
  margin: 0 20px;
}
</style>
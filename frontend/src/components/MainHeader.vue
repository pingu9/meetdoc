<template>
  <div>
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
        <li class="nav-item">
          <a class="nav-link" href="/chart/list">진료 내역</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/book/list">예약 내역</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/mypage">MyPage</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" data-bs-toggle="modal" data-bs-target="#loginModal">login</a>
        </li>
        <li class="nav-item">
          <!-- <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">회원가입</a> -->
          <a class="nav-link" href="/signup">회원가입</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
  </div>
</template>

<script>

export default {
  methods:{
  }
}
</script>

<style>

</style>
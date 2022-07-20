<template>
  <div>
  <h1>Main page 입니다. 여기에 헤더같이 고정되는거 넣으면 되요</h1>
  <router-link to="/mypage">MyPage</router-link>
  <router-link to="/">홈페이지</router-link>
  <div>
    <router-view></router-view>
  </div>
  </div>
</template>

<script>

export default {
  
}
</script>

<style>

</style>
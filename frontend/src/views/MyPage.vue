<template>
  <div class="container-body">
    <h4>MyPage</h4>
    <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">아이디 : {{currentUser.userId}}</div>
    <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">이름 : {{currentUser.userName}}</div>
    <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">성별 : {{currentUser.gender}}</div>
    <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">생년월일 : {{currentUser.birthdate}}</div>
    <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">주소 : {{currentUser.address}}</div>
    <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">연락처 번호 : {{currentUser.phone}}</div>
    <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">e-mail : {{currentUser.email}}</div>
    <div>
      <router-link :to="{ name: 'mypageUpdate' }">
        <button type="button" class="btn btn-outline-primary m-5">회원정보 수정</button>
      </router-link>
      <button type="button" @click="userDelete()" class="btn btn-outline-warning">회원탈퇴</button>
      <router-link v-if="currentUser.userType !== 'D'" :to="{ name: 'doctorRegist'}">
        <button type="button" class="btn btn-outline-primary m-5">의사 등록</button>
      </router-link>
    </div>
  </div>
  
</template>

<script>
import { mapState } from 'vuex'

export default {
data(){
    return{
    }
  },
  methods: {
    userDelete () {
      console.log('삭제요청')
    this.$store.dispatch('userDelete')
    this.$router.push('/')
    }
  },
  computed: {
    ...mapState(['currentUser']),
  },
  created() {
    let userId = localStorage.getItem('userId');
    // let token = localStorage.getItem('token');
    console.log(userId)
    this.$store.dispatch('getCurrentUserInfo', userId);
  },
}
</script>

<style>

</style>
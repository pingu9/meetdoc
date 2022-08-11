<template>
  <div class="container-body" v-if="userFlag">
    <div>
      <h4 style="text-align:left">{{currentUser.userName }} 환자</h4>
      <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">아이디 : {{currentUser.userId}}</div>
      <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">이름 : {{currentUser.userName}}</div>
      <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">구분 : {{currentUser.userType === 'U' ? '환자' : '의사'}}</div>
      <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">성별 : {{currentUser.gender === 'male' ? '남자' : '여자'}}</div>
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
  </div>
  <div class="container-body" v-if="doctorFlag">
    <div>
      <h4 style="text-align:left">{{currentUser.userName }} 선생님</h4>
      <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">아이디 : {{currentUser.userId}}</div>
      <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">이름 : {{currentUser.userName}}</div>
      <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">구분 : {{currentUser.userType === 'U' ? '환자' : '의사'}}</div>
      <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">성별 : {{currentUser.gender === 'male' ? '남자' : '여자'}}</div>
      <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">생년월일 : {{currentUser.birthdate}}</div>
      <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">주소 : {{currentUser.address}}</div>
      <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">연락처 번호 : {{currentUser.phone}}</div>
      <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">e-mail : {{currentUser.email}}</div>
    <hr>
    <div>
      <h4 style="text-align:left">병원 정보</h4>
      <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">병원명 : {{currentDoctorInfo.hospitalName}}</div>
      
      <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">병원 진료과 : 
        <span v-for="(departmentName, idx) in currentDoctorInfo.departmentNames" :key="idx">
          {{departmentName}}&nbsp;
        </span> 
      </div>
      <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">병원 연락처 : {{currentDoctorInfo.hospitalPhone}}</div>
      <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">병원 주소 : {{currentDoctorInfo.hospitalAddress}}</div>
      <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">병원 상세정보 : {{currentDoctorInfo.hospitalDescription}}</div>
      <!-- <div class="shadow-sm p-3 bg-body rounded p-3" style="margin:15px">병원 연락처 : {{currentDoctorInfo.hospitalPhone}}</div> -->
    </div>
      <div>
        <router-link :to="{ name: 'mypageUpdate' }">
          <button type="button" class="btn btn-outline-primary m-5">정보 수정</button>
        </router-link>
        <button type="button" @click="userDelete()" class="btn btn-outline-warning">회원탈퇴</button>
        <router-link v-if="currentUser.userType !== 'D'" :to="{ name: 'doctorRegist'}">
          <button type="button" class="btn btn-outline-primary m-5">의사 등록</button>
        </router-link>
      </div>
    </div>
  </div>
  
</template>

<script>
import { mapState } from 'vuex'

export default {
data(){
    return{
      userFlag : false,
      doctorFlag : false,
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
    ...mapState(['currentUser', 'currentDoctorInfo']),
  },
  created() {
    let userId = localStorage.getItem('userId');
    // let token = localStorage.getItem('token');
    this.$store.dispatch('getCurrentUserInfo', userId);
    let userType = localStorage.getItem('userType');
    if (userType === 'U') {
      this.userFlag = true
    } else {
      this.doctorFlag = true
    }
    console.log(this.doctorFlag + ' 닥터플래그')
    console.log(this.userFlag + ' 유저플래그')

  },
}
</script>

<style>

</style>
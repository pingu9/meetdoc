<template>
  <div class="container-body" v-if="userFlag">
    <div class="row">
        <div class="col-md border-right">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h4 class="text-right">{{currentUser.userName}} Profile</h4>
                </div>
                <div class="row mt-2">
                    <div class="col-md-6"><label class="labels">ID</label><div class="form-control">{{currentUser.userId}}</div></div>
                </div>
                <div class="row mt-3">
                    <div class="col-md-6"><label class="labels">성별</label><div class="form-control"> {{currentUser.userType === 'U' ? '환자' : '의사'}} </div></div>
                    <div class="col-md-6"><label class="labels">구분</label><div class="form-control"> {{currentUser.gender === 'male' ? '남자' : '여자'}} </div></div>
                </div>
                <div class="row mt-2">
                    <div class="col-md-12 mt-4"><label class="labels">생년월일</label><div class="form-control">{{currentUser.birthdate}}</div></div>
                    <div class="col-md-12 mt-4"><label class="labels">주소</label><div class="form-control">{{currentUser.address}}</div></div>
                    <div class="col-md-12 mt-4"><label class="labels">연락처 번호</label><div class="form-control">{{currentUser.phone}}</div></div>
                    <div class="col-md-12 mt-4"><label class="labels">e-mail</label><div class="form-control">{{currentUser.email}}</div></div>
                </div>
                <div>
                  <router-link :to="{ name: 'mypageUpdate' }">
                    <button type="button" class="btn btn-outline-primary m-5">회원정보 수정</button>
                  </router-link>
                  <button type="button" @click="userDelete()" class="btn btn-outline-warning">회원탈퇴</button>
                  <router-link v-if="currentUser.userType !== 'D'" :to="{ name: 'doctorRegist'}">
                    <button type="button" class="btn btn-outline-primary m-5">의사 등록</button>
                  </router-link>
                </div>
                <!-- <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="button">Save Profile</button></div> -->
            </div>
        </div>
    </div>
  </div>
  <div class="container-body" v-if="doctorFlag">
    <div>
      <h4 style="text-align:left">{{currentUser.userName }} 선생님</h4>
      <div class="row mt-2">
          <div class="col-md-6"><label class="labels">ID</label><div class="form-control">{{currentUser.userId}}</div></div>
      </div>
      <div class="row mt-3">
          <div class="col-md-6"><label class="labels">구분</label><div class="form-control"> {{currentUser.userType === 'U' ? '환자' : '의사'}} </div></div>
          <div class="col-md-6"><label class="labels">성별</label><div class="form-control"> {{currentUser.gender === 'male' ? '남자' : '여자'}} </div></div>
      </div>
      <div class="row mt-2">
          <div class="col-md-12 mt-4"><label class="labels">생년월일</label><div class="form-control">{{currentUser.birthdate}}</div></div>
          <div class="col-md-12 mt-4"><label class="labels">주소</label><div class="form-control">{{currentUser.address}}</div></div>
          <div class="col-md-12 mt-4"><label class="labels">연락처 번호</label><div class="form-control">{{currentUser.phone}}</div></div>
          <div class="col-md-12 mt-4"><label class="labels">e-mail</label><div class="form-control">{{currentUser.email}}</div></div>
      </div>
      <hr>
      <div>
        <h4 style="text-align:left">병원 정보</h4>
        <div class="row mt-3">
          <div class="col-md-6"><label class="labels">병원명</label><div class="form-control"> {{currentDoctorInfo.hospitalName}} </div></div>
          <div class="col-md-6"><label class="labels">진료과</label><div class="form-control"> <span v-for="(departmentName, idx) in currentDoctorInfo.departmentNames" :key="idx">
            {{departmentName}}&nbsp;
          </span>  </div></div>
        </div>
        <div class="row mt-2">
          <div class="col-md-12 mt-4"><label class="labels">병원 연락처</label><div class="form-control">{{currentDoctorInfo.hospitalPhone}}</div></div>
          <div class="col-md-12 mt-4"><label class="labels">병원 주소</label><div class="form-control">{{currentDoctorInfo.hospitalAddress}}</div></div>
          <div class="col-md-12 mt-4"><label class="labels">병원 상세정보</label><div class="form-control">{{currentDoctorInfo.hospitalDescription}}</div></div>
          <div class="col-md-12 mt-4"><label class="labels">병원 연락처</label><div class="form-control">{{currentDoctorInfo.hospitalPhone}}</div></div>
        </div>
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
/* .form-control:focus {
    box-shadow: none;
    border-color: #BA68C8
}

.profile-button {
    background: rgb(99, 39, 120);
    box-shadow: none;
    border: none
} */

/* .profile-button:hover {
    background: #682773
}

.profile-button:focus {
    background: #682773;
    box-shadow: none
}

.profile-button:active {
    background: #682773;
    box-shadow: none
} */

.labels {
    font-size: 12px;
}
</style>
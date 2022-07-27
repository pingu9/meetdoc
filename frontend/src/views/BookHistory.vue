<template>
  <div class="container-body">
    <h1>{{user1.name}} 님의 예약 내역</h1>
    <div class="container-card" v-for="(list, idx) in bookList" :key="idx">
      <!-- 원격진료 입장가능 -->
      <div class="card">
        <div class="card-body">
          <p class="badge rounded-pill bg-secondary text-white" id="cancel">예약취소</p>
          <p class="card-title">원격진료 입장 가능</p>
          <div class="info-box">
            <div class="half-box">
              <img src="../assets/images/doctor.jpg" alt="doctorImg" class="doctorImg"/>
              <p style="margin-top:10px;font-weight: bold; font-size: 20px;">{{list.doctorName}}</p>
              <p style="margin-top:-10px; margin-bottom: -5px;">{{list.departmentName}}</p>
            </div>
            <div class="half-box">
              <p style="margin-top:10px;text-align: left; font-weight: bold; color: gray;">환자명</p>
              <p style="text-align: left; font-size: 20px;">{{list.userName}} 님</p>
              <p style="text-align: left; font-weight: bold; color: gray;">진료시간</p>
              <p style="text-align: left; font-size: 20px;">{{list.appointmentTime}}</p>
            </div>
          </div>
          <div class="d-grid gap-2">
            <button class="btn btn-primary" type="button" a href="#">진료실 입장하기</button>
          </div>
        </div>
      </div>
      <!-- 원격진료 입장가능 -->
      <!-- <div class="card">
        <div class="card-body">
          <p class="badge rounded-pill bg-secondary text-white" id="cancel">예약취소</p>
          <p class="card-title">원격진료 입장 불가</p>
          <div class="info-box">
            <div class="half-box">
              <img src="../assets/images/doctor.jpg" alt="doctorImg" class="doctorImg"/>
              <p style="margin-top:10px;font-weight: bold; font-size: 20px;">닥터스트레인지 의사</p>
              <p style="margin-top:-10px; margin-bottom: -5px;">가정의학과</p>
            </div>
            <div class="half-box">
              <p style="margin-top:10px;text-align: left; font-weight: bold; color: gray;">환자명</p>
              <p style="text-align: left; font-size: 20px;">{{user1.name}} 님</p>
              <p style="text-align: left; font-weight: bold; color: gray;">진료시간</p>
              <p style="text-align: left; font-size: 20px;">2022-07-22 16:35</p>
            </div>
          </div>
          <div class="d-grid gap-2">
          <button class="btn btn-danger" type="button" a href="#">진료 대기중</button>
          </div>
        </div>
      </div>
      <div class="card">
        <div class="card-body">
          <p class="badge rounded-pill bg-secondary text-white" id="cancel">상세보기</p>
          <p class="card-title">진료 완료</p>
          <div class="info-box">
            <div class="half-box">
              <img src="../assets/images/doctor.jpg" alt="doctorImg" class="doctorImg"/>
              <p style="margin-top:10px;font-weight: bold; font-size: 20px;">닥터스트레인지 의사</p>
              <p style="margin-top:-10px; margin-bottom: -5px;">가정의학과</p>
            </div>
            <div class="half-box">
              <p style="margin-top:10px;text-align: left; font-weight: bold; color: gray;">환자명</p>
              <p style="text-align: left; font-size: 20px;">{{user1.name}} 님</p>
              <p style="text-align: left; font-weight: bold; color: gray;">진료시간</p>
              <p style="text-align: left; font-size: 20px;">2022-07-22 16:35</p>
            </div>
          </div>
          <div class="d-grid gap-2">
          <button class="btn btn-secondary" type="button" a href="#">진료 완료</button>
          </div>
        </div>
      </div> -->
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex'
export default {
  computed: {
    ...mapState(['user1', 'bookList']),
  },
  created(){
    this.$store.dispatch('getBookList');
  }
}
</script>

<style>

.card{
  margin:10px;
  }

  .card-title{
    font-size: 25px;
    font-weight: bold;
  }
  .container-card{
    width: 100%;
  }

  .card-body {
    position: relative;
  }

  #cancel {
    position: absolute;
    right: 16px;
    top: 20px;
    padding:10px;
  }

  .info-box {
    display: flex;

  }

  .half-box {
    width: 50%;
    margin: 10px;
 }

  .doctorImg{
    width:60%;
    height:60%;
  }

  #cancel:hover{
    cursor: pointer;
  }
</style>
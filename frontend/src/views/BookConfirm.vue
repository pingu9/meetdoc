<template>
  <div class="container-body">
    <h1>예약완료</h1>
    <div class="container-card">
     <div class="card">
        <div class="card-body">
          <img src="../assets/images/check.png" alt="confirmed" class="confirmed"/>
          <p class="card-title">환자 님의 예약이 완료되었습니다.</p>
          <div class="info-box">
            <div class="half-box">
              <p class="title-box">의사명</p>
              <p class="title-box">진료과목</p>
              <p class="title-box">결제금액</p>
            </div>
            <div class="half-box">
              <p class="content-box">스트레인지</p>
              <p class="content-box">내과</p>
              <p class="content-box">10,000원</p>
            </div>
          </div>
          <hr>
          <p class="card-title" style="margin:20px 0">2022년 5월 28일 15:00</p>
          <div class="d-grid gap-2">
            <a href="/" class="btn btn-primary" style="margin:10px">닫기</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>
.title-box{
  font-size: 25px;
  color: gray;
  font-weight: bold;
  margin: 50px 0px;
}

.content-box{
  font-size: 25px;
  margin: 50px 0px;
}

.confirmed{
  width: 50px;
  height: 50px;
  margin: 20px 0px;
}

</style>
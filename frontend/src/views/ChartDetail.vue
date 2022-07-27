<template>
<div class="container-body">
    <h1>진료 내역 상세</h1>
    <div class="container-card">
      <div class="card">
        <div class="card-body">
           <div class="card">
            <div class="card-body">
                <p class="card-title">환자 및 의사 정보</p>
                <div class="info-body">
                    <div class="row">
                        <div class="col"><p class="chartDetailData">환자명 : 김환자</p></div>
                        <div class="col"><p class="chartDetailData">생년월일 : 1999-09-09</p></div>
                    </div>
                    <div class="row">
                        <div class="col"><p class="chartDetailData">병원명 : 다나아 병원명</p></div>
                        <div class="col"><p class="chartDetailData">병원 전화번호 : 02-777-7777</p></div>
                    </div>
                    <div class="row">
                        <div class="col"><p class="chartDetailData">의사명 : 김의사</p></div>
                    <div class="col"><p class="chartDetailData">면허번호 : 1234567-89123</p></div>
                    </div>
                    <div class="row">
                        <div class="col"><p class="chartDetailData">진료일 : 2022-07-25</p></div>
                        <div class="col"><p class="chartDetailData">병명 진단: ICD</p></div>
                    </div>
                </div>
            </div>
          </div>
          <div class="card">
            <div class="card-body">
                <p class="card-title">환자증상</p>
                <div class="symptom">
                    <p class="chartDetailData">환자 증상은 여기에 들어갑니다asdfasfasdfasdfadfadsfsdfasfasfasfasfasfasfasfsdadfasfadfasdfasdfsdafadsfasdfafasd</p>
                </div>
            </div>
          </div>
          <div class="card">
            <div class="card-body">
                <p class="card-title">처방전</p>
                <div class="prescription">
                    <p class="chartDetailData">처방내용은 여기에 들어갑니다</p>
                </div>
            </div>
          </div>
          <div class="card">
            <div class="card-body">
            <p class="card-title">진료비</p>
            <div class="charge">
                <h4>Charge : $125.85</h4>
            </div>
            </div>
        </div>
        </div>
      </div>
    </div>
    <a href="/chart/list" class="btn btn-primary">확인</a>
  </div>
</template>

<script>
import { mapState } from 'vuex'
export default {
    computed: {
        ...mapState(['chartDetail']),
    }
}
</script>

<style>

h3{
    text-align: right;
    margin: 10px;
}

.chartDetailData{
    text-align: left;
}

</style>
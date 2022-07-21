<template>
  <div class="modal fade" id="chartDetail" tabindex="-1" aria-labelledby="chartDetailLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="chartDetailLabel" >진료 상세내역 - {{chartDetail.userId}}</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body" id="container-drDtail">
        <h4>환자 증상</h4>
        <div class="container-desc">
            {{chartDetail.description}}
        </div>
        <div class="h4">
            <label for="exampleFormControlTextarea1" class="form-label">처방전</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
        <!--처방 되있으면 안보이기-->
        <button type="button" class="btn btn-primary">처방하기</button>
      </div>
    </div>
  </div>
</div>
<!-- chartDetail: {
        "id": '1',
        "title": '제목',
        "date": '2022-05-14 4:00PM',
        "userId": 'user1',
        "doctorId": 'doctor1',
        "description": '에어컨을 너무 쐬서 그런지 머리가 아프네요',
        "picture": '',
        "Prescription": '',
    }-->
</template>

<script>
import { mapState } from 'vuex'
export default {
    computed: {
        ...mapState(['chartDetail'])
    }
}
</script>

<style>

.container-desc{
    border: solid 1px lightgray;
    padding: 10px;
    text-align: justify;
    margin: 10px;
}

.patientName{
}
</style>
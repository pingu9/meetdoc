<template>
<div class="modal fade" id="doctorDtail" tabindex="-1" aria-labelledby="doctorDtailLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="doctorDtailLabel" >의사프로필</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body" id="container-drDtail">
        <img src="../assets/images/doctor.jpg" alt="doctorImg" class="doctorImg" style="">        
        <h3>{{doctorDetail.name}}</h3>
        <h1>{{doctorDetail.hospitalName}}</h1>
        <h5>{{doctorDetail.department}}</h5>      
        <span>{{doctorDetail.description}}</span>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
        <button type="button" class="btn btn-primary">예약하기</button>
      </div>
    </div>
  </div>
</div>
</template>

<script>
import { mapState } from 'vuex'
export default {

  computed: {
    ...mapState(['doctorDetail']),
}
}
</script>

<style>

.doctorImg{
  display: block;
  margin: auto;
  object-fit: cover;
  width: 50%;
  height: 50%;
}

#container-drDtail{
  text-align: center;
  margin: 10px;
}
</style>
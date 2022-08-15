<template>
  <div class="modal-dialog">
  <div class="modal-content">
      <div class="modal-header">
        <h3>처방 입력</h3>
        <button type="button" class="btn-close" data-bs-dismiss="modal" id="prescriptionModalCloseBtn"></button>
      </div>
      <div>
        <div class="card-body">
          <div class="form-group row">
              <label class="col-md-auto col-form-label" for="date-input">처방일자:</label>
              <div class="col-md-auto">
                <input type='date' id="date-input" class="form-control" v-model="date"/>
              </div>
          </div>

          <div class="form-group row" style="margin-top: 10px">
              <label class="col-md-auto col-form-label" for="icd-input">질병코드:</label>
              <div class="col-md-auto">
                <input id="icd-input" class="form-control" size="13" v-model="icd"/>
              </div>
          </div>
          
          <div class="prescription-container">
            <div class="form-floating">
              <textarea placeholder="처방 내용을 입력해주세요." id="prescription-textarea" v-model="prescription"></textarea>
            </div>
          </div>
          <div class="d-grid gap-2 btn-container row">
            <a href="#" class="btn btn-secondary" @click="tempSave()">임시저장</a>
            <a href="#" class="btn btn-primary" @click="sendPrescription(false)">작성완료</a>
          </div>
        </div>
      </div>
    </div>
  </div>  
</template>

<script>
import axios from 'axios';
export default {
    props: ['appointmentId'],
    data() {
        return {
            date: '',
            prescription: '',
            doctorName: '',
            icd: '',
            separatePage: false,
        }
    },
    methods: {
        sendPrescription(isTemp) {
            console.log(this.appointmentId);
            let result = true;
            if (!isTemp) {
                result = confirm("최종 작성 이후에는 수정하지 못합니다. 정말로 작성 완료하시겠습니까?");
            }
            if (result) {
                axios.patch(`/api/appointment/prescription/${this.appointmentId}`, {
                    prescriptionDate: isTemp? null : (this.date + " 00:00"),
                    prescriptionDescription: this.prescription,
                    icd: this.icd,
                    isTemp,
                }).then((res) => {
                    if (!isTemp) {
                        alert("처방 입력이 완료되었습니다.");
                    } else {
                        alert("임시 저장되었습니다.");
                    }
                    document.getElementById('prescriptionModalCloseBtn').click();
                }).catch((error) => {
                    if (error.response.data.message === "처방 내역이 이미 있습니다.") {
                    alert("처방 내역이 이미 존재합니다.");
                    document.getElementById('loginModalCloseBtn').click();
                } else {
                    alert("잘못된 입력입니다");
                }
            })
            }
            
        },
        tempSave() {
            this.sendPrescription(true);
        }
    },
    created() {

        //오늘 날짜 설정
        let todayDate = new Date();
        let yy = String(todayDate.getFullYear());
        let month = todayDate.getMonth() + 1;
        let mm = month < 10 ? '0' + month : month;
        let dd = String(todayDate.getDate() < 10 ? '0' + todayDate.getDate() : todayDate.getDate());

        //오늘 date 값 입력
        let date = yy + '-' + mm + '-' + dd;
        this.date = date;

    
    },
}
</script>

<style>

.btn-container {
    margin-top: 10px;
    margin-left: 0px;
    margin-right: 0px;
}


.prescription-container{
    margin-top: 20px;
    text-align: left;
}

#prescription-textarea{
    width: 100%;
    resize: none;
    border: 1px solid lightgray;
    padding: 10px;
    outline: none;
    border-radius: 5px;
    height: 100px;
}


/* .container-date-picker{
    display: flex;
} */

.container-doctorName{
    text-align: left;
}

</style>
<template>
  <div class="container-body">
    <h1>처방 입력</h1>
  <div class="container-card">
      <div class="card">
        <div class="card-body">
          <div id="date-select">
            <div class="container-doctorName">
              <p class="card-title">권의사</p>
            </div>
            <div class="container-date-picker">
              <label class="date-picker-label">처방일</label>
              <input type='date' class="form-control" v-model="date"/>
            </div>
          </div>
          <div class="prescription-container">
            <div class="form-floating">
              <textarea placeholder="처방 내용을 입력해주세요." id="prescription-textarea" v-model="prescription"></textarea>
            </div>
          </div>
          <div class="d-grid gap-2 btn-container">
            <a href="#" class="btn btn-primary" @click="sendPrescription()">처방 내용 입력</a>
          </div>
        </div>
      </div>
    </div>
  </div>  
</template>

<script>
import axios from 'axios';
export default {
    data() {
        return {
            date: '',
            prescription: '',
            doctorName: '',
            appointmentId: '',
            icd: '',
        }
    },
    methods: {
        sendPrescription() {
            axios.patch(`/api/appointment/prescription/${this.appointmentId}`, {
                prescriptionDate: this.date + " 00:00",
                prescriptionDescription: this.prescription,
                icd: this.icd,
            }).then((res) => {
                alert("처방 입력이 완료되었습니다.");
                this.$router.push("/"); 
            }).catch((error) => {
                if (error.response.data.message === "처방 내역이 이미 있습니다.") {
                    alert("처방 내역이 이미 존재합니다.")
                    this.$router.push("/");
                } else {
                    alert("잘못된 입력입니다");
                }
            })
        }
    },
    created() {
        if(this.$route.params.appointmentId !== '' && this.$route.params.appointmentId !==  undefined && this.$route.params.appointmentId !== null) {
            this.appointmentId = this.$route.params.appointmentId;           
        }     
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
}

#date-select{
    display: flex;
    justify-content: space-between;
  /* align-items: center; */
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


.container-date-picker{
    display: flex;
}

.container-doctorName{
    display: flex; 
    flex-direction: column; 
    justify-content: center;
}

</style>
<template>
    <div class="card">
        <div class="card-body">
            <p class="badge rounded-pill bg-secondary text-white" id="cancel" @click="badgeFunction(data.appointmentId, index, 2)">{{ badgeText2 }}</p> 
            <p class="badge rounded-pill bg-secondary text-white" id="detail" @click="badgeFunction(data.appointmentId, index, 1)">{{ badgeText }}</p> 
            <p class="card-title">{{ title }}</p>
            <div class="info-box">
            <div class="half-box">
                <img src="../assets/images/doctor.jpg" alt="doctorImg" class="doctorImg"/>
                <p style="margin-top:10px;font-weight: bold; font-size: 20px;">{{data.doctorName}}</p>
                <p style="margin-top:-10px; margin-bottom: -5px;">{{data.departmentName}}</p>
            </div>
            <div class="half-box">
                <p style="margin-top:10px;text-align: left; font-weight: bold; color: gray;">환자명</p>
                <p style="text-align: left; font-size: 20px;">{{data.patientName}} 님</p>
                <p style="text-align: left; font-weight: bold; color: gray;">진료시간</p>
                <p style="text-align: left; font-size: 20px;">{{data.appointmentTime}}</p>
            </div>
            </div>
            <div class="d-grid gap-2">
                <button :class="`btn ${btnClass} ${prevEnter}`" type="button" @click="enter()">{{ btnText }}</button>
            </div>
        </div>
    </div>
</template>

<script>
import { mapMutations } from 'vuex'
export default {
    data() {
        return {
            status: '',
            title: '',
            btnText: '',
            btnClass: '',
            badgeText: '상세보기',
            badgeText2: '',
            url:'',
            prevEnter:'',
        };
    },
    props: {
        data: Object,
        index: Number,
    },
    created() {
        const { status } = this.data;
        this.status = status;
        if (status === 'WAITING') {
            this.btnClass = 'btn-danger';
            this.btnText = '진료 대기중';
            this.title = '원격진료 입장 불가';
            this.badgeText2 = '예약취소';
            this.prevEnter = 'prevEnter';
        } else if(status === 'PENDING_CANCEL_PATIENT') {
            this.btnClass = 'btn-secondary';
            this.btnText = '예약 취소 확인 대기중';
            this.title = '취소중인 예약';
            this.prevEnter = 'prevEnter';
        } else if(status === 'PENDING_CANCEL_DOCTOR') {
            this.btnClass = 'btn-primary';
            this.btnText = '예약 취소 확인';
            this.title = '취소된 예약';
        } else if (status === 'OPEN') {
            this.btnClass = 'btn-primary';
            this.btnText = '진료실 입장하기';
            this.title = '원격진료 입장 가능';
        } else if (status === 'FINISHED') {
            this.btnClass = 'btn-secondary';
            this.btnText = '진료 완료';
            this.title = '진료 완료';
            this.prevEnter = 'prevEnter';
        } else if (status === 'CANCELED') {
            this.btnClass = 'btn-secondary';
            this.btnText = '취소 완료';
            this.title = '취소된 예약';
            this.prevEnter = 'prevEnter';
        } else if (status === 'PENDING_PRESCRIPTION') {
            this.btnClass = 'btn-secondary';
            this.btnText = '진료 완료';
            this.title = '처방전 작성 대기중';
            this.prevEnter = 'prevEnter';
        } else {
            this.btnClass = 'btn-danger';
            this.btnText = '진료 대기중';
            this.title = '원격진료 입장 불가';
            this.badgeText2 = '예약취소';
            this.prevEnter = 'prevEnter';
        }
    },
    methods: {
        enter(){
            var userType = localStorage.getItem('userType');
            var appointmentId = this.data.appointmentId;
            var myUserName = '';
            if(userType === 'D'){
                myUserName = this.data.doctorName;
            }else{
                myUserName = this.data.patientName;
            }
            if(this.status === 'OPEN') this.$router.push({name: 'meetingRoom', params:{appointmentId: appointmentId, userType: userType, myUserName: myUserName}});
            else if (this.status === 'PENDING_CANCEL_DOCTOR') this.$store.dispatch('approveCancelByPatient',appointmentId).then((res) => {
                console.log(res.data);
                alert("예약이 취소되었습니다.")
                this.btnClass = 'btn-secondary';
                this.btnText = '예약 취소 확인 대기중';
                this.title = '취소중인 예약';
                this.prevEnter = 'prevEnter';
            })
        },
        badgeFunction(appointmentId, index, type) {
            console.log(index);
            if (this.status === 'WAITING' && type == 2) {
                if (confirm('예약을 취소하시겠습니까?')) {
                    this.$store.dispatch('cancelApptByPatient', appointmentId).then((res) => {
                        console.log(res.data);
                        alert("예약 취소 요청을 성공적으로 실행했습니다.")
                        // this.$emit('deleteList', index);
                        this.btnClass = 'btn-secondary';
                        this.btnText = '취소 완료';
                        this.title = '취소된 예약';
                        this.prevEnter = 'prevEnter';
                    });
                }
            } else if (type == 1) {
                // 상세보기 기능
                this.$store.dispatch('getChartDetail', appointmentId).then((a) => {
                    console.log(a.data);
                    this.setChartDetail(a.data);
                }).then(() => {
                    this.$router.push('/chart/detail/' + appointmentId);
                })
                
            }
        },
        ...mapMutations(['setChartDetail',]),
    }
}
</script>

<style>
.prevEnter{
    pointer-events: none;
}

</style>
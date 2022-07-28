<template>
    <div class="card">
        <div class="card-body">
            <p class="badge rounded-pill bg-secondary text-white" id="cancel" @click="badgeFunction(data.appointmentId)">{{ badgeText }}</p> 
            <p class="card-title">{{ title }}</p>
            <div class="info-box">
            <div class="half-box">
                <img src="../assets/images/doctor.jpg" alt="doctorImg" class="doctorImg"/>
                <p style="margin-top:10px;font-weight: bold; font-size: 20px;">{{data.doctorName}}</p>
                <p style="margin-top:-10px; margin-bottom: -5px;">{{data.departmentName}}</p>
            </div>
            <div class="half-box">
                <p style="margin-top:10px;text-align: left; font-weight: bold; color: gray;">환자명</p>
                <p style="text-align: left; font-size: 20px;">{{data.userName}} 님</p>
                <p style="text-align: left; font-weight: bold; color: gray;">진료시간</p>
                <p style="text-align: left; font-size: 20px;">{{data.appointmentTime}}</p>
            </div>
            </div>
            <div class="d-grid gap-2">
                <button :class="`btn ${btnClass}`" type="button" a href="#">{{ btnText }}</button>
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
            badgeText: '',
        };
    },
    props: {
        data: Object,
    },
    created() {
        const { status } = this.data;
        this.status = status;
        if (status === 'Open') {
            this.btnClass = 'btn-primary';
            this.btnText = '진료실 입장하기';
            this.title = '원격진료 입장 가능';
            this.badgeText = '예약취소';
        } else if (status === 'Done') {
            this.btnClass = 'btn-secondary';
            this.btnText = '진료 완료';
            this.title = '진료 완료';
            this.badgeText = '상세보기';
        } else {
            this.btnClass = 'btn-danger';
            this.btnText = '진료 대기중';
            this.title = '원격진료 입장 불가';
            this.badgeText = '예약취소';
        }
    },
    methods: {
        badgeFunction(appointmentId) {
            if (this.status !== 'Done') {
                if (confirm('예약을 취소하시겠습니까?')) {
                    this.$store.dispatch('cancelAppt', appointmentId).then((a) => {
                    console.log(a.data);
                    });
                }
            } else {
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

</style>
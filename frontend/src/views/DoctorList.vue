<template>
  <div class="container-body">
    <h1>{{this.getDeptName}} 의사 리스트</h1><!--진료과 선택시 해당 진료과가 '소아청소년과' 자리에 오도록! -->
    <div class="card w-90" v-for="(list, idx) in $store.state.doctors" :key="idx" id="container-card">
        <div class="card-body">
        <h5 class="card-title">{{list.doctorName}}</h5>
        <p class="card-text">{{list.departmentName}}</p>
        <p class="card-text">{{list.hospitalName}}</p>
        <button @click="this.$router.push({name: 'bookRequest', params:{doctorId: list.doctorId, departmentName: list.departmentName, doctorName: list.doctorName}})" class="btn btn-primary">예약하기</button>
        <!-- <a :href="`/book/request?doctorName=${list.name}`" class="btn btn-primary">예약하기</a> -->
        </div>
    </div>
    <div class="card w-90" id="noDoctorList" v-if="doctorList === false">
      <div class="card-body">
        <h5 class="card-title">해당 진료과의 의사리스트가 없습니다.</h5>
        </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapMutations, mapGetters } from 'vuex';
export default {
data(){
    return {
      doctorList: false,
    }
  },
  components: {
  },
  computed: {
    ...mapState(['doctors']),
    ...mapGetters(['getDepartmentCode', 'getDoctorList', 'getDeptName']),
  },
  methods: {
    ...mapMutations(['setDoctorList', 'setDepartmentCode', 'setDeptName']),
  },
  created() {
    if (this.$route.params.departmentName !== null && this.$route.params.departmentName !== undefined && this.$route.params.departmentName !== '') {
      this.setDeptName(this.$route.params.departmentName);
    }
    if (this.$route.params.departmentCode !== null && this.$route.params.departmentCode !== undefined && this.$route.params.departmentCode !== '') {
      this.setDepartmentCode(this.$route.params.departmentCode);
    }
    this.$store.dispatch('getDoctorList', this.getDepartmentCode).then((res) => {
      console.log(res.data.result);
      if (res.data.result.length !== 0) this.doctorList = true;
      this.setDoctorList(res.data.result);
    }).catch(error => {
      console.log(error);
    })
  },
}
</script>

<style>
#noDoctorList{
  margin-top: 10%;
  margin-bottom: 70%;
}
</style>
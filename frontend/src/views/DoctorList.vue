<template>
  <div class="container-body">
    <h1>{{$store.state.department}} 의사 리스트</h1><!--진료과 선택시 해당 진료과가 '소아청소년과' 자리에 오도록! -->
    <div class="card w-90" v-for="(list, idx) in $store.state.doctors" :key="idx" id="container-card">
        <div class="card-body">
        <h5 class="card-title">{{list.name}}</h5>
        <p class="card-text">{{list.departmentName}}</p>
        <p class="card-text">{{list.hospitalName}}</p>
        <a href="/book/request" class="btn btn-primary">예약하기</a>
        </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
data(){
    return{
    }
  },
  components: {
  },
computed: {
  ...mapState(['doctors']),
  },
  created() {
    this.$store.dispatch('getDoctorList', this.$route.params.code);
  },
}
</script>

<style>

</style>
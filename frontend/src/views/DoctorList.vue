<template>
  <div>
    <h1>doctor list - 진료과</h1>
    <!-- Button trigger modal -->
    <div class="card w-90" v-for="(list, idx) in $store.state.doctors" :key="idx" id="container-card" data-bs-toggle="modal" data-bs-target="#doctorDtail">
        <div class="card-body">
        <h5 class="card-title">{{list.name}}</h5>
        <p class="card-text">{{list.department}}</p>
        <a href="#" class="btn btn-primary">예약하기</a>
        </div>
    </div>
    <DoctorDetailDialog/>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import DoctorDetailDialog from '../components/DoctorDetailDialog.vue';
export default {
data(){
    return{
        
    }
  },
  components: {
    DoctorDetailDialog,
  },
computed: {
    ...mapState(['doctors']),
  },
}
</script>

<style>

</style>
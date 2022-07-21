<template>
  <div>
    <h1>doctor list - 진료과</h1>
    <div class="card w-75" v-for="(list, idx) in $store.state.doctors" :key="idx">
        <div class="card-body">
        <h5 class="card-title">{{list.name}}</h5>
        <p class="card-text">{{list.department}}</p>
        <a href="#" class="btn btn-primary">예약하기</a>
        </div>
    </div>
  </div>
</template>

<script>
import {mapState } from 'vuex';
export default {
data(){
    return{
        
    }
},
computed: {
    ...mapState(['doctors']),
  },
}
</script>

<style>

</style>
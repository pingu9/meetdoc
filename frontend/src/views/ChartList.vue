<template>
  <div>
    <h1>Chart List</h1>
    <div class="card w-90" v-for="(chart, idx) in $store.state.charts" :key="idx" id="container-card" data-bs-toggle="modal" data-bs-target="#chartDetail">
        <div class="card-body">
        <h5 class="card-title">{{chart.name}}</h5>
        <p class="card-text">{{chart.date}}</p>
        <a href="#" class="btn btn-primary">상세보기</a>
        </div>
    </div>
    <ChartDetailDialog/>
  </div>
</template>

<script>
import { mapState } from 'vuex';
import ChartDetailDialog from '../components/ChartDetailDialog.vue';

export default {
  components: {
    ChartDetailDialog,
  },
  computed: {
    ...mapState(['charts'])
  }
}
</script>

<style>
h1{
  text-align: center;
  margin: 20px;
}
</style>
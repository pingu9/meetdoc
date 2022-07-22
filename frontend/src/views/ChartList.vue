<template>
  <div class="container-body">
    <h1>Chart List</h1>
    <div class="card w-90" v-for="(chart, idx) in $store.state.charts" :key="idx" id="container-card" data-bs-toggle="modal" data-bs-target="#chartDetail">
        <div class="card-body">
        <h5 class="card-title">{{chart.name}}</h5>
        <p class="card-text">{{chart.date}}</p>
        <a href="/chart/detail/1" class="btn btn-primary">상세보기</a>
        </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
  components: {
  },
  computed: {
    ...mapState(['charts'])
  }
}
</script>

<style>
</style>
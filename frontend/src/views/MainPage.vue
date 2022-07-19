<template>
  <h1>Main page 입니다.</h1>
  <p>{{$store.state.name}}</p>
  <button @click="changeName()">한/영변환</button>
  <hr>
  <span>getName : {{getName}}</span>
</template>

<script>

import { mapState, mapMutations, mapGetters } from 'vuex';

export default {
  data() {
    return {
      
    }
  },
  components: {
    
  },
  computed: {
    ...mapState(['name']),
    // ...mapGetters({
    //   getter : 'getName'
    // }),
    ...mapGetters(['getName',]),
  },
  methods: {
    ...mapMutations(['changeName'])
  }
}
</script>

<style>

</style>
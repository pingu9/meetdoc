<template>
  <div>
    <h4>HomePage 입니다.</h4>
    <p>{{$store.state.name}}</p>
  <button @click="changeName()">한/영변환</button>
  <hr>
  <span>getName : {{getName}}</span>
  <hr>
  <button @click="getData()">데이터가져오기</button>
  <p>{{value}}</p>
  </div>
</template>

<script>
import { mapState, mapMutations, mapGetters, mapActions } from 'vuex';
export default {
    data() {
    return {
      
    }
  },
  components: {
    
  },
  computed: {
    ...mapState(['name', 'value']),
    // ...mapGetters({
    //   getter : 'getName'
    // }),
    ...mapGetters(['getName',]),
  },
  methods: {
    ...mapMutations(['changeName']),
    ...mapActions(['getData']),
  }
}
</script>

<style>

</style>
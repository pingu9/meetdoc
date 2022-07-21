<template>
  <div>
    <h4>HomePage 입니다.</h4>
    <div class="alert alert-primary" role="alert">
    예약하신 진료시간이 다 되었습니다. <a href="#" class="alert-link">진료실 링크여기</a> 진료실에 입장해주세요!
    </div>
    <router-link to="/doctors/1">
    <div class="row row-cols-1 row-cols-md-3 g-4" id="container-specialty">
      <div class="col" v-for="(specialty, idx) in $store.state.specialties" :key="idx">
        <div class="card h-100">
          <img src="../assets/images/hospital.png" class="card-img-top" alt="specialty">
          <div class="card-body">
            <h5 class="card-title">{{specialty}}</h5>
            <p class="card-text">진료과별 detail</p>
          </div>
        </div>
      </div>
    </div>
    </router-link>
    <!-- <p>{{$store.state.name}}</p>
  <button @click="changeName()">한/영변환</button>
  <hr>
  <span>getName : {{getName}}</span>
  <hr>
  <button @click="getData()">데이터가져오기</button>
  <p>{{value}}</p> -->
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
    ...mapState(['name', 'value', 'specialties']),
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
a{
  color: black;
  text-decoration: none;
}

a:hover{
  cursor: pointer;
}

#container-specialty{
  margin: 5%;
}

.alert-link{
  text-decoration: underline;
}

</style>
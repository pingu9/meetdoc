<template>
  <div>
    <div class="alert alert-primary" role="alert">
    예약하신 진료시간이 다 되었습니다. <a href="#" class="alert-link">진료실 링크여기</a> 진료실에 입장해주세요!
    </div>
    <div class="row row-cols-1 row-cols-md-3 g-4" id="container-departments">
      <div class="col" v-for="(department, idx) in $store.state.departments" :key="idx">
        <!-- <div class="card h-100" @click="$router.push({`/doctors/${department.departmentCode}`})"> -->
        <div class="card h-100" @click="$router.push({name: 'doctorList', params: {code: department.departmentCode, departmentName: department.departmentName}})">
          <img src="../assets/images/hospital.png" class="card-img-top" alt="departments">
          <div class="card-body">
            <h5 class="card-title">{{department.departmentName}}</h5>
          </div>
        </div>
      </div>
    </div>
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
import { mapState, mapMutations, mapGetters } from 'vuex';
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
    ...mapMutations(['changeName',]),
  },
  created() {
    this.$store.dispatch('getDepartments');
  },
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

#container-departments{
  margin: 5%;
}

.alert-link{
  text-decoration: underline;
}

</style>
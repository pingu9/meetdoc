<template>
  <div class="container-body">
    <div class="alert alert-primary" role="alert" v-if="this.userType === 'U'">
    예약하신 진료시간이 다 되었습니다. <a href="#" class="alert-link">진료실 링크여기</a> 진료실에 입장해주세요!
    </div>
    <div class="row row-cols-1 row-cols-md-3 g-4" id="container-departments">
      <div class="col" v-for="(department, idx) in $store.state.departments" :key="idx">
        <!-- <div class="card h-100" @click="$router.push({`/doctors/${department.departmentCode}`})"> -->
        <div class="card" @click="$router.push({name: 'doctorList', params: {departmentCode: department.departmentCode, departmentName: department.departmentName}})">
          <img :src="getIconPath(department.photoUrl)" class="card-img-top" :alt="`${department.departmentName}`" id="deptImg">
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
      userType: '',

    }
  },
  components: {
    
  },
  computed: {
    ...mapState(['name', 'value', 'specialties', 'currentUser']),
    // ...mapGetters({
    //   getter : 'getName'
    // }),
    ...mapGetters(['getName',]),
  },
  methods: {
    ...mapMutations(['changeName',]),
    getIconPath(iconName) {
      const icons = require.context('../assets/images', false, /\.png$/);
      return iconName ? icons(`./${iconName}.png`) : ''
    }
  },
  created() {
    this.userType = localStorage.getItem('userType')
    console.log(this.userType)
    if (this.userType !== 'D'){
      this.$store.dispatch('getDepartments');
    } else {
      this.$router.push({name: 'chartList'})
    }
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
  justify-content: center;
}

.alert-link{
  text-decoration: underline;
}

#deptImg{
  width:100%;
  height:100%;
}

.col{
  width: 30%;
}
</style>
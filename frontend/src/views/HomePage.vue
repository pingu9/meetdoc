<template>
  <div class="container-body">
    <div class="alert alert-primary" role="alert" v-if="this.userType === 'U'">
      <div v-if="this.appt.status === 'OPEN'">
        예약하신 진료시간이 다 되었습니다. <a @click="enterMeetingRoom()" class="alert-link">진료실 링크</a> 진료실에 입장해주세요!
      </div>
      <div v-if="this.appt.status === 'WAITING'">
        {{this.appt.appointmentTime}}에 {{this.appt.doctorName}}님과 진료 예약이 있습니다.
      </div>
      <div v-if="this.appt.message === 'no data'">
        예약한 진료가 없습니다.
      </div>
    </div>
    <div class="row row-cols-1 row-cols-md-3 g-4" id="container-departments">
      <div class="col" v-for="(department, idx) in $store.state.departments" :key="idx">
        <!-- <div class="card h-100" @click="$router.push({`/doctors/${department.departmentCode}`})"> -->
        <div class="card" @click="$router.push({name: 'doctorList', params: {departmentCode: department.departmentCode, departmentName: department.departmentName}})">
          <img :src="getIconPath(department.photoUrl)" class="card-img-top" :alt="`${department.departmentName}`" id="deptImg">
          <div class="card-body">
            <h4 class="card-title">{{department.departmentName}}</h4>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapMutations, mapGetters } from 'vuex';
export default {
    data() {
    return {
      userType: '',
      appt:{},
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
    },
    enterMeetingRoom() {
      if(this.appt.status === 'OPEN') this.$router.push({
        name: 'meetingRoom',
        params:{
          appointmentId: this.appt.appointmentId,
          userType: this.userType,
          myUserName: this.appt.patientName
        }
      });
    }
  },
  created() {
    this.userType = localStorage.getItem('userType')
    console.log(this.userType)
    if (this.userType !== 'D'){
      this.$store.dispatch('getDepartments');
      this.$store.dispatch('getNextAppt').then((res) => {
        console.log(res.data);
        this.appt = res.data;
      })
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

.card {
  border: none;
  box-shadow: 0.3vmin 0.3vmin 0.3vmin 0.3vmin rgb(226, 226, 226);
  padding: 1vmin;
}

.card:hover{
  cursor: pointer;
}

.card-title {
  margin-top: 2vmin;
}
</style>
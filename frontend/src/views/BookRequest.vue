<template>
  <div class="container-body">
    <h1>진료 신청서</h1>
  <div class="container-card">
      <div class="card">
        <div class="card-body">
          <img src="../assets/images/doctor.jpg" class="img-thumbnail" alt="doctorImg" id="doctorImg"/>
          <p class="card-title">닥터스트레인지 의사</p>
          <div>
              <h3 style="text-align: center;">예약하실 날짜 : {{date}} {{time}}</h3>
          </div>
          <div class="info-box">
            <div class="half-box">
              <form name="해당 폼의 이름" action="값을 보낼 주소" method="post">
                <input type='date' name='userBirthday'  @change="datePicked" v-model="date"/>
            </form>
            </div>
            <div class="half-box">
              <div v-for="i in timeList" :key="i" id="times" >
                <span class="badge rounded-pill bg-info text-white" id="badge" @click="time = i">{{i}}</span>
              </div>
            </div>
          </div>
          <div>
            <p class="card-title">증상 입력</p>
            <div class="form-floating">
              <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 100px"></textarea>
              <label for="floatingTextarea2">증상에 대해 자세히 입력해주세요.</label>
            </div>
          </div>
          <div class="d-grid gap-2">
            <button class="btn btn-primary" type="button" a href="/book/confirm">다음</button>
          </div>
        </div>
      </div>
    </div>
  </div>  
</template>

<script>

export default {
  data() {
    return {
      date: '',
      time: '',
      addTime: 30,
      timeList : [''],
    }
  },
  computed: {
    
  },
  methods: {
    datePicked() {
      //날짜 선택하면 기능
    },
  },
  mounted() {
    let todayDate = new Date();
    let yy = String(todayDate.getFullYear());
    let month = todayDate.getMonth() + 1;
    let mm = month < 10 ? '0' + month : month;
    let dd = String(todayDate.getDate() < 10 ? '0' + todayDate.getDate() : todayDate.getDate());
    let hou = String(todayDate.getHours() > 12 ? todayDate.getHours() - 12 : todayDate.getHours());
    let min = '';
    let minuates = todayDate.getMinutes();
     //min 30분 단위 설정
    if (minuates > 0 && minuates <= 30) {//1분 ~ 30분(포함) 사이에는 30분으로 표시
      min = '30';
    } else {//30분 초과 ~ 0분까지는 0으로
      hou++;
      min = '00';
    }
    //data 값 입력
    let date = yy + '-' + mm + '-' + dd;
    this.date = date;
    this.time = hou + ':' + min;
    this.timeList.push(this.time);

    //현재시간으로부터 시간 10개 뿌리기
    var minStandard = min;
    var houStandard = Number(hou);
    for (let i = 0; i < 9; i++) {
      let added = '';
      if (minStandard == 30) {
        houStandard += 1;
        minStandard = 0;
        added += String(houStandard) + ':00';
      } else {
        added += String(houStandard) + ':30';
        minStandard = 30;
      }
      this.timeList.push(added);
    }
  },
}
</script>

<style>
#doctorImg{
  width:35%;
  height:35%;
  margin: 10px;
}

#times{
  display: inline;
  margin: 5px;
}

#badge{
  font-size: 15px;
  padding:10px 20px;
  margin: 10px 0px;
}

#badge:hover{
  cursor:pointer;
}

.form-floating{
  margin: 20px;
}
</style>
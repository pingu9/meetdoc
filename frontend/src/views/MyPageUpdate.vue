<template>
  <div class="container-body">
    <!-- <h4>회원 정보 수정</h4> -->
    <!-- <form @submit.prevent="submitForm">
      <div class="form-group mb-3">
        <label class="form-label" for="inputPass">새 비밀번호</label>
        <input type="password" v-model="password" class="form-control" id="inputPass">
        <div class="valid-feedback"></div>
        <p v-show="valid.password" class="">
          비밀번호를 정확히 입력해주세요.
        </p>
      </div>
     
      <div class="input-group mb-3">
        <span class="input-group-text" id="inputGroup-sizing-default">이름</span>
        <span class="form-control"   aria-label="Username" aria-describedby="basic-addon1">{{currentUser.userName}}</span>
      </div>
      <div class="input-group mb-3">
        <span class="input-group-text" id="inputGroup-sizing-default">주민등록번호</span>
        <span class="form-control"  placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">{{currentUser.rrn}}</span>
      </div>
      <div class="input-group mb-3">
        <span class="input-group-text" id="inputGroup-sizing-default">주소</span>
        <input type="text" v-model="address" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
      </div>
      <div class="input-group mb-3">
        <span class="input-group-text" id="inputGroup-sizing-default">전화번호</span>
        <input type="text" v-model="phone" class="form-control" placeholder="010-0000-0000" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
      </div>
      <div class="input-group mb-3">
        <span class="input-group-text" id="inputGroup-sizing-default">email</span>
        <input type="text" v-model="email" class="form-control" placeholder="example@naver.com" aria-label="Server">
      </div>
        <p
          v-show="valid.email"
          class="input-error">
          이메일 주소를 정확히 입력해주세요.
        </p>
      <button class="btn btn-primary btn-lg btn-block" type="submit">수정</button>
    </form> -->
    <form @submit.prevent="submitForm">
      <div class="row">
        <div class="col-md border-right">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h4 class="text-right">Profile Update</h4>
                </div>
                <div class="row mt-2">
                    <div class="col-md-6"><label class="labels">ID</label><div class="form-control">{{currentUser.userId}}</div></div>
                </div>
                <div class="row mt-3">
                    <div class="col-md-6"><label class="labels">구분</label><div class="form-control"> {{currentUser.userType === 'U' ? '환자' : '의사'}} </div></div>
                    <div class="col-md-6"><label class="labels">성별</label><div class="form-control"> {{currentUser.gender === 'male' ? '남자' : '여자'}} </div></div>
                </div>
                <div class="row">
                    <div class="col-md-12 mt-4"><label class="labels">생년월일</label><div class="form-control">{{currentUser.birthdate}}</div></div>
                </div> 
                <hr>
                <div class="row mt-3">
                    <!-- <div class="col-md-12"><label class="labels">new password</label><input type="password" v-model="password" class="form-control"></div>
                    <div class="valid-feedback"></div>
                    <p v-show="!valid.password && password" >
                      비밀번호를 정확히 입력해주세요.
                    </p> -->
                    <div class="col-md-12"><label class="labels">주소</label><input type="text" v-model="currentUser.address" class="form-control" placeholder="주소" ></div>
                    <div class="col-md-12"><label class="labels">연락처 번호</label><input type="text" v-model="currentUser.phone" class="form-control" placeholder="연락처" ></div>
                    <span v-show="!valid.phone && currentUser.phone" class="input-error">
                        전화번호 형식에 맞게 정확히 입력해주세요.
                    </span>
                    <div class="col-md-12"><label class="labels">e-mail</label><input type="text" v-model="currentUser.email" class="form-control" placeholder="e-mail" ></div>
                    <p
                      v-show="!valid.email && currentUser.email"
                      class="input-error">
                      이메일 주소를 정확히 입력해주세요.
                    </p>
                </div>
                <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="submit">회원정보수정</button></div>
            </div>
        </div>
    </div>
    </form>
  </div>
  
</template>

<script>
import { mapState } from 'vuex';
export default {

data() {
    return {
      // password: '',
      // rrn: '',
      phone:'',
      // zipcode: '',	    
      address: '',
      email: '',
      // birthdate: '',
      // gender: '',
      userType: '',
      valid: {
        // password: false,
        email: true,
        phone: true,
      },
      // passwordHasError: false,
      emailHasError: false,
      phoneHasError: false,
    }
  },
watch: {
    // 'password': function () {
    //   this.checkPass()
    // },
    'currentUser.email' : function() {
      this.checkEmail()
    },
    'currentUser.phone': function () {
      this.checkPhone()
    },
  },

computed: {
    ...mapState(['currentUser','errorMessages']),
  },

created() {
    let userId = localStorage.getItem('userId');
    this.$store.dispatch('getCurrentUserInfo', userId);
  },

methods: {
    // checkPass () {
    //   const validatePassword = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/
    //   if (!validatePassword.test(this.password)|| !this.password) {
    //     this.valid.password = false
    //     this.emailHasError = true
    //     return
    //   } this.valid.password = true
    //     this.passwordHasError = false
    // },
    checkEmail() {
      // 이메일 형식 검사
      const validateEmail = /^[A-Za-z0-9_\\.\\-]+@[A-Za-z0-9\\-]+\.[A-Za-z0-9\\-]+/

      if (!validateEmail.test(this.currentUser.email) || !this.currentUser.email) {
        this.valid.email = false
        this.emailHasError = true
        return
      } this.valid.email = true
        this.emailHasError = false
    },
    checkPhone() {
      const validatePhoneNumber = /^\d{2,3}-\d{3,4}-\d{4}$/;

      if (!validatePhoneNumber.test(this.currentUser.phone) || !this.currentUser.phone) {
        this.valid.phone = false;
        this.phoneHasError = true;
      }
      else {
        this.valid.phone = true;
        this.phoneHasError = false;
      }
    },
    submitForm () {
      console.log('submit')
      console.log(this.userType)
      
      // if(!this.valid.password) alert("비밀번호 형식을 확인해주세요!")
      if(!this.valid.email) alert("이메일 형식을 확인해주세요!")
      else if(!this.valid.phone) alert("핸드폰 형식을 확인해주세요!")
      else {
        this.$store.dispatch('update', {
          phone: this.currentUser.phone,
          address: this.currentUser.address, 
          email: this.currentUser.email,
        })
      }
    }
}

}
</script>

<style>
.form-control:focus {
    box-shadow: none;
    border-color: #2a54df
}

.profile-button:focus {
    background: #2a54df;
    box-shadow: none
}
</style>
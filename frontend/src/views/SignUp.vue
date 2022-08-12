<template>
  <div class="container-body">
    <h1>회원가입</h1>
    <form @submit.prevent="submitForm">
      <div class="textForm" style="display:flex; margin-bottom: 0;">
        <input name="loginId" type="text" class="id" placeholder="아이디" v-model="userId">
        <button class="btn btn-outline-secondary" type="button" @click="checkId()" id="button-addon2" style="height:40px; width: 100px;">중복확인</button>
      </div>
      <span v-if="errorMessages">{{errorMessages.idCheckMessage}}</span>
      <div class="textForm"  style="display:flex; margin-bottom: 0;">
        <input name="loginPw" type="password" class="pw" placeholder="비밀번호" v-model="password">
      </div>
      <span v-show="!valid.password && password">
          비밀번호는 숫자, 특수문자 포함 8자~12자로 이용이 가능합니다.  
        </span>
      <div class="textForm">
        <input name="name" type="text" class="name" placeholder="이름" v-model="userName">
      </div>
      <div class="textForm">
        <input name="loginPwConfirm" type="text" class="rrn" maxlength="6" placeholder="주민번호 앞자리" v-model="rrn1">-
        <input name="loginPwConfirm" type="password" class="rrn" maxlength="7" placeholder="주민번호 뒷자리" v-model="rrn2">
      </div>
      <div class="textForm">
        <input name="nickname" type="text" class="nickname" placeholder="주소" v-model="address">
      </div>
      <div class="textForm">
        <input name="nickname" type="text" class="nickname" placeholder="우편번호" v-model="zipcode">
      </div>
      <div class="textForm">
        <input name="cellphoneNo" type="tel" class="cellphoneNo" placeholder="전화번호 예) 010-0000-0000" v-model="phone">
      </div>
      <span v-show="!valid.phone && phone" class="input-error">
          전화번호 형식에 맞게 정확히 입력해주세요.
      </span>
      <div class="textForm" style="display:flex; margin-bottom: 0;">
        <input name="email" type="text" class="email" placeholder="이메일 예) id@domain.com" v-model="email">
      </div>
      <span v-show="!valid.email && email" class="input-error">
          이메일 주소를 정확히 입력해주세요.
      </span>
      <div>
      <button class="btn btn-primary btn-lg btn-block" type="submit" style="margin-top:20px; font-size: 15px;">회원가입</button>
      </div>
    </form>
    <!-- <form @submit.prevent="submitForm">
      <div class="input-group mt-3 mb-3">
        <span class="input-group-text" id="basic-addon1">Username</span>
        <input type="text" class="form-control" v-model="userId"  placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
        <button class="btn btn-outline-secondary" type="button" @click="checkId()" id="button-addon2">중복확인</button>
      </div>
      <span v-if="errorMessages">{{errorMessages.idCheckMessage}}</span>
      <div class="form-group mt-3 mb-3">
        <label class="form-label" for="inputPass">비밀번호</label>
        <input type="password" v-model="password" class="form-control" id="inputPass">
        <div class="valid-feedback"></div>
        <p v-show="valid.password" class="">
          비밀번호는 숫자, 특수문자 포함 8자~12자로 이용이 가능합니다.  
        </p>
      </div>
     
      <div class="input-group mb-3">
        <span class="input-group-text" id="inputGroup-sizing-default">이름</span>
        <input type="text" v-model="userName" class="form-control" placeholder="이름" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
      </div>
      <div class="input-group mb-3">
        <span class="input-group-text" id="inputGroup-sizing-default">주민등록번호</span>
        <input type="text" v-model="rrn" class="form-control" placeholder="123456-1234567" aria-label="Username">
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
      <button class="btn btn-primary btn-lg btn-block" type="submit">가입 완료</button>
    </form> -->
  </div>
</template>

<script>
import { mapState } from 'vuex'
export default {
  data() {
    return {
      userId: '',
      password: '',
      rrn1: '',
      rrn2: '',
      userName: '',
      phone:'',
      zipcode: '',	    
      address: '',
      email: '',
      birthdate: '',
      gender: '',
      // email valid에 추가해야함
      valid: {
        password: false,
        email: false,
        phone: false,
        duplicateId : false,
      },
      passwordHasError: false,
      emailHasError: false,
      phoneHasError: false,
    }
  },
  computed: {
    ...mapState(['errorMessages'])
  },
  watch: {
    'password': function () {
      this.checkPass()
    },
    'email': function() {
      this.checkEmail()
    },
    'phone': function () {
      this.checkPhone()
    }
  },

  methods: {
    checkId () {
      if (this.userId) {
        console.log(this.userId)
        this.$store.dispatch('checkId', this.userId).then(() => {
          if(this.errorMessages.idCheckMessage == '사용 가능한 아이디입니다.') this.valid.duplicateId = true;
        })
      }
    },
    checkPass () {
      const validatePassword = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/
      if (!validatePassword.test(this.password)|| !this.password) {
        this.valid.password = false
        this.passwordHasError = true
        return
      } this.valid.password = true
        this.passwordHasError = false
    },
    checkEmail() {
      // 이메일 형식 검사
      const validateEmail = /^[A-Za-z0-9_\\.\\-]+@[A-Za-z0-9\\-]+\.[A-Za-z0-9\\-]+/

      if (!validateEmail.test(this.email) || !this.email) {
        this.valid.email = false
        this.emailHasError = true
        return
      } this.valid.email = true
        this.emailHasError = false
    },
    checkPhone() {
      const validatePhoneNumber = /^\d{2,3}-\d{3,4}-\d{4}$/;

      if (!validatePhoneNumber.test(this.phone) || !this.phone) {
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
      if(!this.valid.duplicateId) alert("아이디를 확인해주세요!")
      else if(!this.valid.password) alert("비밀번호 형식을 확인해주세요!")
      else if(!this.valid.email) alert("이메일 형식을 확인해주세요!")
      else if(!this.valid.phone) alert("핸드폰 형식을 확인해주세요!")
      else {
        this.$store.dispatch('signUp', {
          userId : this.userId,
          password: this.password,
          rrn: this.rrn1 + this.rrn2,
          userName: this.userName,
          phone: this.phone,
          zipcode: this.zipcode,
          address: this.address,
          email: this.email,
          birthdate: this.birthdate,
          gender: this.gender,
        })
        }
    }
  }
}
</script>

<style>
* {
  margin: 0px;
  padding: 0px;
  text-decoration: none;
  font-family:sans-serif;

}

body {
  background-image:#34495e;
}

.joinForm {
  position:absolute;
  width:400px;
  height:400px;
  padding: 30px, 20px;
  background-color:#FFFFFF;
  text-align:center;
  top:40%;
  left:50%;
  transform: translate(-50%,-50%);
  border-radius: 15px;
}

.joinForm h2 {
  text-align: center;
  margin: 30px;
}

.textForm {
  border-bottom: 2px solid #adadad;
  margin: 30px;
  padding: 10px 10px;
}


.id {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.pw {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.rrn {
  width: 49%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.name {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.email {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.nickname {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}

.cellphoneNo {
  width: 100%;
  border:none;
  outline:none;
  color: #636e72;
  font-size:16px;
  height:25px;
  background: none;
}
/* 
.btn {
  position:relative;
  left:40%;
  transform: translateX(-50%);
  margin-bottom: 40px;
  width:80%;
  height:40px;
  background: linear-gradient(125deg,#81ecec,#6c5ce7,#81ecec);
  background-position: left;
  background-size: 200%;
  color:white;
  font-weight: bold;
  border:none;
  cursor:pointer;
  transition: 0.4s;
  display:inline;
} */

.btn:hover {
  background-position: right;
}
</style>
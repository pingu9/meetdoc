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
      <span v-show="!valid.rrn && rrn1">
          올바른 주민번호를 입력해주세요.
        </span>
      <div class="textForm">
        <input name="nickname" type="text" class="nickname" placeholder="주소" v-model="address"  @click="execDaumPostcode()">
      </div>
      <div class="textForm">
        <input name="nickname" type="text" class="nickname" placeholder="우편번호" v-model="postcode" @click="execDaumPostcode()">
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
      postcode: '',	    
      address: '',
      email: '',
      birthdate: '',
      gender: '',
      // email valid에 추가해야함
      valid: {
        password: false,
        email: false,
        phone: false,
        duplicateId: false,
        rrn: false,
      },
      passwordHasError: false,
      emailHasError: false,
      phoneHasError: false,
      rrnHasError: false,
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
    },
    'rrn1': function () {
      this.checkRRN();
    }
  },

  methods: {
    execDaumPostcode() {
      new window.daum.Postcode({
        oncomplete: (data) => {
          if (this.extraAddress !== "") {
            this.extraAddress = "";
          }
          if (data.userSelectedType === "R") {
            // 사용자가 도로명 주소를 선택했을 경우
            this.address = data.roadAddress;
          } else {
            // 사용자가 지번 주소를 선택했을 경우(J)
            this.address = data.jibunAddress;
          }
 
          // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
          if (data.userSelectedType === "R") {
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
              this.extraAddress += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if (data.buildingName !== "" && data.apartment === "Y") {
              this.extraAddress +=
                this.extraAddress !== ""
                  ? `, ${data.buildingName}`
                  : data.buildingName;
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if (this.extraAddress !== "") {
              this.extraAddress = `(${this.extraAddress})`;
            }
          } else {
            this.extraAddress = "";
          }
          // 우편번호를 입력한다.
          this.postcode = data.zonecode;
        },
      }).open();
    },
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
    checkRRN() {
      var month = this.rrn1.slice(2, 4);
      var day = this.rrn1.slice(4, 6);
      if (month <= 0 || month > 12 || day <= 0 || day > 31) {
        this.valid.rrn = false;
        this.rrnHasError = true;
      } else {
        this.valid.rrn = true;
        this.rrnHasError = false;
      }
    },
    submitForm () {
      console.log('submit')
      console.log(this.userType)
      if (!this.valid.duplicateId) alert("아이디를 확인해주세요!");
      else if (!this.valid.password) alert("비밀번호 형식을 확인해주세요!");
      else if (!this.valid.email) alert("이메일 형식을 확인해주세요!");
      else if (!this.valid.phone) alert("핸드폰 형식을 확인해주세요!");
      else if (!this.valid.rrn) alert("주민번호를 확인해주세요!");
      else {
        this.$store.dispatch('signUp', {
          userId : this.userId,
          password: this.password,
          rrn: this.rrn1 + this.rrn2,
          userName: this.userName,
          phone: this.phone,
          zipcode: this.postcode,
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
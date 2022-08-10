import router from '@/routes/router';
import axios from 'axios';


export const actions = {
    getDepartments(context) {
        console.log('액션까지는 옴')
        axios.get('/api/appointment/departments').then((res) => {
            console.log(res.data);
            context.commit('setDepartments', res.data);
        });
    },
    getDoctorList(context, departmentCode) {
        return axios.get('/api/doctor/list/' + departmentCode);
    },
    getBookList() {
        const patientId = localStorage.getItem('userId');
        return axios.get('/api/appointment/info/list/' + patientId);
    },
    getCurrentUserInfo(context, param) {
        const token = localStorage.getItem('token')
        return axios.get('/api/user/info/' + param, {
            headers: {
                Authorization: 'Bearer ' + token
            }
        })
            .then((res) => {
                console.log('현재유저요청')
                context.commit('setCurrentUser', res.data);
            }),
              axios.get('/api/doctor/detail/' + param , {
            headers: {
                Authorization: 'Bearer ' + token
              }
              })
              .then((res) => {
                console.log('현재유저 요청에 의사정보 요청')
                context.commit('setCurrentDoctorInfo', res.data);
                console.log(res.data)
              })
    },
    signUp(context, payload) {
        console.log(payload)
        axios.post('/api/user/', payload)
            .then(() => {
                router.push({ name: 'home' });
            })
            .catch(error => {
                console.log('------------');
                console.log(error.response.data.message);
            });
    },
    doctorRegist(context, payload) {
      console.log(payload)
      axios.post('/api/doctor/regist', payload)
      .then(() => {
          localStorage.setItem('userType', 'D')
          router.push({ name: 'home' });
      })
      .catch(error => {
          console.log('------------');
          console.log(error.response.data.message);
      });
    },
    
    update(context, payload) {
        console.log(payload)
        if (confirm("회원정보를 수정하시겠습니까?")) {
          axios.patch('/api/user/', payload)
          .then(() => {
              router.push({ name: 'home' });
          })
          .catch(error => {
              console.log('------------');
              console.log(error.response.data.message);
          });
        }
    },
    userDelete() {
      if (confirm("회원탈퇴하시겠습니까?")) {
        axios.delete('/api/user/')
        .then(() => {
            localStorage.setItem('token', '');
            localStorage.setItem('userId', '');
            localStorage.setItem('userType', '');
            router.go()
        })
        .catch(error => {
            console.log('------------');
            console.log(error.response.data.message);
        });
      }
    },    
    login(context, idpw) {
        console.log(idpw)
        axios.post('/api/user/login', idpw)
            .then((res) => {
                if (res.data.message !== "Success") {
                    const error = {};
                    error.response = res;
                    return Promise.reject(error);
                }
                return res;
            })
            .then((res) => {
                console.log(res);
                context.commit('setLoginToken', res.data.accessToken)
                localStorage.setItem('token', res.data.accessToken);
                localStorage.setItem('userId', res.data.userId);
                localStorage.setItem('userType', res.data.userType);
                if (localStorage.getItem('userType') ==='D') {
                    console.log('의사는 차트리스트로!')
                    router.push({ name: 'chartList'})
                    router.go()
                } else {
                    router.push({ name: 'home' });
                    router.go()
                }
            })
            .catch(error => {
                console.log('------------');
                console.log(error.response.data.message);
                context.commit('setLoginErrorMessage', error.response.data.message);
            });
    },
    checkId(context, userId) {
        axios.get('/api/user/' + userId)
            .then((res) => {
                console.log(userId);
                console.log(res.data);
                context.commit('setIdErrorMessage', res.data.message);
            })
            .catch(error => {
                console.log('------------');
                console.log(error.response.data.message);
                context.commit('setIdErrorMessage', error.response.data.message);
            });
    },
    getChartList(context, doctorId) {
        axios.get('/api/appointment/info/list/doctor/' + doctorId).then((res) => {
            console.log(res.data);
            context.commit('setChartList', res.data);
        });
    },
    getChartDetail(context, appointmentId) {
        return axios.get('/api/appointment/info/detail/' + appointmentId);
    },
    setBookReq(context, bookReqInfo) {
        return axios.post('/api/appointment/reserve', bookReqInfo);
    },
    cancelApptByPatient(context, appointmentId) {
        return axios.patch('/api/appointment/cancel/patient/' + appointmentId);
    },
    cancelApptByDoctor(context, appointmentId) {
        return axios.patch('/api/appointment/cancel/doctor/' + appointmentId);
    },
    approveCancelByDoctor(context, appointmentId) {
        return axios.patch('/api/appointment/approve/doctor/' + appointmentId);
    },
    approveCancelByPatient(context, appointmentId) {
        return axios.patch('/api/appointment/approve/patient/' + appointmentId);
    },
    setAvailTime(context, param) {
        const doctorId = param.doctorId;
        const selectedDate = param.selectedDate;
        return axios.get('/api/appointment/available-time/' + doctorId + '/' + selectedDate);
    },
    getDoctorDetail(context, doctorId) {
        return axios.get('/api/doctor/detail/' + doctorId);
    },

    // saveLoginToken({ commit }, token) {

    //   commit('SET_TOKEN', token)
    //   localStorage.setItem('token', token)
    // },

    upload(context, formData){
        return axios({
            headers: {
              "Content-Type": "multipart/form-data",
              "Access-Control-Allow-Origin": "*",
            },
            url: '/api/s3/upload/images', // 파일 업로드 요청 URL
            method: "POST",
            data: formData,
          });
    },

    logout({ dispatch }) {
        if (confirm("로그아웃 하시겠습니까?")) {
            localStorage.setItem('token', '');
            localStorage.setItem('userId', '');
            localStorage.setItem('userType', '');
            dispatch('removeToken')
            // localStorage.setItem()
              alert("로그아웃 되었습니다.");
              
              router.push('/');
            } else {
            router.push('/');
            }
        },
    removeToken({ commit }) {
        commit('setToken','')
    }
};
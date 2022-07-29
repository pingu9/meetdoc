import router from '@/routes/router';
import axios from 'axios';

export const actions = {
    getData(context) {
        axios.get('https://jsonplaceholder.typicode.com/users').then((a) => {//test url 입력되있습니다
            console.log(a.data);
            context.commit('setData', a.data);
        });
    },
    getDepartments(context) {
        axios.get('http://localhost:8081/appointment/departments').then((a) => {
            console.log(a.data);
            context.commit('setDepartments', a.data);
        });
    },
    getDoctorList(context, departmentCode) {
        return axios.get('http://localhost:8081/doctor/list/' + departmentCode);
    },
    getBookList() {
        const patientId = 'user8';
        return axios.get('http://localhost:8081/appointment/info/list/' + patientId);
    },
    signUp(context, payload) {
        console.log(payload)
        axios.post('http://localhost:8081/user/', payload)
            .then((a) => {
                console.log(a.data)
            })
            .catch(error => {
              console.log('------------');
              console.log(error.response.data.message);
          });
    },
    login(context, idpw) {
        console.log(idpw)
        axios.post('http://localhost:8081/user/login', idpw)
            .then((a) => {
                console.log(a.data.accessToken);
                console.log(a.data);
                localStorage.setItem('token', a.data.accessToken);
                router.push({ name: 'home' });

            })
            .catch(error => {
                console.log('------------');
                console.log(error.response.data.message);
                context.commit('setLoginErrorMessage', error.response.data.message);
            });
    },
    checkId(context, userId) {
        axios.get('http://localhost:8081/user/' + userId)
            .then((a) => {
                console.log(userId);
                console.log(a.data);
                context.commit('setIdErrorMessage', a.data.message);
            })
            .catch(error => {
                console.log('------------');
                console.log(error.response.data.message);
                context.commit('setIdErrorMessage', error.response.data.message);
            });
    },
    getChartList(context, doctorId) {
        axios.get('http://localhost:8081/appointment/info/list/doctor/' + doctorId).then((a) => {
            console.log(a.data);
            context.commit('setChartList', a.data);
        });
    },
    getChartDetail(context, appointmentId) {
        return axios.get('http://localhost:8081/appointment/info/detail/' + appointmentId);
    },
    setBookReq(context, bookReqInfo) {
        return axios.post('http://localhost:8081/appointment/reserve', bookReqInfo);
    },
    cancelAppt(context, appointmentId) {
        return axios.delete('http://localhost:8081/appointment/cancel/' + appointmentId);
    },
};
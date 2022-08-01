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
        axios.get('/appointment/departments').then((a) => {
            console.log(a.data);
            context.commit('setDepartments', a.data);
        });
    },
    getDoctorList(context, departmentCode) {
        return axios.get('/doctor/list/' + departmentCode);
    },
    getBookList() {
        const patientId = localStorage.getItem('userId');
        return axios.get('/appointment/info/list/' + patientId);
    },
    signUp(context, payload) {
        console.log(payload)
        axios.post('/user/', payload)
            .then(() => {
                router.push({ name: 'home' });
            })
            .catch(error => {
                console.log('------------');
                console.log(error.response.data.message);
            });
    },
    login(context, idpw) {
        console.log(idpw)
        axios.post('/user/login', idpw)
            .then((a) => {
                console.log(a.data.accessToken);
                localStorage.setItem('token', a.data.accessToken);
                localStorage.setItem('userId', a.data.userId);
                router.push({ name: 'home' });

            })
            .catch(error => {
                console.log('------------');
                console.log(error.response.data.message);
                context.commit('setLoginErrorMessage', error.response.data.message);
            });
    },
    checkId(context, userId) {
        axios.get('/user/' + userId)
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
        axios.get('/appointment/info/list/doctor/' + doctorId).then((a) => {
            console.log(a.data);
            context.commit('setChartList', a.data);
        });
    },
    getChartDetail(context, appointmentId) {
        return axios.get('/appointment/info/detail/' + appointmentId);
    },
    setBookReq(context, bookReqInfo) {
        return axios.post('/appointment/reserve', bookReqInfo);
    },
    cancelAppt(context, appointmentId) {
        return axios.delete('/appointment/cancel/' + appointmentId);
    },
    setAvailTime(context, param) {
        const doctorId = param.doctorId;
        const selectedDate = param.selectedDate;
        console.log('/appointment/available-time/' + doctorId + '/' + selectedDate);
        return axios.get('/appointment/available-time/' + doctorId + '/' + selectedDate);
    },
    getDoctorDetail(context, doctorId) {
        return axios.get('/doctor/detail/' + doctorId);
    }
};
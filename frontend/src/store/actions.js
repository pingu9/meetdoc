import router from '@/routes/router';
import axios from 'axios';


export const actions = {
    getDepartments(context) {
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
    update(context, payload) {
        console.log(payload)
        axios.patch('/api/user/', payload)
        .then(() => {
            router.go()
        })
        .catch(error => {
            console.log('------------');
            console.log(error.response.data.message);
        });
    },
    userDelete() {
        axios.delete('/api/user/')
        .then(() => {
            router.go()
        })
        .catch(error => {
            console.log('------------');
            console.log(error.response.data.message);
        });
    },    
    login(context, idpw) {
        console.log(idpw)
        axios.post('/api/user/login', idpw)
            .then((res) => {
                console.log(res.data.accessToken);
                localStorage.setItem('token', res.data.accessToken);
                localStorage.setItem('userId', res.data.userId);
                localStorage.setItem('userType', res.data.userType);
                router.push({ name: 'home' });
                router.go()
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
    cancelAppt(context, appointmentId) {
        return axios.delete('/api/appointment/cancel/' + appointmentId);
    },
    setAvailTime(context, param) {
        const doctorId = param.doctorId;
        const selectedDate = param.selectedDate;
        return axios.get('/api/appointment/available-time/' + doctorId + '/' + selectedDate);
    },
    getDoctorDetail(context, doctorId) {
        return axios.get('/api/doctor/detail/' + doctorId);
    },
};
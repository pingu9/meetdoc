import router from '@/routes/router';
import axios from 'axios';


export const actions = {
    getDepartments(context) {
        axios.get('api/appointment/departments').then((a) => {
            console.log(a.data);
            context.commit('setDepartments', a.data);
        });
    },
    getDoctorList(context, departmentCode) {
        return axios.get('api/doctor/list/' + departmentCode);
    },
    getBookList() {
        const patientId = localStorage.getItem('userId');
        return axios.get('api/appointment/info/list/' + patientId);
    },
    getCurrentUserInfo(context, param) {
        const token = localStorage.getItem('token')
        return axios.get('api/user/info/' + param, {
            headers: {
                Authorization: 'Bearer ' + token
            }
        })
            .then((a) => {
                console.log('현재유저요청')
                context.commit('setCurrentUser', a.data);
            })
    },
    signUp(context, payload) {
        console.log(payload)
        axios.post('api/user/', payload)
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
        axios.post('api/user/login', idpw)
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
        axios.get('api/user/' + userId)
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
        axios.get('api/appointment/info/list/doctor/' + doctorId).then((a) => {
            console.log(a.data);
            context.commit('setChartList', a.data);
        });
    },
    getChartDetail(context, appointmentId) {
        return axios.get('api/appointment/info/detail/' + appointmentId);
    },
    setBookReq(context, bookReqInfo) {
        return axios.post('api/appointment/reserve', bookReqInfo);
    },
    cancelAppt(context, appointmentId) {
        return axios.delete('api/appointment/cancel/' + appointmentId);
    },
    setAvailTime(context, param) {
        const doctorId = param.doctorId;
        const selectedDate = param.selectedDate;
        return axios.get('api/appointment/available-time/' + doctorId + '/' + selectedDate);
    },
    getDoctorDetail(context, doctorId) {
        return axios.get('api/doctor/detail/' + doctorId);
    }
};
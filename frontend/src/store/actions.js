import router from '@/routes/router';
import axios from 'axios';

export const actions = {
    getData(context) {
        axios.get('https://jsonplaceholder.typicode.com/users/').then((a) => {//test url 입력되있습니다
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
    getDoctorList(context, param) {
        axios.get('http://localhost:8081/doctor/list/' + param).then((a) => {
            console.log(a.data.result);
            //context.commit('setDoctor', a.data.result[0].departmentName)
            context.commit('setDoctorList', a.data.result);
        });
    },
    getBookList(context) {
        axios.get('http://localhost:8081/appointment/info/list/user8').then((a) => {
            console.log(a.data);
            context.commit('setBookList', a.data);
        });
    },
    login(context, payload) {
        console.log(payload)
        axios.post('http://localhost:8081/user/login', payload)
            .then((a) => {
                console.log(a.data.accessToken);
                localStorage.setItem('token', a.data.accessToken);
                router.push({ name: 'home' });

            })
            .catch(error => {
                console.log('------------');
                console.log(error.response.data.message);
                context.commit('setLoginErrorMessage', error.response.data.message);
            });
    },
    checkId(context, param) {
        axios.get('http://localhost:8081/user/' + param)
            .then((a) => {
                console.log(param);
                console.log(a.data);
                context.commit('setIdErrorMessage', a.data.message);
            })
            .catch(error => {
                console.log('------------');
                console.log(error.response.data.message);
                context.commit('setIdErrorMessage', error.response.data.message);
            });
    },
    getChartList(context, param) {
        axios.get('http://localhost:8081/appointment/info/list/doctor/' + param).then((a) => {
            console.log(a.data);
            context.commit('setChartList', a.data);
        });
    },
    getChartDetail(context, param) {
        console.log('http://localhost:8081/appointment/info/detail/' + param);
        axios.get('http://localhost:8081/appointment/info/detail/' + param).then((a) => {
            console.log(a.data);
            context.commit('setChartDetail', a.data);

        });
    },
    setBookReq(context, payload) {
        return axios.post('http://localhost:8081/appointment/reserve', payload);
    },
};
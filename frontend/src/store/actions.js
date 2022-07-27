import axios from 'axios';

export const actions = {
    getData(context) {
        axios.get('https://jsonplaceholder.typicode.com/users/').then((a) => {//test url 입력되있습니다
            console.log(a.data);
            context.commit('setData', a.data);
        })
    },
    getDepartments(context) {
        axios.get('http://localhost:8081/appointment/departments').then((a) => {
            console.log(a.data);
            context.commit('setDepartments', a.data);
        })
    },
    getDoctorList(context, param) {
        axios.get('http://localhost:8081/appointment/doctor/list/' + param).then((a) => {
            console.log(a.data);
            context.commit('setDoctorList', a.data);
        })
    },
    login(context, payload) {
        console.log(payload)
        axios.post('http://localhost:8081/user/login', payload).then((a) => {
            console.log(a.data.accessToken)
            localStorage.setItem('token',a.data.accessToken)
        })
    }
};
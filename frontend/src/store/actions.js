import axios from 'axios';

export const actions = {
    getData(context) {
        axios.get('https://jsonplaceholder.typicode.com/users/').then((a) => {//test url 입력되있습니다
            console.log(a.data);
            context.commit('setData', a.data);
        })
    },
    getDepartments(context) {
        axios.get('http://localhost:8080/appointment/departments').then((a) => {
            console.log(a.data);
            context.commit('setDepartments', a.data);
        })
    },
    getDoctorList(context, param) {
        axios.get('http://localhost:8080/doctor/list/' + param).then((a) => {
            console.log(a.data);
            context.commit('setDoctorList', a.data);
        })
    }
};
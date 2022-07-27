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
        axios.get('http://localhost:8081/appointment/doctor/list/' + param, {}).then((a) => {
            console.log(a.data);
            context.commit('setDoctorList', a.data);
        })
    },
    getBookList(context){
        axios.get('http://localhost:8081/appointment/info/list/user8').then((a)=>{
            console.log(a.data);
            context.commit('setBookList', a.data)
        })
    },    
    login(context, payload) {
        console.log(payload)
        axios.post('http://localhost:8081/user/login', payload).then((a) => {
            console.log(a.data.accessToken)
            localStorage.setItem('token',a.data.accessToken)
        })
    },
    checkId(context, param) {
        axios.get('http://localhost:8081/user/'+ param)
        .then((a) => {
            console.log(param)
            console.log(a.data)
            context.commit('setIdErrorMessage', a.data.message)
        })
        .catch(error => {
            console.log('------------')
            console.log(error.response.data.message)
            context.commit('setIdErrorMessage', error.response.data.message)
        })
    }
};
import { createStore } from 'vuex'
import { mutations } from './mutations'
import { state } from './state'
import { actions } from './actions'
import { getters } from './getters'
import axios from 'axios'
import createPersistedState from 'vuex-persistedstate';
import doctorInfo from './doctorInfo';
import bookInfo from './bookInfo';
import meetingRoom from './meetingRoomInfo';

const store = createStore({
    modules: {
        doctorInfo: doctorInfo,
        bookInfo: bookInfo,
        meetingRoom: meetingRoom,
    },
    plugins: [
        createPersistedState({
            paths: ['doctorInfo', 'bookInfo', 'meetingRoom'],
        })
    ],
    state() {
        return state;
    },
    mutations,
    actions,
    getters
});

axios.interceptors.request.use(function (config) {
    if (localStorage.getItem('token')) {
        const token = 'Bearer ' + localStorage.getItem('token')
        config.headers.Authorization = token
    } else {
        console.log('토큰없음')
    }
    // headers: {
    //     Authorization: 'Bearer ' + token
    // }
    // })
    return config;
}, function (error) {
    // Do something with request error
    return Promise.reject(error);
});

export default store

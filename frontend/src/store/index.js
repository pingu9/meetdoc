import { createStore } from 'vuex'
import { mutations } from './mutations'
import { state } from './state'
import { actions } from './actions'
import { getters } from './getters'
import axios from 'axios'

const store = createStore({
    state() {
        return state;
    },
    mutations,
    actions,
    getters
});

axios.interceptors.request.use(function (config) {
  const token ='Bearer '+ localStorage.getItem('token')
      // headers: {
      //     Authorization: 'Bearer ' + token
      // }
  // })
  config.headers.Authorization = token
  return config;
}, function (error) {
  // Do something with request error
  return Promise.reject(error);
});

export default store

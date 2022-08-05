const state = {
  loginToken: "",
  isLoggedIn: false,
};

const getters = {
  isLoggedIn: state => !!state.loginToken,
};

// const actions = {
//   login(context, idpw) {
//     console.log(idpw)
//     axios.post('/api/user/login', idpw)
//         .then((res) => {
//             console.log(res);
//             context.commit('setLoginToken', res.data.accessToken)
//             localStorage.setItem('token', res.data.accessToken);
//             localStorage.setItem('userId', res.data.userId);
//             localStorage.setItem('userType', res.data.userType);
//             router.push({ name: 'home' })
//             // router.go()
//         })
//         .catch(error => {
//             console.log('------------');
//             console.log(error);
//             context.commit('setLoginErrorMessage', error);
//         });
// },
// }

const mutations = {
  setLoginToken(state, loginToken) {
    console.log("1234")
    console.log(typeof(state))
    console.log("state = " + state)
    state.loginToken = loginToken;
    console.log(state.loginToken)
  }
}

export default {
  state,
  getters,
  // actions,
  mutations
}
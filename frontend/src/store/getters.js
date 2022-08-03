export const getters = {
    getName(state) {
        return state.name;
    },
    isLoggedIn: state => !!state.loginToken,
};
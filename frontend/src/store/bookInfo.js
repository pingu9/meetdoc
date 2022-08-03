const state = {
    bookConfirm:{
        
    }
};

const getters = {
    getBookConfirm: state => state.bookConfirm,
};

const mutations = {
    setBookConfirm(state, data){
        state.bookConfirm = data;
    }
}

export default {
    state,
    getters,
    mutations
}
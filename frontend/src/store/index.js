import { createStore } from 'vuex'
import { mutations } from './mutations'
import { state } from './state'
import { actions } from './actions'
import { getters } from './getters'

const store = createStore({
    state() {
        return state;
    },
    mutations,
    actions,
    getters
});

export default store

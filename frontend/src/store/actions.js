import axios from 'axios';

export const actions = {
    getData(context) {
        axios.get('url들어가는 곳').then((a) => {
            console.log(a.data);
            context.commit('setMore', a.data);
        })
    }
};
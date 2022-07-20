import axios from 'axios';

export const actions = {
    getData(context) {
        axios.get('https://jsonplaceholder.typicode.com/users/').then((a) => {//test url 입력되있습니다
            console.log(a.data);
            context.commit('setData', a.data);
        })
    }
};
const state = {
    meetingInfo:{
        
    },
};

const getters = {
    getMeetingInfo: state => state.meetingInfo,
};

const mutations = {
    setMeetingInfo(state, data){
        state.meetingInfo = data;
    }
}

export default {
    state,
    getters,
    mutations
}
const state = {
    departmentCode: '',
    doctorId: '',
};

const getters = {
    getDoctorId: state => state.doctorId,
    getDepartmentCode: state => state.departmentCode,
};

const mutations = {
    setDoctorId(state, doctorId) {
        state.doctorId = doctorId;
    },
    setDepartmentCode(state, departmentCode) {
        state.departmentCode = departmentCode;
    }
}

export default {
    state,
    getters,
    mutations
}
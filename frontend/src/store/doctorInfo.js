const state = {
    departmentCode: '',
    doctorIdKept: '',
    departmentName:'',
    doctorName:'',
};

const getters = {
    getDoctorIdKept: state => state.doctorIdKept,
    getDepartmentCode: state => state.departmentCode,
    getDepartmentName: state => state.departmentName,
    getDoctorName: state => state.doctorName,
};

const mutations = {
    setDoctorIdKept(state, doctorIdKept) {
        state.doctorIdKept = doctorIdKept;
    },
    setDepartmentCode(state, departmentCode) {
        state.departmentCode = departmentCode;
    },
    setDepartmentName(state, departmentName){
        state.departmentName = departmentName;
    },
    setDoctorName(state, doctorName){
        state.doctorName = doctorName;
    }
}

export default {
    state,
    getters,
    mutations
}
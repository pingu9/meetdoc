const state = {
    departmentCode: '',
    doctorIdKept: '',
    departmentName: '',
    doctorName: '',
    deptName: '',
};

const getters = {
    getDoctorIdKept: state => state.doctorIdKept,
    getDepartmentCode: state => state.departmentCode,
    getDepartmentName: state => state.departmentName,
    getDoctorName: state => state.doctorName,
    getDeptName: state => state.deptName,
};

const mutations = {
    setDoctorIdKept(state, doctorIdKept) {
        state.doctorIdKept = doctorIdKept;
    },
    setDepartmentCode(state, departmentCode) {
        state.departmentCode = departmentCode;
    },
    setDepartmentName(state, departmentName) {
        state.departmentName = departmentName;
    },
    setDoctorName(state, doctorName) {
        state.doctorName = doctorName;
    },
    setDeptName(state, deptName) {
        state.deptName = deptName;
    }
}

export default {
    state,
    getters,
    mutations
}
export const mutations = {
    changeName(state) {
        state.name = 'nahyun'
    },
    setData(state, data) {
        state.value = data;
    },
    setDepartments(state, data) {
        state.departments = data;
    },
    setDoctorList(state, data) {
        state.doctors = data;
    },
    setDoctor(state, data){
        state.department = data;
    },
    setBookList(state, data){
        state.bookList = data;
    },
    setChartList(state, data){
        state.chartList = data;
    },
    setChartDetail(state, data){
         data.prescriptionDate = data.prescriptionDate.substr(0, 10);
        state.chartDetail = data;
    }
};
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
    setBookList(state, data){
        state.bookList = data;
    }
};
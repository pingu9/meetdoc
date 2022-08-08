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
    setCurrentUser(state, data) {
        console.log(data)
        state.currentUser = data;
    },
    setIdErrorMessage(state, data) {
        state.errorMessages.idCheckMessage = data;
    },

    setLoginErrorMessage(state, data) {
        state.errorMessages.loginErrorMessage = data;
    },

    setDoctor(state, data) {
        state.department = data;
    },
    setChartList(state, data) {
        state.chartList = data;
    },
    setChartDetail(state, data) {
        data.prescriptionDate = data.prescriptionDate.substr(0, 10);
        state.chartDetail = data;
    },
    setBookInfo(state, data) {
        state.bookInfo = data;
    },
    setDoctorDetail(state, data){
        state.doctorDetail = data;
    },
    
    setLoginToken(state, loginToken) {
        state.loginToken = loginToken
        console.log(state.loginToken)
<<<<<<< Updated upstream
    }
=======
    },
    setphotoUrl(state, photoUrl){
        state.photoUrl = photoUrl;
    },
    setToken: (state, token) => state.loginToken = token

>>>>>>> Stashed changes
};
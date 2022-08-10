export const state = {
    name: 'leyla',//state(데이터) 보관하고 싶으면 여기에 하셈
    value: {},
    doctors: [
    ],
    errorMessages: {
        idCheckMessage: '',
        loginErrorMessage: '',
    },
    doctorDetail: {
    },
    currentUser: {

    },
    currentDoctorInfo:{

    },

    loginToken: localStorage.getItem('token') || '',

    chartList: [

    ],
    chartDetail: {

    },
    departments: {

    },
    bookList: {

    },
    bookInfo: {

    },
    doctorId: '',
    photoUrl:[],
};
export const state = {
    name: 'leyla',//state(데이터) 보관하고 싶으면 여기에 하셈
    value: {},
    doctors: [

    ],
    doctorDetail: {
        id: 'doctor1',
        name: 'Dr.스트레인지',
        hospitalName: '마블병원',
        description: '마블병원 가정의학과 전문의 닥터 스트레인지입니다.',
        department: '가정의학과',
    },
    user1: {
        user_id: 'dsadas', user_type: '환자', name: '안현모', gender: 'male', birthdate: '1994/09/09',
        address: '서울시 강남구 역삼동 12-345', phone: '012-3456-7890', email: 'dsaddas@naver.com'
    },
    charts: [
        { name: '김환자', date: '2022-05-14 4:00PM' },
        { name: '이환자', date: '2022-02-05 2:00PM' },
        { name: '심환자', date: '2022-06-22 11:00AM' },
    ],
    chartDetail: {
        "id": '1',
        "title": '제목',
        "date": '2022-05-14 4:00PM',
        "userName": '김환자',
        "doctorId": 'doctor1',
        "description": '에어컨을 너무 쐬서 그런지 머리가 아프네요',
        "picture": '',
        "Prescription": '',
    },
    departments: {

    },
};
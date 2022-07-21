export const state = {
    name: 'leyla',//state(데이터) 보관하고 싶으면 여기에 하셈
    value: {},
    doctors: [
        { name: '의사1', hospital: '병원1', department: '진료과1' },
        { name: '의사2', hospital: '병원2', department: '진료과2' },
        { name: '의사3', hospital: '병원3', department: '진료과3' },
    ],
    specialties: [
        '진료과1', '진료과2', '진료과3', '진료과4', '진료과5', '진료과6', '진료과7', '진료과8', '진료과9'
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
    },
    charts: [
        { name: '김환자', date: '2022-05-14 4:00PM' },
        { name: '이환자', date: '2022-02-05 2:00PM' },
        { name: '심환자', date: '2022-06-22 11:00AM' },
    ]

};
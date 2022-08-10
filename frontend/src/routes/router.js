import { createWebHistory, createRouter } from "vue-router";

import MyPage from '../views/MyPage.vue';
import HomePage from '../views/HomePage.vue';
import DoctorList from '../views/DoctorList.vue';
import ChartList from '../views/ChartList.vue';
import BookHistory from '../views/BookHistory.vue';
import SignUp from '../views/SignUp.vue';
import ChartDetail from '../views/ChartDetail.vue';
import BookRequest from '../views/BookRequest.vue';
import BookPayment from '../views/BookPayment.vue';
import BookConfirm from '../views/BookConfirm.vue';
import MyPageUpdate from '../views/MyPageUpdate.vue';
import MeetingRoom from '../views/MeetingRoom.vue';
import DoctorRegister from '../views/DoctorRegister.vue';

const routes = [
    {
        path: "/",
        name: 'home',
        component: HomePage,
    },
    {
        path: "/mypage",
        component: MyPage,
    },    
    {
        path: "/mypage/update",
        name: 'mypageUpdate',
        component: MyPageUpdate,
    },

    {
        path: "/doctors/:departmentCode",
        component: DoctorList,
        name: 'doctorList'
    },
    {
        path: "/book/request",
        component: BookRequest,
        name: 'bookRequest'
    },
    {
        path: "/book/payment",
        component: BookPayment,
    },
    {
        path: "/book/confirm",
        component: BookConfirm,
        name: 'bookConfirm'
    },
    {
        path: "/chart/list",
        name: 'chartList',
        component: ChartList,
    },
    {
        path: "/chart/detail/:appointmentId",
        component: ChartDetail,
    },
    {
        path: "/book/list",
        component: BookHistory,
    },
    {
        path: "/signup",
        name: 'signup',
        component: SignUp,
    },
    {
      path: "/doctor/regist",
      name: 'doctorRegist',
      component: DoctorRegister,
    },
    {
        path: "/meetingroom",
        component: MeetingRoom,
        name: 'meetingRoom'
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router; 
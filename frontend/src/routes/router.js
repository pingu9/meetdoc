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
        path: "/doctors/:code",
        component: DoctorList,
    },
    {
        path: "/book/request",
        component: BookRequest,
    },
    {
        path: "/book/payment",
        component: BookPayment,
    },
    {
        path: "/book/confirm",
        component: BookConfirm,
    },
    {
        path: "/chart/list",
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
        component: SignUp,
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router; 
import { createWebHistory, createRouter } from "vue-router";

import MyPage from '../views/MyPage.vue';
import HomePage from '../views/HomePage.vue';
import DoctorList  from '../views/DoctorList.vue';


const routes = [
    {
        path: "/",
        component: HomePage,
    },
    {
        path: "/mypage",
        component: MyPage,
    },
    {
        path: "/doctors/1",
        component: DoctorList,
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router; 
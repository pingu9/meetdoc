import { createWebHistory, createRouter } from "vue-router";

import MyPage from '../views/MyPage.vue';
import HomePage from '../views/HomePage.vue';
import DoctorList from '../views/DoctorList.vue';
import ChartList from '../views/ChartList.vue';
import BookHistory from '../views/BookHistory.vue';


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
    },
    {
        path: "/chart/list",
        component: ChartList,
    },
    {
        path: "/book/list",
        component: BookHistory,
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router; 
import { createWebHistory, createRouter } from "vue-router";

import MyPage from '../views/MyPage.vue';
import HomePage from '../views/HomePage.vue';


const routes = [
    {
        path: "/",
        component: HomePage,
    },
    {
        path: "/mypage",
        component: MyPage,
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router; 
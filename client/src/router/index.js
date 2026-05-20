import { createRouter, createWebHistory } from 'vue-router';
import { ROUTER_NAME } from 'helpers/const';

const routes = [
  {
    path: '/login',
    name: ROUTER_NAME.LOGIN,
    component: () => import('pages/LoginPage.vue'),
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;

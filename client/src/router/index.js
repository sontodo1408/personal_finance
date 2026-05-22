import { createRouter, createWebHistory } from 'vue-router';
import { ROUTER_NAME } from 'helpers/const';

const routes = [
  {
    path: '/login',
    name: ROUTER_NAME.LOGIN,
    component: () => import('pages/LoginPage.vue'),
  },
  {
    path: '/',
    component: () => import('@/layouts/MainLayout.vue'),
    children: [
      {
        path: '',
        name: ROUTER_NAME.HOME,
        component: () => import('pages/HomePage.vue'),
      },
      {
        path: 'transaction-type',
        name: ROUTER_NAME.TRANSACTION_TYPE_MANAGEMENT,
        component: () => import('pages/transaction-type/TransactionTypePage.vue'),
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;

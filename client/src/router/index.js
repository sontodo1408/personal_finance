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
        path: 'category',
        name: ROUTER_NAME.CATEGORY,
        component: () => import('pages/category/CategoryPage.vue'),
      },
      {
        path: 'transaction/add',
        name: ROUTER_NAME.TRANSACTION_ADD,
        component: () => import('pages/transaction/TransactionPage.vue'),
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;

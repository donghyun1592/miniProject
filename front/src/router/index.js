import Vue from 'vue';
import VueRouter from 'vue-router';
import Vuex from 'vuex';

import DefaultLayout from '@/layouts/DefaultLayout';
import HomePage from '@/components/HomePage';
import Login from '@/components/User/Login';
import SignUp from '@/components/User/SignUp';
import MyPage from '@/components/User/MyPage';

import UsedMarket from '@/views/market/UsedMarket';

import VueDaumPostcode from 'vue-daum-postcode';


Vue.use(VueRouter);
Vue.use(Vuex);
Vue.use(VueDaumPostcode);


const routes = [{
  path: '/',
  component: DefaultLayout,
  children: [{
    path: '/',
    name: 'HomePage',
    component: HomePage,
  },
  {
    path: '/login',
    name: 'LoginPage',
    component: Login,
  },
  {
    path: '/signup',
    name: 'SignUp',
    component: SignUp,
  },
  {
    path: '/mypage',
    name: 'MyPage',
    component: MyPage,
  },
  {
    path: '/market',
    name: 'UsedMarket',
    component: UsedMarket,
  }],
}];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});


export default router;

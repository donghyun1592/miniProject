import Vue from 'vue';
import VueRouter from 'vue-router';
import Vuex from 'vuex';

import DefaultLayout from '@/layouts/DefaultLayout';
import HomePage from '@/components/HomePage';
import Login from '@/components/User/Login';
import SignUp from '@/components/User/SignUp';


Vue.use(VueRouter);
Vue.use(Vuex);


const routes = [{
  path: '/',
  name: 'DefaultLayout',
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
  }],
}];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});


export default router;

import Vue from 'vue';
import App from './App.vue';
import router from './router';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import {BootstrapVue, IconsPlugin} from 'bootstrap-vue';
import Vuelidate from 'vuelidate';
import axios from 'axios';

Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.use(BootstrapVue);

// axios를 import

Vue.prototype.$eventBus = new Vue();
Vue.prototype.$axios = axios;

Vue.use(Vuelidate);

Vue.config.productionTip = false;

new Vue({
  router,
  render: (h) => h(App),
}).$mount('#app');

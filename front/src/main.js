import Vue from 'vue';
import App from './App.vue';
import router from './router';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import {BootstrapVue, IconsPlugin} from 'bootstrap-vue';
import Vuelidate from 'vuelidate';


Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.use(BootstrapVue);
Vue.use(Vuelidate);

Vue.config.productionTip = false;

new Vue({
  router,
  render: (h) => h(App),
}).$mount('#app');

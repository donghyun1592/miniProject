import Vue from 'vue';
import App from './App.vue';
import router from './router';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import {BootstrapVue, IconsPlugin} from 'bootstrap-vue';
import store from './store';
import Vuelidate from 'vuelidate';
import * as Validators from 'vuelidate/lib/validators';
import ConfirmModal from '@/components/common/ConfirmModal';
import '../lib/common';

Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.use(BootstrapVue);

// UI-Form Validator
Vue.use(Vuelidate);
Vue.prototype.$validators = window.validators = Validators;

Vue.component('ConfirmModal', ConfirmModal);

Vue.prototype.$eventBus = new Vue();

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount('#app');

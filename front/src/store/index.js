import Vue from 'vue';
import Vuex from 'vuex';
import createPersistedState from 'vuex-persistedstate';

Vue.use(Vuex);

export default new Vuex.Store({

  plugins: [createPersistedState()],
  state: { // data
    token: '',
    member: {},
  },
  mutations: {
    setToken(state, token) {
      state.token=token;
    },
    setMember(state, member) {
      state.member = Object.assign({}, member);
    },
    logout(state) {
      state.member = {};
      state.token = '';
    },
  },
  actions: { // method
  },
  modules: {
  },
});

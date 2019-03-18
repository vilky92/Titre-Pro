import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    userId: null
  },
  getters: {
    userId(state) {
      return state.userId;
    }
  },
  mutations: {

  },
  actions: {

  }
})

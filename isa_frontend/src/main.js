import Vue from 'vue'

//import App from './App.vue'
import Start from './components/StartPage'
import router from "./routes";

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(Start),
}).$mount('#app')

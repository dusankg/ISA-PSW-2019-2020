import Vue from "vue";
import Router from "vue-router";
import DoctorApp from "../components/ListDoctorComponent.vue"
Vue.use(Router);

const router = new Router({
  mode: "history", // Use browser history
  routes: [
    {
      path: "/",
      name: "Home",
      component: () => import("./components/ListClinicsComponent")
    },
    {
      path: "/clinics",
      name: "Clinics",
      component: () => import("./components/ListClinicsComponent")
    },
    {
      path: "/doctors",
      name: "ListDoctors",
      component: DoctorApp
    }
  ]
});

export default router;
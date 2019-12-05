import Vue from "vue";
import Router from "vue-router"
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
      component: () => import("./components/ListDoctorsComponent")
    },
    {
      path: "/diagnosis",
      name: "ListDiagnosis",
      component: () => import("./components/ListDiagnosisComponent")
    },
    {
      path: "/medicalrooms",
      name: "ListMedicalRooms",
      component: () => import("./components/ListMedicalRoomsComponent")
    },
    {
      path: "/EnterClinicalCenterAdministrator",
      name: "EnterClinicalCenterAdministrator",
      component: () => import("./components/EnterClinicalCenterAdministratorComponent")
    },
    {
      path: "/ValidateClinicalCenterAdministrator/:id",
      name: "ValidateClinicalCenterAdministrator",
      component: () => import("./components/ValidateClinicalCenterAdministratorComponent")
    },
    {
      path: "/ClinicalCenterAdministratorHomePage/:id",
      name: "ClinicalCenterAdministratorHomePage",
      component: () => import("./components/ClinicalCenterAdministratorHomePageComponent")
    }
  ]
});

export default router;
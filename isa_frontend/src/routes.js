import Vue from "vue";
import Router from "vue-router"
Vue.use(Router);

const router = new Router({
  mode: "history", // Use browser history
  routes: [
    {
      path: "/",
      name: "Home",
      component: () => import("./components/LoginComponent")
    },
    {
      path: "/patients",
      name: "Patients",
      component: () => import("./components/ListPatientsComponent")
         
      
                    
      
    },
    {
      path: "/patientHomePage",
      name: "HomePagePatient",
      component: () => import("./components/HomePagePatientComponent")
    },
    {
      path: "/ClinicExaminationsPatient",
      name: "Examinations2",
      component: () => import("./components/ListExaminationsPatientComponent")
    },


    {
      path: "/EditPersonalData",
      name: "EditPersonalData",
      component: () => import("./components/EditPersonalDataComponent")
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
    },
    {
      path: "/login",
      name: "LoginComponent",
      component: () => import("./components/LoginComponent")
    },
    {
      path: "/patients",
      name: "ListPatientsComponent",
      component: () => import("./components/ListPatientsComponent")
    },
    {
      path: "/start",
      name: "StartPage",
      component: () => import("./components/StartPage")
    },
    {
      path: "/all",
      name: "All",
      component: () => import("./components/All")
    },
    {
      path: "/examinations",
      name: "ListExaminationsComponent",
      component: () => import("./components/ListExaminationsComponent")
    },
    {
      path: "/NurseHomePage/:id",
      name: "NurseHomePage",
      component: () => import("./components/NurseHomePageComponent")
    },
    {
      path: "/doctorHomePage/:id",
      name: "DoctorHomePage",
      component: () => import("./components/HomePageDoctorComponent")
    },
    {
      path:"/examinationtypes",
      name: "ListExaminationTypesComponent",
      component: () => import("./components/ListExaminationTypesComponent")
    },
    {
      path: "/addexaminationtype/:id", 
      name: "ExaminationTypeComponent",
      component: () => import("./components/AddExaminationTypeComponent")
    },
    {
      path: "/absencerequests",
      name: "ListAbsenceRequestsComponent",
      component: () => import("./components/ListAbsenceRequestsComponent")
    },
    {
      path: "/addabsencerequest/:id", 
      name: "CreateAbsenceRequestComponent",
      component: () => import("./components/CreateAbsenceRequestComponent")
    }, 
    {
      path: "/editadministrator/:id",
      name: "EditAdministratorComponent",
      component: () => import("./components/EditAdministratorComponent")
    }
  ]
});

export default router;
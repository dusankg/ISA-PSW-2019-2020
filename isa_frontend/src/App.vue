<template>
  <div class="container">
    <router-view/>
    <LoginApp/>
    <DiagnosisApp />
    <DoctorApp />
    <PatientApp />
    <ClinicCenterApp />
    <DiagnosisApp />
    <MedicalRoomApp />
    <EnterClinicalCenterAdministratorApp />
    
  </div>
</template>

<script>
import ClinicCenterApp from './components/ClinicCenterApp.vue'
import LoginApp from './components/LoginApp.vue'
import PatientApp from './components/PatientApp.vue'
import DoctorApp from './components/DoctorApp.vue'
import DiagnosisApp from './components/DiagnosisApp.vue'
import MedicalRoomApp from './components/MedicalRoomApp.vue'

import EnterClinicalCenterAdministratorApp from'./components/EnterClinicalCenterAdministratorApp.vue'
export default {
  name: 'app',
  components: {
    PatientApp,
    ClinicCenterApp,
    DoctorApp,
    DiagnosisApp,
    EnterClinicalCenterAdministratorApp,
    LoginApp
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
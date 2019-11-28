<template>
  <div class="container">
    <router-view/>
    <DiagnosisApp />
    <DoctorApp />
    <PatientApp />
    <ClinicCenterApp />
    <DiagnosisApp />
    <EnterClinicalCenterAdministratorApp />
    
  </div>
</template>

<script>
import ClinicCenterApp from './components/ClinicCenterApp.vue'

import PatientApp from './components/PatientApp.vue'
import DoctorApp from './components/DoctorApp.vue'
import DiagnosisApp from './components/DiagnosisApp.vue'
import EnterClinicalCenterAdministratorApp from'./components/EnterClinicalCenterAdministratorApp.vue'
export default {
  name: 'app',
  components: {
    PatientApp,
    ClinicCenterApp,
    DoctorApp,
    DiagnosisApp,
    EnterClinicalCenterAdministratorApp
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
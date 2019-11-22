<template>
  <div class="container">
    <DoctorApp />
    <PatientApp />
    <ClinicCenterApp />
  </div>
</template>

<script>
import ClinicCenterApp from './components/ClinicCenterApp.vue'

import PatientApp from './components/PatientApp.vue'
import DoctorApp from './components/DoctorApp.vue'
//import DiagnosisApp from './components/DiagnosisApp.vue'
export default {
  name: 'Patients',
  components: {
    PatientApp,
    ClinicCenterApp,
    DoctorApp
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
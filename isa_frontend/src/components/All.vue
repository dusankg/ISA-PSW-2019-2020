<template>
  <div class="container">

    <DiagnosisApp />
    <DoctorApp />

    <ClinicCenterApp />
    <MedicalRoomApp />
    <EnterClinicalCenterAdministratorApp />
    
  </div>
</template>

<script>
import ClinicCenterApp from './ClinicCenterApp.vue'

import DoctorApp from './DoctorApp.vue'
import DiagnosisApp from './DiagnosisApp.vue'
import MedicalRoomApp from './MedicalRoomApp.vue'

import EnterClinicalCenterAdministratorApp from'./EnterClinicalCenterAdministratorApp.vue'
export default {
  name: 'all',
  components: {

    ClinicCenterApp,
    DoctorApp,
    DiagnosisApp,

    MedicalRoomApp,
    EnterClinicalCenterAdministratorApp,
  }
}
</script>

<style>
#all {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
<template>
  <div class="container">
    <ClinicCenterApp />
  </div>
</template>

<script>
import ClinicCenterApp from './components/ClinicCenterApp.vue'

export default {
  name: 'ClinicCenter',
  components: {
    ClinicCenterApp
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

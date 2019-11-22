<template>
    <div>
        <h1>This is Clinic Center</h1>
        <ListClinicsComponent></ListClinicsComponent>
    </div>
</template>

<script>
import ListClinicsComponent from "./ListClinicsComponent";
export default {
    name: "ClinicCenterApp",
    components: {
    ListClinicsComponent
  }
}
</script>

<style scoped>
</style>
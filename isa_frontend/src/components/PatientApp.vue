<template>
    <div>
        <h1>This is  Patient list</h1>
        <ListPatientsComponent></ListPatientsComponent>
    </div>
</template>

<script>
import ListPatientsComponent from "./ListPatientsComponent";
export default {
    name: "PatientApp",
    components: {
    ListPatientsComponent
  }
}
</script>

<style scoped>

</style>
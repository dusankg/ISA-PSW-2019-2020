<template>
    <div>
        <h1>This is  Diagnosis list</h1>
        <ListDiagnosisComponent></ListDiagnosisComponent>
    </div>
</template>

<script>
import ListDiagnosisComponent from "./ListDiagnosisComponent";
export default {
    name: "DiagnosisApp",
    components: {
    ListDiagnosisComponent
  }
}
</script>

<style scoped>

</style>
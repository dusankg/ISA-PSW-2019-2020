<template>
    <div>
        <h1>This is Doctor list.....</h1>
        <ListDoctorsComponent></ListDoctorsComponent>
    </div>
</template>

<script>
import ListDoctorsComponent from "./ListDoctorsComponent";
export default {
    name: "DoctorApp",
    components: {
    ListDoctorsComponent
  }
}
</script>

<style scoped>
</style>
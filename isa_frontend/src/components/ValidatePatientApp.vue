<template>
  <div>
    <h1>Validate patient account </h1>
    <ValidatePatient></ValidatePatient> 
    

  </div>
</template>

<script>
export default {
  name: "ValidatePatientApp",
  computed: {
    id() {
      return this.$route.params.id;
    }
  },
  methods: {
    
}


}
</script>

<style>
</style>
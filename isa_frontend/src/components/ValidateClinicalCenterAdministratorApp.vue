<template>
  <div>
    <h1>Validate clinical center administrator account </h1>
    <ValidateClinicalCenterAdministartor></ValidateClinicalCenterAdministartor> 
    

  </div>
</template>

<script>
export default {
  name: "ValidateClinicalCenterAdministratorApp",
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
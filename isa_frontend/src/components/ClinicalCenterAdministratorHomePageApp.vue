<template>
  <div>
    <h1> Clinical center administrator home page </h1>
    <ClinicalCenterAdministratorHomePageComponent></ClinicalCenterAdministratorHomePageComponent> 
    

  </div>
</template>

<script>
export default {
  name: "ClinicalCenterAdministratorHomePageApp",
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
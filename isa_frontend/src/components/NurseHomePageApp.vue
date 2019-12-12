<template>
  <div>
    <h1> Nurse home page </h1>
    <NurseHomePageComponent></NurseHomePageComponent> 
    

  </div>
</template>

<script>
export default {
  name: "NurseHomePageApp",
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
<template>
  <div>
    <h1> Doctor home page </h1>
    <HomePageDoctorComponent></HomePageDoctorComponent> 
    

  </div>
</template>

<script>
export default {
  name: "HomePageDoctorApp",
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
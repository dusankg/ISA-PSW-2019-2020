<template>
  <div>
      <h3>Validate clinical center administrator account</h3>
      <div>{{id}}</div>
      <button v-on:click="validate">Validate account</button>
  </div>
</template>

<script>
import Axios from 'axios';
export default {
  name: "ValidateClinicalCenterAdministrator",
  data() {
    return {
      
    };
  },
  computed: {
    id() {
      return this.$route.params.id;
    }
  },
  methods: {
    refreshAdminDetails() {
    },
    validate: function(){
    
          /* eslint-disable no-console */
        console.log("**************************")
        console.log(this.$route.params.id)
        Axios.get("http://localhost:8082/api/clinicalCenterAdministrators/validate/"+this.$route.params.id)
    },
  },
  
  created() {
    this.refreshCourseDetails();
  }
};
</script>

<style>
</style>
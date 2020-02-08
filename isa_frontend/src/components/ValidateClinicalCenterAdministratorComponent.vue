<template>
  <div>
      <h3>Validate clinical center administrator account</h3>
      <div>
      
      <fieldset class="form-group">
        <label>Enter new password (must contain at least 5 letters)</label>
        <input type="password" class="form-control" v-model="textPassword">   
      </fieldset>
      
      <button v-on:click="validate" :disabled="this.textPassword.length < 5">Validate account</button>
      </div>
  </div>
</template>

<script>
import Axios from 'axios';
export default {
  name: "ValidateClinicalCenterAdministrator",
  data() {
    return {
      textPassword: ""
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
        Axios.get(`http://localhost:8082/api/clinicalCenterAdministrators/changePassword/${this.$route.params.id}/ ${this.textPassword}`);
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
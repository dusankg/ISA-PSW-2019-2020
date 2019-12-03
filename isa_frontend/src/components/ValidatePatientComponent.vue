<template>
  <div>
      <h3>Validate patient account</h3>
      <div>{{id}}</div>
      <button v-on:click="validate">Validate account</button>
  </div>
</template>

<script>
import Axios from 'axios';
export default {
    name: "ValidatePatient",
    data(){
        return {
            
       };
    },
    computed: {
        id() {
            return this.$route.params.id;
        }
    },
    methods: {
        refreshPatientDetails(){
     },
        validate: function(){
            /* eslint-disable no-console */
            Axios.get("http://localhost:8082/api/patients/validate/"+this.$route.params.id)


        },

    },
    created(){
        this.refreshPatientDetails();
    }
    
};
</script>

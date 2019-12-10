import axios from "axios";
Vue.use(Vuelidate);
<template>
  <div class="container">
    <h3>Clinic List</h3>
    <div class="container">
      <table class="table">
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Adress</th>
            <th>Description</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="clinic in clinics" v-bind:key="clinic.id">
            <td>{{clinic.id}}</td>
            <td>{{clinic.name}}</td>
            <td>{{clinic.adress}}</td>
            <td>{{clinic.description}}</td>
          </tr>
        </tbody>
      </table>
       <form @submit="val">
                <button class="btn btn-success" type="submit">Edit personal data</button>

      </form>
    </div>

    
  </div>




</template>

<script>
import ClinicCenterService from '../service/ClinicCenterService';
export default {
  name: "ListClinics",
  data() {
    return {
        clinics: [],
        message: null,
        INSTRUCTOR: "all"
    };
  },
  methods: {
    refreshClinics() {
        ClinicCenterService.retrieveAllClinics() 
            .then(response => {
                this.clinics = response.data;
        });
    },
    validateAndSubmit(e) {
    e.preventDefault();


    this.refreshClinics();
      },
      val(e){
          e.preventDefault();
           var indexx=this.$route.query.id
            this.$router.push('/EditPersonalData?id='+indexx) 

      }
  
  },
  created() {
    this.refreshClinics();
  }
};
</script>

<style>
</style>
import axios from "axios";
Vue.use(Vuelidate);
<template>
  <div class="container">
    <h3>All clinics</h3>
    <!--<router-link to = "/doctors"> Neki link </router-link>-->
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
            <td>
              <button class="btn btn-success" v-on:click="editClinicClicked(clinic.id)">
                Edit
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>

    <div>
    <h3>Add new clinic</h3>
    <div class="container">
      <form @submit="validateAndSubmit">
        <fieldset class="form-group" name="nameField">
          <label>Name</label>
          <input type="text" class="form-control" v-model="name" required>
        </fieldset>
        <fieldset class="form-group">
          <label>Address</label>
          <input type="text" class="form-control" v-model="adress" required>
        </fieldset>
        <fieldset class="form-group">
          <label>Description</label>
          <input type="text" class="form-control" v-model="description">
        </fieldset>
        <fieldset class="form-group">
          <label>Longitude</label>
          <input type="number" class="form-control" v-model="longitude">
        </fieldset>
        <fieldset class="form-group">
          <label>Latitude</label>
          <input type="number" class="form-control" v-model="latitude">
        </fieldset>  
        <button class="btn btn-success" type="submit">Add</button>
      </form>
    </div>
  </div>

  </div>


</template>

<script>
import ClinicCenterService from '../service/ClinicCenterService';
import Axios from 'axios';
export default {
  name: "ListClinics",
  data() {
    return {
        clinics: [],
        message: null,
        name: undefined,
        adress: undefined,
        description: undefined,
        longitude: undefined,
        latitude: undefined,
        id: undefined
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

      this.errors = [];
      if (!this.name) {
        this.errors.push("Enter valid values");
      } else if (this.adress.length < 1 ) {
        this.errors.push("Enter atleast 5 characters in Adress");
      }

      if (this.errors.length === 0) {
        var temp={
          "name":this.name,
          "adress":this.adress,
          "description":this.description,
          "gradeSum":0,
          "gradeNumber":0,
          "longitude": this.longitude,
          "latitude": this.latitude
        }
        this.name = ""
        this.adress = ""
        this.description = ""
        var id = 1
        Axios.put("http://localhost:8082/api/clinicalCenterAdministrators/validate", id)
        Axios.post("http://localhost:8082/api/clinics", temp)

        this.refreshClinics();
      }
    },

    editClinicClicked(id){
      this.$router.push(`/editclinic/${id}`)
    },

  },
  created() {
    this.refreshClinics();
  },
  
};
</script>

<style>

</style>
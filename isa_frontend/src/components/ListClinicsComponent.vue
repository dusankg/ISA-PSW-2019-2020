import axios from "axios";

<template>
  <div class="container">
    <h3>All clinics</h3>
    <router-link to = "/doctors"> Neki link</router-link>
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
    </div>

    <div>
    <h3>Add new clinic</h3>
    <div class="container">
      <form @submit="validateAndSubmit">
        <fieldset class="form-group">
          <label>Name</label>
          <input type="text" class="form-control" v-model="name" >
        </fieldset>
        <fieldset class="form-group">
          <label>Adress</label>
          <input type="text" class="form-control" v-model="adress">
        </fieldset>
        <fieldset class="form-group">
          <label>Description</label>
          <input type="text" class="form-control" v-model="description">
        </fieldset>
        <button class="btn btn-success" type="submit">Save</button>
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
    var temp={
      "name":this.name,
      "adress":this.adress,
      "description":this.description,
      "gradeSum":0,
      "gradeNumber":0
    }
    Axios.post("http://localhost:8082/api/clinics", temp);
    this.refreshClinics();
  }
  },
  created() {
    this.refreshClinics();
  }
};
</script>

<style>
</style>
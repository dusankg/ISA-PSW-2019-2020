import axios from "axios"

<template>
  <div class="container">
    <h3>All Patients</h3>
    <div class="container">
      <table class="table">
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Surname</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="patient in patients" v-bind:key="patient.id">
            <td>{{patient.id}}</td>
            <td>{{patient.name}}</td>
            <td>{{patient.surname}}</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div>
    <h3>Add new Patient</h3>
    <div class="container">
      <form @submit="validateAndSubmit">
        <fieldset class="form-group">
          <label>Name</label>
          <input type="text" class="form-control" v-model="name" >
        </fieldset>
        <fieldset class="form-group">
          <label>Surname</label>
          <input type="text" class="form-control" v-model="surname">
        </fieldset>
        <fieldset class="form-group">
          <label>Email</label>
          <input type="text" class="form-control" v-model="email">
        </fieldset>
        <button class="btn btn-success" type="submit">Save</button>
      </form>
    </div>


  </div>

  </div>





  
</template>

<script>
import PatientService from '../service/PatientService';
import Axios from 'axios';
export default {
  name: "ListPatients",
  data() {
    return {
        patients: [],
        message: null,
        INSTRUCTOR: "all"
    };
  },
  methods: {
    refreshPatients() {
        PatientService.retrieveAllPatients() 
            .then(response => {
                this.patients = response.data;
        });
    },
    validateAndSubmit(e) {
    e.preventDefault();
    var temp={
      "name":this.name,
      "surname":this.surname,
      "email":this.email,
      "adress":" ",
      "password": "111",
      "city":"Zrenjanin",
      "state":"Srbija",
      "phone": 0,
      "lbo": 0

    }
    Axios.post("http://localhost:8082/api/patients", temp);
    this.refreshPatients();
  }


  },
  created() {
    this.refreshPatients();
  }

};
</script>

<style>
</style>
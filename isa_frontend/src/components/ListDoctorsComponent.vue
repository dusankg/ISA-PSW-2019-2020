import axios from "axios";

<template>
  <div class="container">
    <h3>All Doctors</h3>
    <div class="container">
      <table class="table">
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Email</th>
            <th>Password</th>
            <th>Adress</th>
            <th>City</th>
            <th>State</th>
            <th>Phone</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="doctor in doctors" v-bind:key="doctor.id">
            <td>{{doctor.id}}</td>
            <td>{{doctor.name}}</td>
            <td>{{doctor.surname}}</td>
            <td>{{doctor.email}}</td>
            <td>{{doctor.password}}</td>
            <td>{{doctor.adress}}</td>
            <td>{{doctor.city}}</td>
            <td>{{doctor.state}}</td>
            <td>{{doctor.phone}}</td>
          </tr>
        </tbody>
      </table>
    </div>

    <div>
      <h3>Add new doctor</h3>
      <div class="container">
        <form @submit="validateAndSubmit">
          <fieldset class="form-group">
            <label>Name</label>
            <input type="text" class="form-control" v-model="name">
          </fieldset>
          <fieldset class="form-group">
            <label>Surname</label>
            <input type="text" class="form-control" v-model="surname">   
          </fieldset>
          <fieldset class="form-group">
            <label>E-mail</label>
            <input type="email" class="form-control" v-model="email">   
          </fieldset>
          <fieldset class="form-group">
            <label>Password</label>
            <input type="text" class="form-control" v-model="password">   
          </fieldset>
          <fieldset class="form-group">
            <label>Address</label>
            <input type="text" class="form-control" v-model="adress">   
          </fieldset>
          <fieldset class="form-group">
            <label>City</label>
            <input type="text" class="form-control" v-model="city">   
          </fieldset>
          <fieldset class="form-group">
            <label>State</label>
            <input type="text" class="form-control" v-model="state">   
          </fieldset>
          <fieldset class="form-group">
            <label>Phone</label>
            <input type="text" class="form-control" v-model="phone">   
          </fieldset>
          <button class="btn btn-success" type="submit">Save</button>
        </form>
      </div>
    </div>

  </div>
</template>

<script>
import DoctorService from '../service/DoctorService';
import Axios from 'axios';
export default {
  name: "ListDoctors",
  data() {
    return {
        doctors: [],
        message: null,
        INSTRUCTOR: "all"
    };
  },
  methods: {
    refreshDoctors() {
        DoctorService.retrieveAllDoctors() 
            .then(response => {
                this.doctors = response.data;
        });
    },
    validateAndSubmit(e){
      e.preventDefault();
      var temp={
        "name":this.name,
        "surname":this.surname,
        "password":this.password,
        "email":this.email,
        "adress":this.adress,
        "city":this.city,
        "state":this.state
      }
      Axios.post("http://localhost:8082/api/doctors", temp);
      this.refreshDoctors();
    }
  },
  created() {
    this.refreshDoctors();
  }

};
</script>

<style>
</style>
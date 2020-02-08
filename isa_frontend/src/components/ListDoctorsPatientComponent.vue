import axios from "axios";

<template>
  <div class="container">
    <h3>All Doctors</h3>
    <div v-if="message" class="alert alert-success">
        {{message}} 
    </div>
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
            <td><form @submit.prevent="select(doctor.id)">
                <button class="btn btn-success" type="submit">Select Doctor</button>

              </form></td>
          </tr>
        </tbody>
      </table>
    </div>

    
  </div>
</template>

<script>

//import Axios from 'axios';
import ClinicCenterService from '../service/ClinicCenterService';
export default {
  name: "ListDoctors",
  data() {
    return {
        doctors: [],
        message: null,
        name: undefined,
        surname: undefined,
        password: undefined,
        email: undefined,
        adress: undefined,
        city: undefined, 
        state: undefined,
        phone: undefined,
        idDoctor: undefined
    };
  },
  methods: {
    refreshDoctors() {
        
        ClinicCenterService.retrieveDoctorsOfClinic(this.$route.query.date,this.$route.query.type,this.$route.query.id,{withCredentials: true}) 
            .then(response => {
                this.doctors = response.data;
        });
    },
    select(id){
            this.idDoctor=id;
            this.$router.push('/requestPatient/?doctorId='+this.idDoctor, {withCredentials: true}); 

    }
    
    
  },
  created() {
    this.refreshDoctors();
  }

};
</script>

<style>
</style>
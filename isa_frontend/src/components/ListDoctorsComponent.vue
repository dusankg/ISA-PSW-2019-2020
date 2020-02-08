import axios from "axios";

<template>
  <div class="container">
    <h3>All Doctors</h3>
    <div v-if="message" class="alert alert-success">
        {{message}} 
    </div>
    <div class="container">
      <input type="text" class="form-control" v-model="searchName" placeholder="Search doctor by name"/>
      <input type="text" class="form-control" v-model="searchSurname" placeholder="Search doctor by surname"/>
      <input type="text" class="form-control" v-model="searchClinic" placeholder="Search doctor by clinic"/>
      <table class="table">
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Email</th>
            <th>Adress</th>
            <th>City</th>
            <th>State</th>
            <th>Phone</th>
            <th>Clinic</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="doctor in filteredDoctors" v-bind:key="doctor.id">
            <td>{{doctor.id}}</td>
            <td>{{doctor.name}}</td>
            <td>{{doctor.surname}}</td>
            <td>{{doctor.email}}</td>
            <td>{{doctor.adress}}</td>
            <td>{{doctor.city}}</td>
            <td>{{doctor.state}}</td>
            <td>{{doctor.phone}}</td>
            <td>{{doctor.clinic.name}}</td>
            <td>
              <button class="btn btn-warning" v-on:click=deleteDoctorClicked(doctor.id)>
                Delete 
              </button>
            </td>
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
          <fieldset class="form-group">
            <label>Start of work hour</label>
            <input type="number" class="form-control" v-model="workHourStart">   
          </fieldset>
          <fieldset class="form-group">
            <label>End of work hour</label>
            <input type="number" class="form-control" v-model="workHourFinish">   
          </fieldset>
          <fieldset class="form-group">
            <label>Clinic</label>
            <select class="form-control" @change="changedClinic($event)" required>
                <option value="" selected disabled>Choose clinic</option>
                <option v-for="clinic in clinics" :value="clinic.id" :key="clinic.id">{{clinic.name}}</option>
              </select>
          </fieldset>
          <button class="btn btn-success" type="submit">Add</button>
        </form>
      </div>
    </div>

  </div>
</template>

<script>
import DoctorService from '../service/DoctorService';
import ClinicService from '../service/ClinicCenterService';
import Axios from 'axios';
export default {
  name: "ListDoctors",
  data() {
    return {
        doctors: [],
        message: null,
        name: "",
        surname: "",
        password: undefined,
        email: undefined,
        adress: undefined,
        city: undefined, 
        state: undefined,
        phone: undefined,
        workHourStart: undefined,
        workHourFinish: undefined,
        clinics: [],
        selectedClinic: undefined,
        selectedClinicName: "",
        searchName: "",
        searchSurname: "",
        searchClinic: ""
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
        "state":this.state,
        "phone":this.phone,
        "workHourStart": this.workHourStart,
        "workHourFinish": this.workHourFinish,
        "clinic":this.selectedClinic
      }
      this.name = "",
      this.surname = "",
      this.password = "",
      this.email = "",
      this.adress = "",
      this.city = "",
      this.state = "",
      this.phone = 0,
      this.workHourStart = 0,
      this.workHourFinish = 0,
      Axios.post("http://localhost:8082/api/doctors", temp);
      this.refreshDoctors();
    },
    deleteDoctorClicked(id){
      DoctorService.deleteDoctor(id).then(response => {
        this.message = `Deleted doctor with id ${id} successfuly`;
        this.refreshDoctors();
        //only to avoid errors
        response.message 
      });
    },
    retrieveClinicsForSelect(){
      ClinicService.retrieveAllClinics().then(response => {
        this.clinics = response.data;
      });
    },
    changedClinic(event){
      this.selectedClinicName = event.target.options[event.target.options.selectedIndex].text;
      ClinicService.retrieveClinic(event.target.value).then(response => {
        this.selectedClinic = response.data;
      });
    }
  },

  computed: {
    filteredDoctors: function(){
      return this.doctors.filter((doctor) => {
        if(doctor.name.toLowerCase().match(this.searchName.toLowerCase()) &&
        doctor.surname.toLowerCase().match(this.searchSurname.toLowerCase()) &&
        doctor.clinic.name.toLowerCase().match(this.searchClinic.toLowerCase())){
          return true;
        } else {
          return false;
        }
      });
    }
  },

  created() {
    this.refreshDoctors();
    this.retrieveClinicsForSelect();
  },

  mounted() {
    this.refreshDoctors();
  }

};
</script>

<style>
</style>
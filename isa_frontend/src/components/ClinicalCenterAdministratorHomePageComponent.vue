<template>
  <div class="container">
    <h3>All non accepted patients</h3>
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
          <tr v-for="patient in nonAcceptedPatients" v-bind:key="patient.id">
            <td>{{patient.id}}</td>
            <td>{{patient.name}}</td>
            <td>{{patient.surname}}</td>
            <td>
              <button class="btn" v-on:click="deletePatient(patient.id)">
                Reject
              </button>
            </td>
            <td>
              <button class="btn" v-on:click="acceptPatient(patient.id)">
                Accept
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    </div>
</template>

<script>
//import PatientService from '../service/PatientService';
import Axios from 'axios';
export default {
  name: "ListPatients",
  data() {
    return {
        nonAcceptedPatients: [],
        administrator: {
          id: 0,
          name: '',
          surname:'',
          email:'',
          password:'',
          adress:'',
          city: '',
          state: '',
          phone: 0,
          validated: true
        },
        message: null,
        INSTRUCTOR: "all"
    };
  },
  methods: {
    refreshPatients() {
        Axios.get('http://localhost:8082/api/patients/nonAccepted').then(response => (this.nonAcceptedPatients = response.data))
        
    },
    refreshAdministrator(){
        Axios.get('http://localhost:8082/api/clinicalCenterAdministrators/'+ this.$route.params.id).then(response => (this.administrator = response.data))
        /* eslint-disable no-console */
        console.log("**************************")
    },
    deletePatient(index){
    /* eslint-disable no-console */
    console.log('Brisanje pacijenta'+index);
    Axios.delete('http://localhost:8082/api/patients/' + index)
    this.refreshPatients();

  },
  acceptPatient(index){
    /* eslint-disable no-console */
    console.log('Prihvatanje pacijenta' + index);
    Axios.get('http://localhost:8082/api/patients/accept/' + index)
    this.refreshPatients();
  }
  },
  created() {
    this.refreshPatients();
    this.refreshAdministrator();
  }
  
}
</script>
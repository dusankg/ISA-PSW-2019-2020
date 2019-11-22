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
  </div>
</template>

<script>
import PatientService from '../service/PatientService';
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
    }
  },
  created() {
    this.refreshPatients();
  }

};
</script>

<style>
</style>
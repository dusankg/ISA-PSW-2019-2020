<template>
  <div class="container">
    <h3>All clinics</h3>
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
    }
  },
  created() {
    this.refreshClinics();
  }

};
</script>

<style>
</style>
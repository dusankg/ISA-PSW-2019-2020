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
          </tr>
        </thead>
        <tbody>
          <tr v-for="doctor in doctors" v-bind:key="doctor.id">
            <td>{{doctor.id}}</td>
            <td>{{doctor.name}}</td>
            <td>{{doctor.surname}}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import DoctorService from '../service/DoctorService';
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
    }
  },
  created() {
    this.refreshDoctors();
  }

};
</script>

<style>
</style>
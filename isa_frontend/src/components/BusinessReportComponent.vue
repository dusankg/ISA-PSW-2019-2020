<template>
  <div>
      <h5>Average rating of clinic : {{this.clinicRating}}</h5>
      <h5>Average rating of doctors:</h5>
      <table class="table">
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Rating</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="doctor in doctors" v-bind:key="doctor.id">
            <td>{{doctor.id}}</td>
            <td>{{doctor.name}}</td>
            <td>{{doctor.surname}}</td>
            <td>{{calculateDoctorRating(doctor)}}</td>
          </tr>
        </tbody>
      </table>
  </div>
</template>

<script>
import Axios from 'axios';
export default {
    data() {
        return {
            clinic: undefined,
            clinicRating: 0,
            doctors: []
        };
    },

    methods: {
        retrieveClinic(){
            Axios.get('http://localhost:8082/api/clinics/' + this.$route.params.id).then(res => {
                this.clinic = res.data;
            })
        },
        calculateClinicRating(){
            if(this.clinic.gradeNumber != 0){
                this.clinicRating = this.clinic.gradeSum/this.clinic.gradeNumber;
            } else {
                this.clinicRating = 0;
            }
        },
        retrieveDoctors(){
            Axios.get(`http://localhost:8082/api/clinics/${this.$route.params.id}/doctors`).then(res => {
                this.doctors = res.data;
            });
        },
        calculateDoctorRating : function(doctor){
            if(doctor.gradeNumber != 0){
                return doctor.gradeSum/doctor.gradeNumber;
            } else {
                return 0;
            }
        }
            

    },
    mounted(){
        this.retrieveClinic();
        this.retrieveDoctors();
    }
}
</script>

<style>

</style>
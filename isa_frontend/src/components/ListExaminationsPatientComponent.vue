import axios from "axios";
Vue.use(Vuelidate);
<template>
  <div class="container">
    <h3>All Examinations</h3>
    <div class="container">
      <table class="table">
        <thead>
          <tr>
            <th>Id</th>
            <th>Date</th>
            <th>StartHour</th>
            <th>EndHour</th>
            <th>price</th>
            <th>typeName</th>
            <th>Doctor Name</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="examination in examinations" v-bind:key="examination.id">
            <td>{{examination.id}}</td>
            <td>{{examination.date}}</td>
            <td>{{examination.startTime}}</td>
            <td>{{examination.endTime}}</td>
            <td>{{examination.price}}</td>
            <td>{{examination.type.typeName}}</td>
            <td>{{examination.doctor.name}}</td>
            <td>
              <form @submit="appoint(examination.id)">
                <button class="btn btn-success" type="submit">Select Examination</button>

              </form>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    
  </div>
</template>

<script>
import ExaminationService from '../service/ExaminationService';

import Axios from 'axios';
export default {
  name: "ListExaminations",
  data() {
    return {
        examinations: [],
    
    };
  },
  methods: {
    refreshExaminations() {
        ExaminationService.retrieveAllNonReservedExaminations({withCredentials: true})
            .then(response => {
                this.examinations = response.data;
        });
    },
    appoint(id1) {
      /* eslint-disable no-console */
      console.log(id1)
      console.log(this.$route.query.id)
    Axios.get('http://localhost:8082/api/examinations/sendVerificationMail/' + id1,{withCredentials: true} )
       this.$router.push('/patientHomePage') 
    
    //this.refreshClinics();
      }, 


  },
  created() {
    this.refreshExaminations();
   
  }

};
</script>

<style>
</style>
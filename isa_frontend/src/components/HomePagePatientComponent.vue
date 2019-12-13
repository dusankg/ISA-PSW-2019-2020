import axios from "axios";
Vue.use(Vuelidate);
<template>
  <div class="container">
    <h3>Clinic List</h3>
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
      <table class="table">
        <thead>
          <tr>
            <th>Id</th>
            <th>Date</th>
            <th>Duration</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="examination in examinations" v-bind:key="examination.id">
            <td>{{examination.id}}</td>
            <td>{{examination.date}}</td>
            <td>{{examination.duration}}</td>
            <td>{{examination.price}}</td>
            <td>
              <form @submit="appoint(examination.id)">
                <button class="btn btn-success" type="submit">Select Examination</button>

              </form>
            </td>
          </tr>
        </tbody>
      </table>

       <form @submit="val">
                <button class="btn btn-success" type="submit">Edit personal data</button>

      </form>
    </div>

    
  </div>




</template>

<script>
import ClinicCenterService from '../service/ClinicCenterService';
import ExaminationService from '../service/ExaminationService';
import Axios from 'axios';
export default {
  name: "ListClinics",
  data() {
    return {
        idLogovan: [],
        clinics: [],
        examinations: [],
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
        
    },
    refreshExainations(){
      ExaminationService.retrieveAllExaminations()
            .then(response => {
                this.examinations = response.data;
            }
            );
    },
    validateAndSubmit(e) {
    e.preventDefault();


    this.refreshClinics();
      },
    appoint(id1) {
      /* eslint-disable no-console */
      console.log(id1)
      console.log(this.$route.query.id)
       this.$router.push('/patientHomePage?id='+this.$route.query.id) 
    Axios.get('http://localhost:8082/api/examinations/reserve/' + id1 + '/' + this.$route.query.id)
    
    //this.refreshClinics();
      },  




      val(e){
          e.preventDefault();
           var indexx=this.$route.query.id
            this.$router.push('/EditPersonalData?id='+indexx) 

      }


  
  },
  created() {
 
    this.refreshClinics();
    this.refreshExainations();
    

  }
};
</script>

<style>
</style>
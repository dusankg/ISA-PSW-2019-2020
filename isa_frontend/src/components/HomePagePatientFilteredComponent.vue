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
            <td><form @submit.prevent="select(clinic.id)">
                <button class="btn btn-success" type="submit">Select Clinic</button>

              </form></td>
          </tr>
        </tbody>
      </table>
     

       <form @submit="val">
                <button class="btn btn-success" type="submit">Edit personal data</button>

      </form>
      <form @submit.prevent="pretraga">
                <button class="btn btn-success" type="submit">Pretraga klinika</button>

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
        doctors: [],
        examinations: [],
        message: null,
        searchDate: "",
        searchType: "", 
        INSTRUCTOR: "all",
    };
  },
  methods: {
    refreshClinics() {
        alert(this.$route.query.type);
        ClinicCenterService.retrieveAllClinicsFiltered(this.$route.query.date,this.$route.query.type,{withCredentials: true}) 
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
    /*appoint(id1) {
      /* eslint-disable no-console */
    /*  console.log(id1)
      console.log(this.$route.query.id)
       this.$router.push('/patientHomePage?id='+this.$route.query.id) 
    Axios.get('http://localhost:8082/api/examinations/reserve/' + id1 + '/' + this.$route.query.id)
    
    //this.refreshClinics();
      },  */
      select(id1){
        /* eslint-disable no-console */
        Axios.get('http://localhost:8082/api/clinics/select/' + id1,{withCredentials: true})
        this.$router.push('/ClinicExaminationsPatient/?date='+this.$route.query.date+'&type='+this.$route.query.type+'&id='+id1,{withCredentials: true}) ;
      },



      val(e){
          e.preventDefault();
          
            this.$router.push('/EditPersonalData') 

      },
      pretraga(e){
          e.preventDefault();
           
            this.$router.push('/pretragaPatient') 

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
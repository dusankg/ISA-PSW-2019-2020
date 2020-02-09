import axios from "axios";
Vue.use(Vuelidate);
<template>
  <div class="container">
    <h3>All Examinations</h3>
    <div class="container">
      <table class="table">
        <thead>
          <tr>
            <th @click="sortById()">Id</th>
            <th @click="sortByDate()" >Date</th>
            <th>StartHour</th>
            <th>EndHour</th>
            <th @click="sortByPrice()">price</th>
            <th>typeName</th>
            <th @click="sortByName()">Doctor Name</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="examination in examinations" v-bind:key="examination.id">
            <td>{{examination.id}}</td>
            <td>{{examination.date}}</td>
            <td>{{examination.startTime / 60}} : {{examination.startTime % 60 * 60}}</td>
            <td>{{examination.endTime / 60}} : {{examination.endTime % 60 * 60}} </td>
            <td>{{examination.price}}</td>
            <td>{{examination.type.typeName}}</td>
            <td>{{examination.doctor.name}}</td>
            
          </tr>
        </tbody>
      </table>
    </div>
    
  </div>
</template>

<script>
import ExaminationService from '../service/ExaminationService';


export default {
  name: "ListExaminations",
  data() {
    return {
        examinations: [],
        currentSortDir: "desc",
    
    };
  },
  methods: {
    refreshExaminations() {
        ExaminationService.retrieveAllPatientExaminations({withCredentials: true})
            .then(response => {
                this.examinations = response.data;
        });
    },
    sortById(){
            if(this.currentSortDir === "desc"){
                this.examinations.sort((a, b) => a.id > b.id ? 1 : -1);
                this.currentSortDir = "asc";
            }else{
                this.examinations.sort((a, b) => a.id < b.id ? 1 : -1);
                this.currentSortDir = "desc";
            }
        },
     sortByDate(){
            if(this.currentSortDir === "desc"){
                this.examinations.sort((a, b) => a.date > b.date ? 1 : -1);
                this.currentSortDir = "asc";
            }else{
                this.examinations.sort((a, b) => a.date < b.date ? 1 : -1);
                this.currentSortDir = "desc";
            }
        },
        sortByPrice(){
            if(this.currentSortDir === "desc"){
                this.examinations.sort((a, b) => a.price > b.price ? 1 : -1);
                this.currentSortDir = "asc";
            }else{
                this.examinations.sort((a, b) => a.price < b.price ? 1 : -1);
                this.currentSortDir = "desc";
            }
        },
        sortByName(){
            if(this.currentSortDir === "desc"){
                this.examinations.sort((a, b) => a.doctor.name > b.doctor.name ? 1 : -1);
                this.currentSortDir = "asc";
            }else{
                this.examinations.sort((a, b) => a.doctor.name < b.doctor.name ? 1 : -1);
                this.currentSortDir = "desc";
            }
        }       


  },
  created() {
    this.refreshExaminations();
   
  }

};
</script>

<style>
</style>
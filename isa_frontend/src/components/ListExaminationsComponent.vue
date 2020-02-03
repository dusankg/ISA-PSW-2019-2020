import axios from "axios";

<template>
  <div class="container">
    <h3>All Examinations</h3>
    <div v-if="message" class="alert alert-success">
        {{message}} 
    </div>
    <div class="container">
      <table class="table">
        <thead>
          <tr>
            <th>Id</th>
            <th>Date</th>
            <th>Duration</th>
            <th>Price</th>
            <th>Type</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="examination in examinations" v-bind:key="examination.id">
            <td>{{examination.id}}</td>
            <td>{{examination.date}}</td>
            <td>{{examination.duration}}</td>
            <td>{{examination.price}}</td>
            <td>{{examination.type.typeName}}</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div>
      <h3>Add new examination</h3>
        <div class="container">
          <form @submit="validateAndSubmit">
            <fieldset class="form-group">
              <label>Date</label>
              <input type="date" class="form-control" v-model="date">
            </fieldset>
            <fieldset class="form-group">
              <label>Duration</label>
              <input type="number" class="form-control" v-model="duration">   
            </fieldset>
            <fieldset class="form-group">
              <label>Price</label>
              <input type="number" class="form-control" v-model="price">   
            </fieldset>
            <fieldset class="form-group">
              <label>Type of examination</label>
              <select class="form-control" @change="changedType($event)" required>
                <option value="" selected disabled>Choose type</option>
                <option v-for="examinationType in examinationTypes" :value="examinationType.id" :key="examinationType.id">{{examinationType.typeName}}</option>
              </select>
            </fieldset>
            <button class="btn btn-success" type="submit">Save</button>
          </form>
      </div>
    </div>
  </div>
</template>

<script>
import ExaminationService from '../service/ExaminationService';
import ExaminationTypeService from '../service/ExaminationTypeService';
import Axios from 'axios';
export default {
  name: "ListExaminations",
  data() {
    return {
        examinations: [],
        message: null,
        date: undefined,
        duration: undefined,
        price: undefined,
        examinationTypes: [],
        selectedType: undefined,
        selectedTypeName: ""
    };
  },
  methods: {
    refreshExaminations() {
        ExaminationService.retrieveAllExaminations() 
            .then(response => {
                this.examinations = response.data;
        });
    },
    validateAndSubmit(e){
      e.preventDefault();

      var temp={
        "date":this.date,
        "duration":this.duration,
        "price":this.price,
        "type": this.selectedType
      }
      Axios.post("http://localhost:8082/api/examinations", temp);
      this.refreshExaminations();
    },
    retrieveExaminationTypesForSelect(){
        ExaminationTypeService.retrieveAllExaminationTypes().then(response =>{
            this.examinationTypes = response.data;
        });
    },
    changedType(event){
      this.selectedTypeName = event.target.options[event.target.options.selectedIndex].text;
      // event.target.value -> id of selected examination type
      ExaminationTypeService.retrieveExaminationType(event.target.value).then(response =>{
        this.selectedType = response.data;
      });
    }
    
  },
  created() {
    this.refreshExaminations();
    this.retrieveExaminationTypesForSelect();
  }

};
</script>

<style>
</style>
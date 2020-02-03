import axios from "axios";

<template>
  <div class="container">
    <h3>All Examinations</h3>
    <div v-if="message" class="alert alert-success">
        {{message}} 
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
              <label>Type of examination</label>
              <select class="form-control" required>
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
import ExaminationTypeService from '../service/ExaminationTypeService';
//import Axios from 'axios';
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
    retrieveExaminationTypesForSelect(){
        ExaminationTypeService.retrieveAllExaminationTypes().then(response =>{
            this.examinationTypes = response.data;
        });
    }
  },
  mounted() {
        this.retrieveExaminationTypesForSelect();
  }

};
</script>

<style>
</style>

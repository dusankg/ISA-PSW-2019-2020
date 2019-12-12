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
          </tr>
        </thead>
        <tbody>
          <tr v-for="examination in examinations" v-bind:key="examination.id">
            <td>{{examination.id}}</td>
            <td>{{examination.date}}</td>
            <td>{{examination.duration}}</td>
            <td>{{examination.price}}</td>
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
            <button class="btn btn-success" type="submit">Save</button>
          </form>
      </div>
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
        message: null,
        date: undefined,
        duration: undefined,
        price: undefined
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
      }
      Axios.post("http://localhost:8082/api/examinations", temp);
      this.refreshExaminations();
    }
    
  },
  created() {
    this.refreshExaminations();
  }

};
</script>

<style>
</style>
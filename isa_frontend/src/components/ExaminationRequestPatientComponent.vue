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
          <fieldset class="form-group" >
              <label>Date</label>
              <input type="date" class="form-control" v-model="date">
            </fieldset>

            <fieldset class="form-group">
              <label>Starting time</label>
              <select class="form-control"  v-model="startTime" required>
                <option value="" selected disabled>Choose starting hour</option>
                <option value="7">7h</option><option value="8">8h</option> <option value="9">9h</option>
                <option value="10">10h</option><option value="11">11h</option> <option value="12">12h</option>
                <option value="13">13h</option><option value="14">14h</option> <option value="15">15h</option>
                <option value="16">16h</option><option value="17">17h</option> <option value="18">18h</option>
              </select>
            </fieldset>

            <fieldset class="form-group">
              <select class="form-control" v-model="startTime2" required>
                <option value="" selected disabled>Choose starting minut</option>
                <option value="0">0min</option><option value="5">5min</option> <option value="10">10min</option>
                <option value="15">15min</option><option value="20">20min</option> <option value="25">25min</option>
                <option value="30">30min</option><option value="35">35min</option> <option value="40">40min</option>
                <option value="45">45min</option><option value="50">50min</option> <option value="55">55min</option>
              </select>
            </fieldset>


            <fieldset class="form-group">
              <label>Duration</label>
              <select class="form-control" v-model="duration" required>
                <option value="" selected disabled>Choose duration hour</option>
                <option value="0">0h</option><option value="1">1h</option> <option value="2">2h</option>
                <option value="3">3h</option><option value="4">4h</option> <option value="5">5h</option>
              </select>
            </fieldset>

            <fieldset class="form-group">
              <select class="form-control" v-model="duration2" required>
                <option value="" selected disabled>Choose duration minut</option>
                <option value="0">0min</option><option value="5">5min</option> <option value="10">10min</option>
                <option value="15">15min</option><option value="20">20min</option> <option value="25">25min</option>
                <option value="30">30min</option><option value="35">35min</option> <option value="40">40min</option>
                <option value="45">45min</option><option value="50">50min</option> <option value="55">55min</option>
              </select>
            </fieldset>
            <fieldset class="form-group">
              <label>Type of examination</label>
              <select class="form-control" v-model="examinationTypee"  required>
                <option value="" selected disabled>Choose type</option>
                <option v-for="examinationType in examinationTypes" :value="examinationType.id" :key="examinationType.id">{{examinationType.typeName}}</option>
              </select>
            </fieldset>
            <button class="btn btn-primary" type="submit">Send request for scheduling the examination to clinic administrator</button>
          </form>
      </div>
    </div>
  </div>
</template>

<script>
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
    retrieveExaminationTypesForSelect(){
        ExaminationTypeService.retrieveAllExaminationTypes({withCredentials: true}).then(response =>{
            this.examinationTypes = response.data;
        });
    },
    validateAndSubmit(e){
      e.preventDefault()
      var temp={
        "date":this.date,
        "startTime":(parseInt(this.startTime*60) + parseInt(this.startTime2)),
        "endTime":parseInt(this.startTime*60) + parseInt(this.startTime2) + parseInt(this.duration *60) + parseInt(this.duration2),
        "price": null,
        "accepted":false,
        "operation":false,
        "examinationType": this.examinationTypee



      }
          alert(temp.examinationType)
            Axios.post("http://localhost:8082/api/examinations/patientCreate/"+this.$route.query.doctorId+'/'+temp.examinationType, temp,{withCredentials: true});



    }

  },
  mounted() {
        this.retrieveExaminationTypesForSelect({withCredentials: true});
  }

};
</script>

<style>
</style>
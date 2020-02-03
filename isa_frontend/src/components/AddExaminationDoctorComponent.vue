<template>
  <div>
      <h3>Schedule new examination</h3>
        <div class="container">
          <form @submit="validateAndSubmit">
            <fieldset class="form-group">
              <label>Date</label>
              <input type="date" class="form-control" v-model="date">
            </fieldset>
            <fieldset class="form-group">
              <label>Start Time</label>
              <input type="time" class="form-control" v-model="startTime">   
            </fieldset>
            <fieldset class="form-group">
              <label>End Time</label>
              <input type="time" class="form-control" v-model="endTime">   
            </fieldset>
            <fieldset class="form-group">
              <label>Type of examination</label>
              <select class="form-control" @change="changedType($event)" required>
                <option value="" selected disabled>Choose type</option>
                <option v-for="examinationType in examinationTypes" :value="examinationType.id" :key="examinationType.id">{{examinationType.typeName}}</option>
              </select>
            </fieldset>
            <button class="btn btn-primary" type="submit">Send request for scheduling the examination to clinic administrator</button>
          </form>
      </div>
    </div>
</template>

<script>
//import ExaminationService from '../service/ExaminationService';
import ExaminationTypeService from '../service/ExaminationTypeService';
import Axios from 'axios';
export default {
  name: "AddExamination",
  data() {
    return {
        date: undefined,
        startTime: undefined,
        endTime: undefined,
        examinationTypes: [],
        selectedType: undefined,
        selectedTypeName: ""
    };
  },
  methods: {
    validateAndSubmit(e){
      e.preventDefault();

      var temp={
        "date":this.date,
        "startTime":this.startTime,
        "endTime":this.endTime,
        "type": this.selectedType
      }
      Axios.post("http://localhost:8082/api/examinations", temp);
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
  mounted() {
    this.retrieveExaminationTypesForSelect();
  }

}
</script>

<style>

</style>
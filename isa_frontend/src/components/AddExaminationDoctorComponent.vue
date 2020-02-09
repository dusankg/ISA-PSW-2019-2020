<template>
  <div>
      <h3>Schedule new examination</h3>
        <div class="container">
          <form @submit="validateAndSubmit">
            <fieldset class="form-group">
              <input type="checkbox" class="form-check-input" v-model="operation">
              <label>Check if examination is operation</label>
            </fieldset>
            <fieldset class="form-group">
              <label>Date</label>
              <input type="date" class="form-control" v-model="date">
            </fieldset>
            <fieldset class="form-group">
              <label>Start Time</label>
              <input type="number" class="form-control" v-model="startTime">   
            </fieldset>
            <fieldset class="form-group">
              <label>End Time</label>
              <input type="number" class="form-control" v-model="endTime">   
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
import DoctorService from '../service/DoctorService';
//import PatientService from '../service/PatientService';
import ClinicService from '../service/ClinicCenterService';
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
        selectedTypeName: "",
        operation: false,
        doctor: undefined,
        patient: undefined,
        clinic: undefined,
        examination: undefined
    };
  },
  methods: {
    validateAndSubmit(e){
      e.preventDefault();

      var temp={
        "date":this.date,
        "startTime":this.startTime*60,
        "endTime":this.endTime*60,
        "type": this.selectedType,
        "accepted": false,
        "operation": this.operation,
        "doctor": this.doctor,
        "patient": this.patient,
        "price":0,
        "clinic": this.clinic
      }
      Axios.post("http://localhost:8082/api/examinations", temp).then(response =>{
        this.examination = response.data;
        Axios.get(`http://localhost:8082/api/examinations/send/${this.examination.id}`, {withCredentials:true});
        this.$router.push(`/makeReport/${this.$route.params.idd}/${this.$route.params.idp}`);
      });
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
    },
    retrieveDoctor(){
      DoctorService.retrieveDoctor(this.$route.params.idd).then(response => {
        this.doctor = response.data;
      });
    },
    retrievePatient(){
        Axios.get(`http://localhost:8082/api/patients/${this.$route.params.idp}`).then(response => {
        this.patient = response.data;
      });
    },
    retrieveClinic(){
        ClinicService.retrieveClinic(1).then(response => {
        this.clinic = response.data;
      });
    },
    
  },

  mounted() {
    this.retrieveExaminationTypesForSelect();
    this.retrieveDoctor();
    this.retrievePatient();
    this.retrieveClinic();
  }

}
</script>

<style>

</style>
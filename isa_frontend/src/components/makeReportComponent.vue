import axios from "axios";

<template>
  <div class="container">
    <div>
      
        <div class="container">
          <h3>Add informations about report</h3>
          <form @submit="validateAndSubmit">
            <fieldset class="form-group">
              <label>Textual report</label>
              <input type="text" class="form-control" v-model="textReport">   
            </fieldset>
            <br>
            <fieldset>
              <label>Patient does not have diagnosis and does not need prescription  .</label>
              <input type="checkbox" :id="poid" name="single_select" ref="rolesSelected" >
            </fieldset>
            <fieldset class="form-group">
              <label>Diagnosis</label>
              <select class="form-control" @change="changedDiagnosis($event)">
                <option value="" selected disabled>Choose type</option>
                <option v-for="diagnose in diagnosis" :value="diagnose.id" :key="diagnose.id">{{diagnose.name}}</option>
              </select>
            </fieldset>
            <fieldset class="form-group">
              <label>Prescription</label>
              <input type="text" class="form-control" v-model="prescriptionText" >   
            </fieldset>
            <button class="btn btn-success" type="submit">Save</button>
          </form>
          <br/>
          <!--First id in route is doctors id and second is patient's id-->
          <button @click="()=>$router.push(`/addexamination/${this.$route.params.idd}/${this.$route.params.idp}`)">Schedule new examination or operation</button>
      </div>
    </div>

    <br/>
    <br/>

    <div class="container">
      <h3>Change patients medical record</h3>
      <form @submit="editPatientsInfo">
        <fieldset class="form-group">
          <label>Name</label>
          <input type="text" class="form-control" v-model="name" disabled>
        </fieldset>
        <fieldset class="form-group">
          <label>Surname</label>
          <input type="text" class="form-control" v-model="surname" disabled>
        </fieldset>
        <fieldset class="form-group">
          <label>Email</label>
          <input type="text" class="form-control" v-model="email" disabled>
        </fieldset>
         <fieldset class="form-group">
          <label>Weight</label>
          <input type="text" class="form-control" v-model="weight">
        </fieldset>
         <fieldset class="form-group">
          <label>Height</label>
          <input type="text" class="form-control" v-model="height">
        </fieldset>
         <fieldset class="form-group">
          <label>Blood type</label>
          <input type="text" class="form-control" v-model="bloodType">
        </fieldset>
        <button class="btn btn-success" type="submit">Edit</button>
      </form>
    </div>
  </div>
</template>

<script>
import Axios from 'axios';
export default {
  name: "makeReport",
  data() {
    return {
        name: "",
        surnaname: "",
        email: "",
        weight: undefined,
        height: undefined,
        bloodType: "",
        diagnosis: [],
        message: null,
        selectedDiagnosis: undefined,
        selectedDiagnosisName: "",
        enteredPrescription: undefined,
        patient: undefined
    };
  },
  methods: {
    refreshDiagnosis() {
        Axios.get('http://localhost:8082/api/diagnosis/all').then(response => (this.diagnosis = response.data))
    },
    refreshInformation() {
      this.surname = this.patient.surname;
    },
    editPatientsInfo(e){
      e.preventDefault();

      var temp={
            "id": this.$route.params.id,
            "weight":this.weight,
            "height": this.height,
            "bloodType":this.bloodType
      }
    Axios.put(`http://localhost:8082/api/patients/updateMedicalRedord`, temp);

    },

    validateAndSubmit(e){
      e.preventDefault();

        if(this.$refs.rolesSelected.checked == false){
            ///* eslint-disable no-console */
            //console.log("Cekirano je")
        
        var prsc = {
            "id": 156,
            "name": this.prescriptionText
        }

        //Axios.post(`http://localhost:8082/api/prescriptions`, prsc);
        //Axios.get(`http://localhost:8082/api/prescriptions/getPrescriptionByName/${this.prescriptionText}`).then(response => (this.enteredPrescription = response.data));
        var temp={
            "textReport": this.textReport,
            "diagnosis": this.selectedDiagnosis,
            "prescription": prsc,
            "patient": this.patient
        }
        Axios.post("http://localhost:8082/api/examinationReports", temp);
        this.refreshDiagnosis();
        } else {
        var temp2={
            "textReport": this.textReport,
            "patient": this.patient
        }
        Axios.post("http://localhost:8082/api/examinationReports", temp2);
        this.refreshDiagnosis();
        }

    },
    changedDiagnosis(event){
      this.selectedDiagnosisName = event.target.options[event.target.options.selectedIndex].text;
      Axios.get(`http://localhost:8082/api/diagnosis/${event.target.value}`).then(response => (this.selectedDiagnosis = response.data))

    }
    
  },
  created() {
    this.refreshDiagnosis();
    Axios.get(`http://localhost:8082/api/patients/${this.$route.params.idp}`).then(response => (
      this.patient = response.data,
      this.name = response.data.name,
      this.surname = response.data.surname,
      this.email = response.data.email,
      this.weight = response.data.weight,
      this.height = response.data.height,
      this.bloodType = response.data.bloodType
      ));

    this.refreshInformation();
  }

};
</script>

<style>
</style>
import axios from "axios";
Vue.use(Vuelidate);
<template>
    <div>
    <h3>LOGIN :</h3>
    <div class="container">
      <form @submit="validateAndSubmit">
        <fieldset class="form-group" name="nameField">
          <label>Email </label>
          <input type="text" class="form-control" v-model="email" required>
        </fieldset>
        <fieldset class="form-group">
          <label>Password </label>
          <input type="text" class="form-control" v-model="password" required>
        </fieldset>
        <fieldset class="form-group">
          <label>User role</label>
          <select v-model="role">
            <option disabled value="">Role</option>
            <option>patient</option>
            <option>doctor</option>
            <option>ClinicalCenterAdministrator</option>
            <option>Nurse</option>
          </select>
        </fieldset>
        <button class="btn btn-success" type="submit">Login</button>
      </form>
      <form @submit="val">
                <button class="btn btn-success" type="submit">Register</button>

      </form>
    </div>
  </div>



</template>

<script>
import PatientService from '../service/PatientService';
import DoctorService from '../service/DoctorService';
import Axios from 'axios';
//import Axios from 'axios';
export default {
  name: "Login",
  data() {
    return {
        
    };
  },
  methods: {
    refreshPatients() {
        PatientService.retrieveAllPatients() 
            .then(response => {
                this.patients = response.data;
        });
    },
    refreshDoctors() {
        DoctorService.retrieveAllDoctors() 
            .then(response => {
                this.doctors = response.data;
        });
    },
    refreshClinicCenterAdministrator(){
      Axios.get('http://localhost:8082/api/clinicalCenterAdministrators/all').then(response => (this.clinicCenterAdministrators = response.data))
    },
    refreshNurse(){
    Axios.get('http://localhost:8082/api/nurses/all').then(response => (this.nurses = response.data))
     
    },
    validateAndSubmit(e) {
    e.preventDefault();
    this.refreshPatients
    this.refreshDoctors
    this.re
   
    var temp={
      "email": this.email,
      "password": this.password,
      "role": this.role
    }
    var uloga
    var ispravno = false
    var i
    var indexNadjenog 
    if(temp.role == 'patient'){
    for(i=0; i<this.patients.length; i++){
      /* eslint-disable no-console */
        if(temp.email == this.patients[i].email){
           if(temp.password == this.patients[i].password && this.patients[i].validated == true){
               ispravno = true ;
               indexNadjenog = this.patients[i].id;
               uloga = temp.role;
           }
           
        }
       
      
    }}
    else if(temp.role == 'doctor'){
        for(i=0; i<this.doctors.length; i++){
      /* eslint-disable no-console */
          if(temp.email == this.doctors[i].email){
            if(temp.password == this.doctors[i].password){
               ispravno = true ;
               indexNadjenog = this.doctors[i].id;
               uloga = temp.role;
           }
           
        }
       
      
    }
    }
    else if (temp.role == 'ClinicalCenterAdministrator'){
        for(i = 0; i<this.clinicCenterAdministrators.length; i++){
          /* eslint-disable no-console */
          console.log(this.clinicCenterAdministrators[i].validated)

            // check just for validated accounts of admionistrators
            if(temp.email == this.clinicCenterAdministrators[i].email && temp.password == this.clinicCenterAdministrators[i].password && this.clinicCenterAdministrators[i].validated == true){
              this.ulogovaniAdministrator = this.clinicCenterAdministrators[i]
              console.log(this.ulogovaniAdministrator.name);
              ispravno = true;
              indexNadjenog = this.clinicCenterAdministrators[i].id;
              uloga = temp.role;
            }
        }
    }
    else if (temp.role == 'Nurse'){
      /* eslint-disable no-console */
     console.log(this.nurses.length)
        for(i = 0; i<this.nurses.length; i++){
          /* eslint-disable no-console */
            if(temp.email == this.nurses[i].email && temp.password == this.nurses[i].password){
              ispravno = true;
              indexNadjenog = this.nurses[i].id;
              uloga = temp.role;
            }
        }
    }
     

    if(ispravno == true){
        //Axios.get("http://localhost:8082/api/patients/all")
        console.log("Nasao")
        if (temp.role == 'ClinicalCenterAdministrator' || temp.role == "Nurse" || temp.role == 'doctor'){
          this.$router.push('/'+uloga+'HomePage/'+ indexNadjenog) 
        }else {
          this.$router.push('/'+uloga+'HomePage?id='+ indexNadjenog) 
        }
        
    }


    
  },
  val(e) {
    e.preventDefault();
        this.$router.push('/patients') 

  }
  },
  created() {
    this.refreshPatients();
    this.refreshDoctors();
    this.refreshClinicCenterAdministrator();
    this.refreshNurse();
  }
};
</script>

<style>
@import url(https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css);

</style>
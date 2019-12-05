import axios from "axios";
Vue.use(Vuelidate);
<template>
    <div>
    <h3>LOGIN :</h3>
    <div class="container">
      <form @submit="validateAndSubmit">
        <fieldset class="form-group" name="nameField">
          <label>Email</label>
          <input type="text" class="form-control" v-model="email" required>
        </fieldset>
        <fieldset class="form-group">
          <label>Password</label>
          <input type="text" class="form-control" v-model="password" required>
        </fieldset>
        <fieldset class="form-group">
          <label>User role</label>
          <select v-model="role">
            <option disabled value="">Role</option>
            <option>patient</option>
            <option>doctor</option>
            <option>clinicCenterAdministrator</option>
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
    validateAndSubmit(e) {
    e.preventDefault();

   
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
           if(temp.password == this.patients[i].password){
               ispravno = true ;
               indexNadjenog = i;
               uloga = temp.role;
           }
           
        }
       
      
    }}
    else if(temp.role=='doctor'){
        for(i=0; i<this.doctors.length; i++){
      /* eslint-disable no-console */
          if(temp.email == this.doctors[i].email){
            if(temp.password == this.doctors[i].password){
               ispravno = true ;
               indexNadjenog = i;
               uloga = temp.role;
           }
           
        }
       
      
    }
    }

    if(ispravno == true){
        //Axios.get("http://localhost:8082/api/patients/all")
        this.$router.push('/'+uloga+'HomePage/'+ indexNadjenog) 
        console.log("Nasao")
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
  }
};
</script>

<style>
</style>
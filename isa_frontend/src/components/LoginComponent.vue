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
          <input type="text" class="form-control" v-model="role">
        </fieldset>
        <button class="btn btn-success" type="submit">Login</button>
      </form>
    </div>
  </div>



</template>

<script>
import PatientService from '../service/PatientService';
import Axios from 'axios';
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
    validateAndSubmit(e) {
    e.preventDefault();

   
    var temp={
      "email": this.email,
      "password": this.password,
      "role": this.role,
    }
    var ispravno = false
    var i
    for(i=0; i<this.patients.length; i++){
      /* eslint-disable no-console */
        if(temp.email == this.patients[i].email){
           if(temp.password == this.patients[i].password){
               ispravno = true ;
               
           }
           
        }
       
      
    }

    if(ispravno == true){
        Axios.get("http://localhost:8082/api/patients/all")
        console.log("Nasao")
    }


    
  }
  },
  created() {
    this.refreshPatients();
  }
};
</script>

<style>
</style>
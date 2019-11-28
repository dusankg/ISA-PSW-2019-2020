<template>
  <div class="container">
    
    <div>
    
    <div class="container">
      <form @submit="validateAndSubmit">
        <fieldset class="form-group">
          <label>Name</label>
          <input type="text" class="form-control" v-model="name" >
        </fieldset>
        <fieldset class="form-group">
          <label>Surname</label>
          <input type="text" class="form-control" v-model="surname">
        </fieldset>
        <fieldset class="form-group">
          <label>Email</label>
          <input type="text" class="form-control" v-model="email">
        </fieldset>
         <fieldset class="form-group">
          <label>Password</label>
          <input type="text" class="form-control" v-model="password">
        </fieldset>
        <fieldset class="form-group">
          <label>Password2</label>
          <input type="text" class="form-control" v-model="password2">
        </fieldset>
         <fieldset class="form-group">
          <label>Adress</label>
          <input type="text" class="form-control" v-model="adress">
        </fieldset>
         <fieldset class="form-group">
          <label>City</label>
          <input type="text" class="form-control" v-model="city">
        </fieldset>
         <fieldset class="form-group">
          <label>State</label>
          <input type="text" class="form-control" v-model="state">
        </fieldset>
         <fieldset class="form-group">
          <label>Phone</label>
          <input type="text" class="form-control" v-model="phone">
        </fieldset>
        <button class="btn btn-success" type="submit">Save</button>
      </form>
    </div>


  </div>

  </div>
  
</template>




<script>
import Axios from 'axios';
export default {
  name: "EnterClinicalCenterAdministrator",
  data() {
    return {
        
        message: null,
        INSTRUCTOR: "all"
    };
  },
  methods: {
    validateAndSubmit(e) {
    e.preventDefault();
    var temp={
      "name":this.name,
      "surname":this.surname,
      "email":this.email,
      "adress":this.adress,
      "password": this.password,
      "city":this.city,
      "state":this.state,
      "phone":this.phone,
    }
    //var patientPom
    if(this.password==this.password2){
        Axios.post("http://localhost:8082/api/clinicalCenterAdministrators", temp);
    }

    this.name = ""
    this.surname = ""
    this.email = ""
    this.adress = ""
    this.password = ""
    this.password2 = ""
    this.city = ""
    this.state = ""
    this.phone = ""
    
  }


  },
  created() {
    
  }

};
</script>

<style>
</style>
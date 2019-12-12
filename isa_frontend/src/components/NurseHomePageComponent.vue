<template>
  <div class="container">
    
    <div>
    
    <div class="container">
        <fieldset class="form-group">
          <label>Name: </label>
          <label> {{ this.sestra.name }} </label>
        </fieldset>
        <fieldset class="form-group">
            <label>Surname: </label>
          <label>{{ this.sestra.surname }}</label>
        </fieldset>
        <fieldset class="form-group">
          <label>Email: </label>
          <label>{{ this.sestra.email }}</label>
        </fieldset>
         <fieldset class="form-group">
          <label>Password: </label>
          <label>{{ this.sestra.password }}</label>
        </fieldset>
         <fieldset class="form-group">
          <label>Adress: </label>
          <label>{{ this.sestra.adress }}</label>
        </fieldset>
         <fieldset class="form-group">
          <label>City: </label>
          <label>{{ this.sestra.city }}</label>
        </fieldset>
         <fieldset class="form-group">
          <label>State: </label>
          <label>{{ this.sestra.state }}</label>
        </fieldset>
         <fieldset class="form-group">
          <label>Phone: </label>
          <label>{{ this.sestra.phone }}</label>
        </fieldset>
     
    </div>


  </div>

    <h3>All non validated prescriptions</h3>
    <div class="container">
      <table class="table">
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="presc in nonValidated" v-bind:key="presc.id">
            <td>{{presc.id}}</td>
            <td>{{presc.name}}</td>
            <td>
              <button class="btn" v-on:click="acceptPatient(patient.id)">
                Accept
              </button>
            </td>

            <td>
              <form @submit="deletePatient(patient.id, poruka)">
                  <button class="btn btn-success" type = "submit">Reject</button>
                  <label>  Reason: </label>
                  <input type="text" class="form-control" v-model="poruka" required>
               </form>
            </td>
            
          </tr>
        </tbody>
      </table>
    </div>



  </div>
</template>


<script>
import Axios from 'axios';
export default {
  name: "NurseHomePage",
  data() {
    return {
    };
  },
  methods: {
  refreshNurse(){
    Axios.get('http://localhost:8082/api/nurses/' + this.$route.params.id).then(response => (this.sestra = response.data))
    }
  },
  refreshPrescriptions(){
    Axios.get('http://localhost:8082/api/prescriptions/nonAccepted').then(response => (this.nonValidated = response.data))
  },
  created() {
    this.refreshNurse();
    this.refreshPrescriptions();
  }

};
</script>

<style>
</style>
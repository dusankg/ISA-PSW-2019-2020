<template>
  <div class="container">
    <h3>All Diagnosis</h3>
    <div class="container">
      <table class="table">
        <thead>
          <tr>
            <th>Id</th>
            
          </tr>
        </thead>
        <tbody>
          <tr v-for="diagnosis1 in diagnosis" v-bind:key="diagnosis1.id">
            <td>{{diagnosis1.id}}</td>
            
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import DiagnosisService from '../service/DiagnosisService';
export default {
  name: "ListDiagnosis",
  data() {
    return {
        diagnosis: [],
        message: null,
        INSTRUCTOR: "all"
    };
  },
  methods: {
    refreshDiagnosis() {
        DiagnosisService.retrieveAllDiagnosis() 
            .then(response => {
                this.diagnosis = response.data;
        });
    }
  },
  created() {
    this.refreshDiagnosis();
  }

};
</script>

<style>
</style>
<template>
  <div class="container">
    <h3>Respond to examination request</h3>
    <div class="container">
      <table class="table">
        <thead>
          <tr>
            <th>Id</th>
            <th>Date</th>
            <th>Start Time</th>
            <th>End Time</th>
            <th>Operation</th>
            <th>Type</th>
            <th>Doctor</th>
            <th>Patient</th>
          </tr>
        </thead>
        <tbody>
          <tr >
            <td>{{examination.id}}</td>
            <td>{{examination.date}}</td>
            <td>{{examination.startTime}}</td>
            <td>{{examination.endTime}}</td>
            <td>{{examination.operation}}</td>
            <td>{{examination.type.typeName}}</td>
            <td>{{examination.doctor.name + ' ' + examination.doctor.surname}}</td>
            <td>{{examination.patient.name + ' ' + examination.patient.surname}}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import ExaminationService from '../service/ExaminationService';
export default {
    data(){
        return {
            examination: undefined,
        };
    },
    methods: {
        refreshExamination() {
            ExaminationService.retrieveExamination(this.$route.params.id) 
                .then(response => {
                    this.examination = response.data;
            });
        },    
    },
    mounted(){
        this.refreshExamination();
    }
}
</script>

<style>

</style>
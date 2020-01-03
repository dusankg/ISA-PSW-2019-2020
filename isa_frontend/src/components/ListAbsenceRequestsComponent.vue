<template>
  <div class="container">
      <h3>Absence requests</h3>
      <table class="table">
          <thead>
              <tr>
                  <th>Id</th>
                  <th>Employee name</th>
                  <th>Starting date</th>
                  <th>Ending date</th>
              </tr>
          </thead>
          <tbody>
              <tr v-for="absencerequest in absencerequests" v-bind:key="absencerequest.id">
                  <td>{{absencerequest.id}}</td>
                  <td>{{}}</td>
                  <td>{{absencerequest.startingDate}}</td>
                  <td>{{absencerequest.endingDate}}</td>
                  <td></td>
              </tr>
          </tbody>
      </table>
  </div>
</template>

<script>
import AbsenceRequestService from '../service/AbsenceRequestService'
export default {
    name:"ListAbsenceRequests",
    data(){
        return{
            absencerequests: [],
        }
    },
    methods:{
        refreshAbsenceRequests(){
            AbsenceRequestService.retrieveAllAbsenceRequests().then(response =>{
                this.absencerequests = response.data;
            });
        }
    },
    created(){
        this.refreshAbsenceRequests();
    }
}
</script>

<style>

</style>
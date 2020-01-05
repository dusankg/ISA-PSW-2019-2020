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
                  <td>{{absencerequests.doctorId}}</td>
                  <td>{{absencerequest.startingDate}}</td>
                  <td>{{absencerequest.endingDate}}</td>
                  <td>
                      <button class="btn btn-success" v-on:click="acceptRequest(absencerequest.id)">
                          Accept
                      </button>
                  </td>
                  <td>
                      <form @submit="declineRequest(patient.id, message)">
                            <button class="btn btn-warning" type="submit">
                                Decline
                            </button>
                            <label> Reason for declining request: </label>
                            <input type="text" class="form-control" v-model="message" required>  
                      </form>
                  </td>
              </tr>
          </tbody>
      </table>
  </div>
</template>

<script>
import AbsenceRequestService from '../service/AbsenceRequestService'
import Axios from 'axios';
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
        },
        acceptRequest(idx){
            Axios.get('http://localhost:8082/api/doctors/accept/' + idx)
        },
        declineRequest(idx, message){
            Axios.get('http://localhost:8082/api/doctors/decline/' + idx + "/" + message)
        }
    },
    created(){
        this.refreshAbsenceRequests();
    }
}
</script>

<style>

</style>
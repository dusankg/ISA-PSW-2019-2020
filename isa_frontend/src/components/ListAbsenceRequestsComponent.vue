<template>
  <div class="container">
      <h3>Absence requests</h3>
      <h5>Absence request of doctors</h5>
      <table class="table">
          <thead>
              <tr>
                  <th>Id</th>
                  <th>Doctor name</th>
                  <th>Starting date</th>
                  <th>Ending date</th>
              </tr>
          </thead>
          <tbody>
              <tr v-for="absencerequest in requestsdoctor" v-bind:key="absencerequest.id">
                  <td>{{absencerequest.id}}</td>
                  <td>{{absencerequest.doctor.name + " " + absencerequest.doctor.surname}}</td>
                  <td>{{absencerequest.startingDate}}</td>
                  <td>{{absencerequest.endingDate}}</td>
                  <td>
                      <button class="btn btn-success" v-on:click="acceptRequest(absencerequest.id)">
                          Accept
                      </button>
                  </td>
                  <td>
                      <form @submit="declineRequest(absencerequest.id, message)">
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
      <h5>Absence requests of nurses</h5>
      <table class="table">
          <thead>
              <tr>
                  <th>Id</th>
                  <th>Nurse name</th>
                  <th>Starting date</th>
                  <th>Ending date</th>
              </tr>
          </thead>
          <tbody>
              <tr v-for="absencerequest in requestsnurse" v-bind:key="absencerequest.id">
                  <td>{{absencerequest.id}}</td>
                  <td>{{absencerequest.nurse.name + " " + absencerequest.nurse.surname}}</td>
                  <td>{{absencerequest.startingDate}}</td>
                  <td>{{absencerequest.endingDate}}</td>
                  <td>
                      <button class="btn btn-success" v-on:click="acceptRequestNurse(absencerequest.id)">
                          Accept
                      </button>
                  </td>
                  <td>
                      <form @submit="declineRequestNurse(absencerequest.id, message)">
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
            doctor: undefined,
            nurse: undefined
        }
    },
    methods:{
        refreshAbsenceRequests(){
            AbsenceRequestService.retrieveAllAbsenceRequests().then(response =>{
                this.absencerequests = response.data;
            });
        },
        acceptRequest(idx){
            AbsenceRequestService.retrieveDoctorThatSentRequest(idx).then(res =>{
                this.doctor = res.data;
                Axios.get('http://localhost:8082/api/doctors/accept/' + idx);
                AbsenceRequestService.deleteAbsenceRequest(idx);
                this.refreshAbsenceRequests();
            });
        },
        declineRequest(idx, message){
            AbsenceRequestService.retrieveDoctorThatSentRequest(idx).then(res =>{
                this.doctor = res.data;
                var p = message;
                Axios.get('http://localhost:8082/api/doctors/decline/' + this.doctor.id + "/" + p);
                AbsenceRequestService.deleteAbsenceRequest(idx);
                this.refreshAbsenceRequests();
            });
        },
        acceptRequestNurse(idx){
            AbsenceRequestService.retrieveNurseThatSentRequest(idx).then(res =>{
                this.nurse = res.data;
                Axios.get('http://localhost:8082/api/nurses/accept/' + this.nurse.id);
                AbsenceRequestService.deleteAbsenceRequest(idx);
                this.refreshAbsenceRequests();
            });
        },
        declineRequestNurse(idx, message){
            AbsenceRequestService.retrieveNurseThatSentRequest(idx).then(res =>{
                this.nurse = res.data;
                var p = message;
                Axios.get('http://localhost:8082/api/nurses/decline/' + this.nurse.id + "/" + p);
                AbsenceRequestService.deleteAbsenceRequest(idx);
                this.refreshAbsenceRequests();
            });
        }
    },
    computed: {
        requestsdoctor: function(){
            return this.absencerequests.filter((ar)=>{
                if(ar.doctor != null){
                    return true;
                }else{
                    return false;
                }
            });
        },
        requestsnurse: function(){
            return this.absencerequests.filter((ar)=>{
                if(ar.nurse != null){
                    return true;
                }else{
                    return false;
                }
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
<template>
  <div class="container">
      <h3>Create new request for absence days</h3>
      <div>
          <form @submit="validateAndSubmit">
              <fieldset class="form-group">
                  <label>Doctor Id</label>
                  <input type="text" class="form-control" v-model="id" disabled>
              </fieldset>
              <fieldset class="form-group">
                  <label>Starting Date</label>
                  <input type="date" class="form-control" v-model="startingDate">
              </fieldset>
              <fieldset>
                  <label>Ending Date</label>
                  <input type="date" class="form-control" v-model="endingDate">
              </fieldset>
              <button class="btn btn-success" type="submit" >Send</button>             
          </form>
      </div>
  </div>
</template>

<script>
import Axios from 'axios';
import DoctorService from '../service/DoctorService';
export default {
    name: "CreateAbsenceRequest",
    data(){
        return {
            startingDate: undefined,
            endingDate: undefined,
            doctor: undefined
        }
    },
    methods: {
        validateAndSubmit(e){
            e.preventDefault();
            var temp = {
                "startingDate":this.startingDate,
                "endingDate":this.endingDate,
                "doctor":this.doctor
            }

            Axios.post("http://localhost:8082/api/absencerequests", temp);
            this.$router.push(`/doctorHomePage/${this.id}`);
        },
        retrieveDoctor(){
            DoctorService.retrieveDoctor(this.id).then(response => {
                this.doctor = response.data;
            });
        }
    },
    computed: {
        id(){
            return this.$route.params.id;
        }
    },
    mounted(){
        this.retrieveDoctor();
    }
}
</script>

<style>

</style>
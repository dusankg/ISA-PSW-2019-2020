<template>
  <div class="container">
      <h3>Create new request for absence days</h3>
      <div>
          <form @submit="validateAndSubmit">
              <fieldset class="form-group">
                  <label>Id</label>
                  <input type="text" class="form-control" v-model="id" disabled>
              </fieldset>
              <fieldset class="form-group">
                  <label>Staring Date</label>
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
export default {
    name: "CreateAbsenceRequest",
    data(){
        return {
            startingDate: undefined,
            endingDate: undefined
        }
    },
    methods: {
        validateAndSubmit(e){
            e.preventDefault();
            var temp = {
                "id":this.id,
                "startingDate":this.startingDate,
                "endingDate":this.endingDate
            }

            Axios.post("http://localhost:8082/api/absencerequests", temp);
            //This is only temporary solution, I need to get id of doctor that sent request
            this.$router.push('/doctorhomepage/{id}')
        }
    }
}
</script>

<style>

</style>
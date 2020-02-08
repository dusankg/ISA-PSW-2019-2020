import axios from "axios"

<template>
  <div class="container">
    <div>
    <h3>Rate doctor</h3>
    <div class="container">
      <form @submit.prevent="filter()">
        <fieldset class="form-group">
              <label>Duration</label>
              <select class="form-control" v-model="rating" required>
                <option value="" selected disabled>Choose Rating</option>
                <option value="0">0</option><option value="1">1</option> <option value="2">2</option>
                <option value="3">3</option><option value="4">4</option> <option value="5">5</option>
              </select>
            </fieldset>
        <fieldset class="form-group">
          <label>Comment</label>
          <input type="text" class="form-control" v-model="comment">
        </fieldset>
        
        <button class="btn btn-success" type="submit">Rate the doctor</button>
      </form>
    </div>


  </div>

  </div>





  
</template>

<script>

import Axios from 'axios';
export default {
  name: "ListPatients",
  data() {
    return {
        rating: null,
        comment: null
    };
  },
  methods: {
    filter(){
        Axios.get('http://localhost:8082/api/doctors/rate/'+this.$route.query.idDoctor+'/'+this.rating, {withCredentials: true}).then(response =>{
             if(response.data!=null){
        alert("Doctor successfully rated")
        this.$router.push('/patientHomePage',  {withCredentials: true}) ; 
             }
           })
       

        
        
    }
    


  },
  created() {
    
  }

};
</script>

<style>
</style>
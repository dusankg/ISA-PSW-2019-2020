<template>
  <div>
      <h3> Add new examination type </h3>
      <div class="container">
          <form @submit="validateAndSubmit">
              <fieldset class="form-group">
                  <label> Name </label>
                  <input type="text" class="form-control" v-model="typeName">
              </fieldset>
              <button class="btn btn-success" type="submit" >Save</button>
          </form>
      </div>
  </div>
</template>

<script>
import Axios from 'axios';
export default {
    name: "AddExaminationType",
    data(){
        return {
            typeName: undefined
        }
    }, 
    methods: {
        validateAndSubmit(e){
            e.preventDefault();
            var temp={
                "typeName":this.typeName
            }
            Axios.post("http://localhost:8082/api/examinationtypes", temp);
            this.$router.push('/examinationtypes')
        }
    }
}
</script>

<style>

</style>
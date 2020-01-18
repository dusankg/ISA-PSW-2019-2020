<template>
  <div>
      <h3> Add new examination type </h3>
      <div class="container">
          <form @submit="validateAndSubmit">
              <fieldset class="form-group">
                  <label>Id</label>
                  <input type="text" class="form-control" v-model="id" disabled>
              </fieldset>
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
import ExaminationTypeService from '../service/ExaminationTypeService'
import Axios from 'axios';
export default {
    name: "AddExaminationType",
    data(){
        return {
            typeName: undefined
        }
    }, 
    computed: {
        id() {
            return this.$route.params.id;
        }
    },
    methods: {
        validateAndSubmit(e){
            e.preventDefault();
            var temp={
                "id":this.id,
                "typeName":this.typeName
            }
            var t = {
                "typeName":this.typeName,
            }

            if (this.id == -1){
                //Ading new type
                Axios.post("http://localhost:8082/api/examinationtypes", t);
                this.$router.push('/examinationtypes');
                
            } else {
                //Modifying exising type
                Axios.put("http://localhost:8082/api/examinationtypes", temp);
                this.$router.push('/examinationtypes');
            }
        },
        refreshExaminationType(){
            ExaminationTypeService.retrieveExaminationType(this.id).then(response =>{
                this.typeName = response.data.typeName;
            });
        } 
        
    },
    mounted(){
        this.refreshExaminationType();
    }
}
</script>

<style>

</style>
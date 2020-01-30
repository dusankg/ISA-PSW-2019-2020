<template>
  <div>
      <h3>My personal profile</h3>
      <div class="container">
        <form @submit="validateAndSubmit">
           <fieldset class="form-group">
             <label>Id</label>
             <input type="text" class="form-control" v-model="id" disabled>
          </fieldset>
          <fieldset class="form-group">
            <label>Name</label>
            <input type="text" class="form-control" v-model="name">
          </fieldset>
          <fieldset class="form-group">
            <label>Surname</label>
            <input type="text" class="form-control" v-model="surname">   
          </fieldset>
          <fieldset class="form-group">
            <label>E-mail</label>
            <input type="email" class="form-control" v-model="email">   
          </fieldset>
          <fieldset class="form-group">
            <label>Password</label>
            <input type="text" class="form-control" v-model="password">   
          </fieldset>
          <fieldset class="form-group">
            <label>Address</label>
            <input type="text" class="form-control" v-model="adress">   
          </fieldset>
          <fieldset class="form-group">
            <label>City</label>
            <input type="text" class="form-control" v-model="city">   
          </fieldset>
          <fieldset class="form-group">
            <label>State</label>
            <input type="text" class="form-control" v-model="state">   
          </fieldset>
          <fieldset class="form-group">
            <label>Phone</label>
            <input type="text" class="form-control" v-model="phone">   
          </fieldset>
          <button class="btn btn-success" type="submit">Save</button>
        </form>
        <button @click="returnHP()">Return without saving</button>
      </div>
    </div>

</template>

<script>
import DoctorService from '../service/DoctorService';
export default {
    name: "EditDoctors",
    data() {
         return {
            name: undefined,
            surname: undefined,
            password: undefined,
            email: undefined,
            adress: undefined,
            city: undefined, 
            state: undefined,
            phone: undefined
        };
    },
    computed: {
        id() {
            return this.$route.params.id;
        }
    },
    methods: {
        validateAndSubmit(e){
            e.preventDefault();
            var temp = {
              "id": this.id,
              "name": this.name,
              "surname": this.surname,
              "password": this.password,
              "email": this.email,
              "adress": this.adress,
              "city": this.city,
              "state": this.state,
              "phone":this.phone
            }
            DoctorService.editDoctor(temp);
            this.$router.push(`/doctorHomePage/${this.id}`);
        },
        getDoctor(){
            DoctorService.retrieveDoctor(this.id).then(response => {
                this.name = response.data.name;
                this.surname = response.data.surname;
                this.password = response.data.password;
                this.email = response.data.email;
                this.adress = response.data.adress;
                this.city = response.data.city;
                this.state = response.data.state;
                this.phone = response.data.phone;
            });
        },
        returnHP(){
          this.$router.push(`/doctorHomePage/${this.id}`);
        }
    },
    mounted(){
        this.getDoctor();
    }
}
</script>

<style>

</style>
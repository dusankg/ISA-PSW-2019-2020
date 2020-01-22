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
            <input type="text" class="form-control" v-model="name" disabled>
          </fieldset>
          <fieldset class="form-group">
            <label>Surname</label>
            <input type="text" class="form-control" v-model="surname" disabled>   
          </fieldset>
          <fieldset class="form-group">
            <label>E-mail</label>
            <input type="email" class="form-control" v-model="email" disabled>   
          </fieldset>
          <fieldset class="form-group">
            <label>Password</label>
            <input type="text" class="form-control" v-model="password" disabled>   
          </fieldset>
          <fieldset class="form-group">
            <label>Address</label>
            <input type="text" class="form-control" v-model="adress" disabled>   
          </fieldset>
          <fieldset class="form-group">
            <label>City</label>
            <input type="text" class="form-control" v-model="city" disabled>   
          </fieldset>
          <fieldset class="form-group">
            <label>State</label>
            <input type="text" class="form-control" v-model="state" disabled>   
          </fieldset>
          <fieldset class="form-group">
            <label>Phone</label>
            <input type="text" class="form-control" v-model="phone" disabled>   
          </fieldset>
          <button class="btn btn-success" type="submit">Return</button>
        </form>
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
        }
    },
    mounted(){
        this.getDoctor();
    }
}
</script>

<style>

</style>
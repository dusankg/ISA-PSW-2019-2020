<template>
    <div>
        <h1>Clinical center app</h1>
        <div v-if="($route.name) ==='Home' ">
        <!--For now we make like this until we split this on separate pages-->
            <!--<router-link to="/all">Lists of all data and forms for managing them</router-link>
            1<PatientApp />
            <LoginApp/>-->
            
        </div>
        <div>
            <router-view />
        </div>
    </div>

</template>

<script>
//import LoginApp from './LoginApp.vue'
//import PatientApp from './PatientApp.vue'
export default {
    name: 'start',
    components:{
      //  LoginApp,
    //    PatientApp
    }
    
}
</script>

<style>
@import url(https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css);

</style>
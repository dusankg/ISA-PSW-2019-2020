<template>
    <div>
        <h1 v-if="($route.name) ==='Home' ">Welcome to 3DE clinical center</h1>
        <div v-if="($route.name) ==='Home' ">
        <!--For now we make like this until we split this on separate pages-->
            <router-link to="/all">Lists of all data and forms for managing them</router-link>
            <!--<PatientApp />
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

</style>
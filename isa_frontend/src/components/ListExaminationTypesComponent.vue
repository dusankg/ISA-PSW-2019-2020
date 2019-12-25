<template>
  <div class="container">
    <h3>Examination types</h3>
    <table class="table">
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="examinationtype in examinationtypes" v-bind:key="examinationtype.id">
                <td>{{examinationtype.id}}</td>
                <td>{{examinationtype.typeName}}</td>
            </tr>
        </tbody>
    </table>
    <p><button @click="()=>$router.push('/addexaminationtype')"> Add new examination type </button></p>
  </div>
</template>

<script>
import ExaminationTypeService from '../service/ExaminationTypeService'
//import Axios from 'axios';
export default {
    name: "ListExaminationTypes",
    data(){
        return{
            examinationtypes: [],
        }
    },
    methods: {
        refreshExaminationTypes(){
            ExaminationTypeService.retrieveAllExaminationTypes().then(response =>{
                this.examinationtypes = response.data;
            });
        }
    },
    created(){
        this.refreshExaminationTypes();
    }
}
</script>

<style>

</style>
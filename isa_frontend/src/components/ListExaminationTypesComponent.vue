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
                <td>
                    <button class="brn btn-success" v-on:click="editExaminationTypeClicked(examinationtype.id)">
                        Edit
                    </button>
                </td>
                <td>
                    <button class="brn btn-warning" v-on:click="deleteExaminationTypeClicked(examinationtype.id)">
                        Delete
                    </button>
                </td>
            </tr>
        </tbody>
    </table>
    <p><button @click="()=>$router.push('/addexaminationtype/-1')"> Add new examination type </button></p>
  </div>
</template>

<script>
import ExaminationTypeService from '../service/ExaminationTypeService'
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
        }, 
        editExaminationTypeClicked(id){
            this.$router.push(`/addexaminationtype/${id}`);
        },
        deleteExaminationTypeClicked(id){
            //I will use this when I finish validation
            //var temp = ExaminationTypeService.retrieveExaminationType(id);
            ExaminationTypeService.deleteExaminationType(id).then(response => {
                this.refreshExaminationTypes();
                response.message
            });
        }
    },
    created(){
        this.refreshExaminationTypes();
    },
    mounted(){
        this.refreshExaminationTypes();
    }
}
</script>

<style>

</style>
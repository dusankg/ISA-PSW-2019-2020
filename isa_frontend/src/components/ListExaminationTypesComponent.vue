<template>
  <div class="container">
    <h3>Examination types</h3>
    <input type="text" class="form-control" v-model="searchName" placeholder="Search examination type by name"/>
    <table class="table">
        <thead>
            <tr>
                <th @click="sortById()">Id</th>
                <th @click="sortByName()">Name</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="examinationtype in filteredExaminationTypes" v-bind:key="examinationtype.id">
                <td>{{examinationtype.id}}</td>
                <td>{{examinationtype.typeName}}</td>
                <td>
                    <button class="btn btn-success" v-on:click="editExaminationTypeClicked(examinationtype.id)">
                        Edit
                    </button>
                </td>
                <td>
                    <button class="btn btn-warning" v-on:click="deleteExaminationTypeClicked(examinationtype.id)">
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
            searchName: "",
            currentSortDir: "desc"
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
        },
        // methods for sorting
        sortById(){
            if(this.currentSortDir === "desc"){
                this.examinationtypes.sort((a, b) => a.id > b.id ? 1 : -1);
                this.currentSortDir = "asc";
            }else{
                this.examinationtypes.sort((a, b) => a.id < b.id ? 1 : -1);
                this.currentSortDir = "desc";
            }
        },
        sortByName(){
            if(this.currentSortDir === "desc"){
                this.examinationtypes.sort((a, b) => a.typeName.toLowerCase() > b.typeName.toLowerCase() ? 1 : -1);
                this.currentSortDir = "asc";
            }else{
                this.examinationtypes.sort((a, b) => a.typeName.toLowerCase() < b.typeName.toLowerCase() ? 1 : -1);
                this.currentSortDir = "desc";
            }
        }
    },
    computed: {
        filteredExaminationTypes: function(){
            return this.examinationtypes.filter((examinationtype)=>{
                if(examinationtype.typeName.toLowerCase().match(this.searchName.toLowerCase())){
                    return true;
                }else{
                    return false;
                }
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
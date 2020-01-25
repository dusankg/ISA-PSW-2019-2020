import axios from "axios";

<template>
    <div class="container">
        <h3>All rooms</h3>
        <div class="container">
        <input type="text" class="form-control" v-model="searchName" placeholder="Search room by name"/>
        <input type="text" class="form-control" v-model="searchNumber" placeholder="Search room by number"/>
        <input type="text" class="form-control" v-model="searchDate" placeholder="Search room by date"/>
            <table class="table">
                <thead>
                    <tr>
                        <th @click="sortById()">Id</th>
                        <th>Operational</th>
                        <th>Reserved</th>
                        <th @click="sortByName()">CodeName</th>
                        <th @click="sortByNumber()">Room number</th>
                        <th @click="sortByDate()">Date</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="medicalroom in filteredMedicalRooms" v-bind:key="medicalroom.id">
                        <td>{{medicalroom.id}}</td>
                        <td>{{medicalroom.operational}}</td>
                        <td>{{medicalroom.reserved}}</td>
                        <td>{{medicalroom.roomCodeName}}</td>
                        <td>{{medicalroom.roomNumber}}</td>
                        <td>{{medicalroom.date}}</td>
                        <td>
                            <button class="btn btn-warning" v-on:click=deleteRoomClicked(medicalroom.id)>
                                Delete
                            </button>
                        </td>
                    </tr>
                </tbody>
            </table>
            <div v-if="message" class="alert alert-success">
                {{message}} 
            </div>
        </div>

        <div>
            <h3>Add new room</h3>
            <div class="container">
                <form @submit="validateAndSubmit">
                    <fieldset class="form-group">
                        <label>Operational</label>
                        <input type="checkbox" class="checkbox" v-model="operational">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Reserved</label>
                        <input type="checkbox" class="checkbox" v-model="reserved">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>CodeName</label>
                        <input type="text" class="form-control" v-model="roomCodeName" required>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Number</label>
                        <input type="number" class="form-control" v-model="roomNumber" required>
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Date</label>
                        <input type="date" class="form-control" v-model="date">
                    </fieldset>
                    <button class="btn btn-success" type="submit">Save</button>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
import MedicalRoomService from '../service/MedicalRoomService';
import Axios from 'axios';
export default {
    name: "ListMedicalRooms",
    data(){
        return {
            medicalrooms: [],
            message: null,
            operational: false,
            reserved: false,
            roomCodeName: "",
            roomNumber: undefined,
            date: undefined,
            searchName: "",
            searchNumber: "", 
            searchDate: "",
            currentSortDir: "desc"
        };
    },
    methods: {
        refreshMedicalRooms(){
            MedicalRoomService.retrieveAllMedicalRooms()
                .then(response => {
                    this.medicalrooms = response.data;
                });
        },
        validateAndSubmit(e){
            e.preventDefault();
            var temp={
                "operational":this.operational,
                "reserved":this.reserved,
                "roomCodeName":this.roomCodeName,
                "roomNumber":this.roomNumber,
                "date":this.date
            }

            Axios.post("http://localhost:8082/api/medicalrooms", temp);
            this.refreshMedicalRooms();
        },
        deleteRoomClicked(id){
            var res;
            MedicalRoomService.retrieveRoom(id).then(response => {
                res = response.data.reserved;
                if(res){
                    this.message = `Cannot delete room because it is already reserved`;
                } else {
                    this.message = `Deleted room successfully`;
                }
            });

            MedicalRoomService.deleteRoom(id).then(response => {
                this.refreshMedicalRooms();
                response.message
            });
        },
        // methods for sorting
        sortById(){
            if(this.currentSortDir === "desc"){
                this.medicalrooms.sort((a, b) => a.id > b.id ? 1 : -1);
                this.currentSortDir = "asc";
            }else{
                this.medicalrooms.sort((a, b) => a.id < b.id ? 1 : -1);
                this.currentSortDir = "desc";
            }
        },
        sortByName(){
            if(this.currentSortDir === "desc"){
                this.medicalrooms.sort((a, b) => a.roomCodeName.toLowerCase() > b.roomCodeName.toLowerCase() ? 1 : -1);
                this.currentSortDir = "asc";
            }else{
                this.medicalrooms.sort((a, b) => a.roomCodeName.toLowerCase() < b.roomCodeName.toLowerCase() ? 1 : -1);
                this.currentSortDir = "desc";
            }
        },
        sortByNumber(){
            if(this.currentSortDir === "desc"){
                this.medicalrooms.sort((a, b) => a.roomNumber > b.roomNumber ? 1 : -1);
                this.currentSortDir = "asc";
            }else{
                this.medicalrooms.sort((a, b) => a.roomNumber < b.roomNumber ? 1 : -1);
                this.currentSortDir = "desc";
            }
        },
        sortByDate(){
            if(this.currentSortDir === "desc"){
                this.medicalrooms.sort((a, b) => a.date > b.date ? 1 : -1);
                this.currentSortDir = "asc";
            }else{
                this.medicalrooms.sort((a, b) => a.date < b.date ? 1 : -1);
                this.currentSortDir = "desc";
            }
        }
    },
    computed: {
        filteredMedicalRooms: function() {
            return this.medicalrooms.filter((medicalroom)=>{
                if(medicalroom.roomCodeName.toLowerCase().match(this.searchName.toLowerCase()) &&
                    medicalroom.roomNumber.toString().match(this.searchNumber) &&
                    medicalroom.date.toString().match(this.searchDate)){
                    return true;
                }else{
                    return false;
                }
            });
        }
    },
    created() {
        this.refreshMedicalRooms();
    }, 
    mounted() {
        this.refreshMedicalRooms();
    }
};
</script>

<style>

</style>
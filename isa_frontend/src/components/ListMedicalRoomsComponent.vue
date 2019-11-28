import axios from "axios";

<template>
    <div class="container">
        <h3>All rooms</h3>
        <div class="container">
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Operational</th>
                        <th>Reserved</th>
                        <th>CodeName</th>
                        <th>Date</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="medicalroom in medicalrooms" v-bind:key="medicalroom.id">
                        <td>{{medicalroom.id}}</td>
                        <td>{{medicalroom.operational}}</td>
                        <td>{{medicalroom.reserved}}</td>
                        <td>{{medicalroom.roomCodeName}}</td>
                        <td>{{medicalroom.date}}</td>
                    </tr>
                </tbody>
            </table>
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
                        <input type="text" class="form-control" v-model="roomCodeName">
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
import MedicalRoomService from '../service/MedicalRoomService'
import Axios from 'axios';
export default {
    name: "ListMedicalRooms",
    data(){
        return {
            medicalrooms: [],
            message: null,
            INSTRUCTOR: "all"
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
                "date":this.date
            }

            Axios.post("http://localhost:8082/api/medicalrooms", temp);
            this.refreshMedicalRooms();
        }
    },
    created() {
        this.refreshMedicalRooms();
    }
};
</script>

<style>

</style>
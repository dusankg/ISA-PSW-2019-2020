<template>
  <div>
        <h3>Edit room</h3>
        <div class="container">
            <form @submit="validateAndSubmit">
                <fieldset class="form-group">
                    <input type="checkbox" class="form-check-input" v-model="operational">
                    <label class="form-check-label">Operational</label>
                </fieldset>
                <fieldset class="form-group">
                    <input type="checkbox" class="form-check-input" v-model="reserved">
                    <label>Reserved</label>
                </fieldset>
               <fieldset class="form-group">
                    <label>Name</label>
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
</template>

<script>
import MedicalRoomService from '../service/MedicalRoomService';
export default {
    name: "EditMedicalRoomComponent",
    data(){
        return {
            operational: undefined,
            reserved: undefined,
            roomCodeName: undefined,
            roomNumber: undefined,
            date: undefined,
        };     
    },
    methods: {
        validateAndSubmit(e){
            e.preventDefault();
            var temp = {
                "id": this.$route.params.id,
                "operational": this.operational,
                "reserved": this.reserved,
                "roomCodeName": this.roomCodeName,
                "roomNumber": this.roomNumber,
                "date": this.date
            };
            MedicalRoomService.editRoom(temp);
        },
        refreshRoom(){
            MedicalRoomService.retrieveRoom(this.$route.params.id).then(response =>{
                this.operational = response.data.operational;
                this.reserved = response.data.reserved;
                this.roomCodeName = response.data.roomCodeName;
                this.roomNumber = response.data.roomNumber;
                this.date = response.data.date;
            });
        }
    },
    created() {
        this.refreshRoom();
    }

}
</script>

<style>

</style>
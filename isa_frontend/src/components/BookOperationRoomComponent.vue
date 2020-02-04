

<template>
  <div class="container">
    
    <div>
      <h3>Book operation room for examination</h3>
        <div class="container">
          <form @submit="validateAndSubmit">
            <fieldset class="form-group">
              <label>Date</label>
              <input type="date" class="form-control" v-model="date" required>
            </fieldset>

            <fieldset class="form-group">
              <label>Starting time</label>
              <select class="form-control" required @change="changedStartingHour($event)">
                <option value="7" selected disabled>Choose starting hour</option>
                <option value="7">7h</option><option value="8">8h</option> <option value="9">9h</option>
                <option value="10">10h</option><option value="11">11h</option> <option value="12">12h</option>
                <option value="13">13h</option><option value="14">14h</option> <option value="15">15h</option>
                <option value="16">16h</option><option value="17">18h</option> <option value="18">18h</option>
              </select>
            </fieldset>

            <fieldset class="form-group">
              <select class="form-control" required @change="changedStartingMinute($event)">
                <option value="0" selected disabled>Choose starting minut</option>
                <option value="0">0min</option><option value="5">5min</option> <option value="10">10min</option>
                <option value="15">15min</option><option value="20">20min</option> <option value="25">25min</option>
                <option value="30">30min</option><option value="35">35min</option> <option value="40">40min</option>
                <option value="45">45min</option><option value="50">50min</option> <option value="55">55min</option>
              </select>
            </fieldset>


            <fieldset class="form-group">
              <label>Duration</label>
              <select class="form-control" required @change="changedDurationHour($event)">
                <option value="0" selected disabled>Choose duration hour</option>
                <option value="0">0h</option><option value="1">1h</option> <option value="2">2h</option>
                <option value="3">3h</option><option value="4">4h</option> <option value="5">5h</option>
              </select>
            </fieldset>

            <fieldset class="form-group">
              <select class="form-control" required @change="changedDurationMinute($event)">
                <option value="0" selected disabled>Choose duration minut</option>
                <option value="0">0min</option><option value="5">5min</option> <option value="10">10min</option>
                <option value="15">15min</option><option value="20">20min</option> <option value="25">25min</option>
                <option value="30">30min</option><option value="35">35min</option> <option value="40">40min</option>
                <option value="45">45min</option><option value="50">50min</option> <option value="55">55min</option>
              </select>
            </fieldset>

            <fieldset class="form-group" >
              <label>Available rooms for the examination date and time</label>
              <select class="form-control" required @change="changedRoom($event)">
                <option value="" selected disabled>Choose room</option>
                <option v-for="room in freeOperationRooms" :value="room.id" :key="room.id">{{room.roomCodeName}}</option>
              </select>
            </fieldset>
            
            <button class="btn btn-success" type="submit">Book</button>
          </form>
      </div>
    </div>
  </div>
</template>

<script> 
import Axios from 'axios';
export default {
  name: "BookOperationRoom",
  data() {
    return {
        freeOperationRooms: [],
        message: null,
        date: undefined,
        startingHour: undefined,
        startingMinute: undefined,
        startingSum: undefined,
        durationHour: undefined,
        durationMinute: undefined, // svaki je vezan za jedno polje i onda cu na kraju da ih saberem u vreme koje gledam u backendu,
        durationSum: undefined,
        examination: undefined,
        selectedRoom: undefined,
        selectedRoomName: "",
        examinationDate: "",
        exeminationStart: undefined,
        examinationEnd: undefined
    };
  },
  methods: {
    changedStartingHour(event){
        this.startingHour = event.target.options[event.target.options.selectedIndex].value;
    },
    changedStartingMinute(event){
        this.startingMinute = event.target.options[event.target.options.selectedIndex].value;
    },
    changedDurationHour(event){
        this.durationHour = event.target.options[event.target.options.selectedIndex].value;
    },
    changedDurationMinute(event){
        this.durationMinute = event.target.options[event.target.options.selectedIndex].value;
    },
    validateAndSubmit(e){
        e.preventDefault();
        this.durationSum = this.startingHour*60 + this.startingMinute*1 + this.durationHour*60 + this.durationMinute*1;
        this.startingSum = this.startingHour*60 + this.startingMinute*1;


      var temp={
            "date": this.date,
            "pocetniTrenutak":this.startingSum,
            "krajnjiTrenutak": this.durationSum
      }
        
        //Axios.post(`http://localhost:8082/api/medicalrooms/bookOperationRoom/${this.selectedRoom.id}/${this.date}/${this.startingSum}/${this.durationSum}`);
        Axios.post(`http://localhost:8082/api/medicalrooms/bookOperationRoom/${this.selectedRoom.id}`, temp);
    },
    changedRoom(event){
        this.selectedRoomName = event.target.options[event.target.options.selectedIndex].text;
        Axios.get(`http://localhost:8082/api/medicalrooms/${event.target.value}`).then(response => (this.selectedRoom = response.data))
    }
  },
  mounted() {
       /* Axios.get(`http://localhost:8082/api/examinations/${this.$route.params.id}`).then(response => (
            this.examination = response.data,
            this.examinationDate = response.data.date,
            this.exeminationStart = response.data.startTime,
            this.examinationEnd = response.data.endTime
        ));

        var temp = {
            "date": this.examinationDate,
            "pocetniTrenutak":this.exeminationStart,
            "krajnjiTrenutak": this.examinationEnd
        }*/
        Axios.get(`http://localhost:8082/api/medicalrooms/freeOperationRoom/${this.$route.params.examinationId}`).then(response => (
            this.freeOperationRooms = response.data
        ));
        //Axios.get(`http://localhost:8082/api/examinations/${this.$route.params.examinationId}`).then(response => (this.examination = response.data));
    }
};
</script>

<style>
</style>

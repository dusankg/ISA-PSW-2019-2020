<template>
  <div class="container">
    <h3>Respond to examination request</h3>
    <div class="container">
      <table class="table">
        <thead>
          <tr>
            <th>Id</th>
            <th>Date</th>
            <th>Start Time</th>
            <th>Duration</th>
            <th>Operation</th>
            <th>Type</th>
            <th>Doctor</th>
            <th>Patient</th>
          </tr>
        </thead>
        <tbody>
          <tr >
            <td>{{examination.id}}</td>
            <td>{{this.date}}</td>
            <td>{{this.startingHour}}h  {{this.startingMinute}}min</td>
            <td>{{this.durationHour}}h  {{this.durationMinute}}min</td>
            <td>{{examination.operation}}</td>
            <td>{{examination.type.typeName}}</td>
            <td>{{examination.doctor.name + ' ' + examination.doctor.surname}}</td>
            <td>{{examination.patient.name + ' ' + examination.patient.surname}}</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div>
      <h3>Book room for examination</h3>
        <div class="container">
          <button @click="setEnabledChange"> Enable changing time </button><br/>
          <form @submit="validateAndSubmit">
            <fieldset class="form-group">
              <label>Date</label>
              <input type="date" class="form-control" v-model="date" required :disabled="this.enabledChange == false" @change="changedDate($event)">
            </fieldset>

            <fieldset class="form-group">
              <label>Starting time</label>
              <select class="form-control" required @change="changedStartingHour($event)" :disabled="this.enabledChange == false">
                <option value=this.startingHour selected disabled>{{this.startingHour}}h</option>
                <option value="7">7h</option><option value="8">8h</option> <option value="9">9h</option>
                <option value="10">10h</option><option value="11">11h</option> <option value="12">12h</option>
                <option value="13">13h</option><option value="14">14h</option> <option value="15">15h</option>
                <option value="16">16h</option><option value="17">18h</option> <option value="18">18h</option>
              </select>
            </fieldset>

            <fieldset class="form-group">
              <select class="form-control" required @change="changedStartingMinute($event)" :disabled="this.enabledChange == false">
                <option value=this.startingMinute selected disabled>{{this.startingMinute}}min</option>
                <option value="0">0min</option><option value="5">5min</option> <option value="10">10min</option>
                <option value="15">15min</option><option value="20">20min</option> <option value="25">25min</option>
                <option value="30">30min</option><option value="35">35min</option> <option value="40">40min</option>
                <option value="45">45min</option><option value="50">50min</option> <option value="55">55min</option>
              </select>
            </fieldset>

            <fieldset class="form-group">
              <label>Duration</label>
              <select class="form-control" required @change="changedDurationHour($event)" :disabled="this.enabledChange == false">
                <option value=this.durationHour selected disabled>{{this.durationHour}}h</option>
                <option value="0">0h</option><option value="1">1h</option> <option value="2">2h</option>
                <option value="3">3h</option><option value="4">4h</option> <option value="5">5h</option>
              </select>
            </fieldset>

            <fieldset class="form-group">
              <select class="form-control" required @change="changedDurationMinute($event)" :disabled="this.enabledChange == false">
                <option value=this.durationMinute selected disabled>{{this.durationMinute}}min</option>
                <option value="0">0min</option><option value="5">5min</option> <option value="10">10min</option>
                <option value="15">15min</option><option value="20">20min</option> <option value="25">25min</option>
                <option value="30">30min</option><option value="35">35min</option> <option value="40">40min</option>
                <option value="45">45min</option><option value="50">50min</option> <option value="55">55min</option>
              </select>
            </fieldset>

            <fieldset class="form-group" >
              <br/>
              <label>Available rooms for the examination date and time</label>
              <select class="form-control" required @change="changedRoom($event)">
                <option value="" selected disabled>Choose room</option>
                <option v-for="room in freeExaminationRooms" :value="room.id" :key="room.id">{{room.roomCodeName}}</option>
              </select>
            </fieldset>

            <fieldset class="form-group" >
              <label>Available doctors for the examination date and time</label>
              <select class="form-control" required @change="changedDoctor($event)">
                <option value="" selected disabled>Choose doctor</option>
                <option v-for="doc in freeDoctors" :value="doc.id" :key="doc.id">{{doc.name + ' ' + doc.surname}}</option>
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
  name: "BookExaminationRoom",
  data() {
    return {
        freeExaminationRooms: [],
        enabledChange: false,
        freeDoctors: [],
        message: null,
        date: undefined,
        startingHour: 0,
        startingMinute: 0,
        startingSum: 0,
        durationHour: 0,
        durationMinute: 0, 
        durationSum: 0,
        examination: undefined,
        selectedRoom: undefined,
        selectedRoomName: "",
        selectedDoctor: undefined,
        selectedDoctorName: undefined,
        examinationDate: "",
        exeminationStart: undefined,
        examinationEnd: undefined
    };
  },
  methods: {
    changedDate(){
        this.retrieveFreeRoomsForOccupation();
    },
    changedStartingHour(event){
        this.startingHour = event.target.options[event.target.options.selectedIndex].value;
        this.retrieveFreeRoomsForOccupation();
        this.retrieveFreeDoctorsForOccupation();
    },
    changedStartingMinute(event){
        this.startingMinute = event.target.options[event.target.options.selectedIndex].value;
        this.retrieveFreeRoomsForOccupation();
        this.retrieveFreeDoctorsForOccupation();
    },
    changedDurationHour(event){
        this.durationHour = event.target.options[event.target.options.selectedIndex].value;
        this.retrieveFreeRoomsForOccupation();
        this.retrieveFreeDoctorsForOccupation();
    },
    changedDurationMinute(event){
        this.durationMinute = event.target.options[event.target.options.selectedIndex].value;
        this.retrieveFreeRoomsForOccupation();
        this.retrieveFreeDoctorsForOccupation();
    },
    retrieveFreeRooms(){
        Axios.get(`http://localhost:8082/api/medicalrooms/freeExaminationRoomForExamination/${this.$route.params.examinationId}`).then(response => (
            this.freeExaminationRooms = response.data
        ));
    },
    retrieveFreeRoomsForOccupation(){
        
      Axios.get(`http://localhost:8082/api/medicalrooms/freeExaminationRoomForOccupation/${this.date}/${this.startingSum}/${this.durationSum}`).then(response => (
        this.freeExaminationRooms = response.data
      ));

    },
    retrieveFreeDoctorsFromExamination(){
        Axios.get(`http://localhost:8082/api/doctors/freeDoctors/${this.$route.params.examinationId}`).then(response => (
            this.freeDoctors = response.data
        ));
    },
    retrieveFreeDoctorsForOccupation(){
      this.durationSum = this.startingHour*60 + this.startingMinute*1 + this.durationHour*60 + this.durationMinute*1;
      this.startingSum = this.startingHour*60 + this.startingMinute*1;
      
      Axios.get(`http://localhost:8082/api/doctors/freeDoctorsForOccupation/${this.date}/${this.startingSum}/${this.durationSum}`).then(response => (
        this.freeDoctors = response.data
      ));
      return this.freeDoctors;
    },
    retrieveParametersFromExamination(){

        var pocSat = 0;
        var durationSat = 0;
        Axios.get(`http://localhost:8082/api/examinations/${this.$route.params.examinationId}`).then(response => (
            this.examination = response.data,
            this.date = response.data.date,
            pocSat = Math.round(response.data.startTime*1 / 60),
            this.startingHour = response.data.startTime*1 / 60,

            durationSat = Math.round((response.data.endTime*1  - response.data.startTime*1)/60),
            this.durationHour = (response.data.endTime*1  - response.data.startTime*1)/60,
            this.countTime(pocSat, durationSat)
            ),

        ); 
    },
    countTime(pocSat, durationSat){
        if(pocSat > this.startingHour ){
          pocSat = pocSat - 1;
        } 
        this.startingMinute = Math.round((this.startingHour - pocSat) * 60);
        this.startingHour = pocSat;

        if(durationSat > this.durationHour ){
          durationSat = durationSat - 1;
        } 
        this.durationMinute = Math.round((this.durationHour - durationSat) * 60);
        this.durationHour = durationSat;
    },
    validateAndSubmit(e){
        e.preventDefault();

        this.durationSum = this.startingHour*60+ this.startingMinute*1 + this.durationHour*60 + this.durationMinute*1;
        this.startingSum = this.startingHour*60 + this.startingMinute*1;

        var temp={
            "date": this.date,
            "pocetniTrenutak":this.startingSum,
            "krajnjiTrenutak": this.durationSum
        }
        
        Axios.post(`http://localhost:8082/api/medicalrooms/bookOperationRoom/${this.selectedRoom.id}`, temp);
        Axios.post(`http://localhost:8082/api/doctors/bookDoctor/${this.selectedDoctor.id}/${this.selectedRoom.id}/${this.$route.params.examinationId}`, temp);
        Axios.get(`http://localhost:8082/api/examinations/acceptRequestForExamination/${this.$route.params.examinationId}/${this.selectedRoom.id}`).then(response => {
          Axios.get(`http://localhost:8082/api/examinations/examinationAccepted/${this.$route.params.examinationId}`);
          response.message;
        });
        
        if(this.enabledChange){
          Axios.get(`http://localhost:8082/api/examinations/changeDateAndTime/${this.$route.params.examinationId}/${this.date}/${this.startingSum}/${this.durationSum}`);
        }
        
    },
    changedRoom(event){
        this.selectedRoomName = event.target.options[event.target.options.selectedIndex].text;
        Axios.get(`http://localhost:8082/api/medicalrooms/${event.target.value}`).then(response => (this.selectedRoom = response.data))
    },
    changedDoctor(event){
        this.selectedDoctorName = event.target.options[event.target.options.selectedIndex].text;
        Axios.get(`http://localhost:8082/api/doctors/${event.target.value}`).then(response => (this.selectedDoctor = response.data))
    },
    setEnabledChange(){
      if(this.enabledChange == true ){
        this.retrieveParametersFromExamination();
        this.retrieveFreeDoctorsFromExamination();
        this.retrieveFreeRooms();
      }
      this.enabledChange = !this.enabledChange;
      
     }
  },
  
  mounted() {
        Axios.get(`http://localhost:8082/api/examinations/${this.$route.params.examinationId}`).then(response => (
            this.examination = response.data,
            this.examinationDate = response.data.date,
            this.exeminationStart = response.data.startTime,
            this.examinationEnd = response.data.endTime
        ));

        this.retrieveFreeRooms();
        this.retrieveFreeDoctorsFromExamination();
        this.retrieveParametersFromExamination();
          
    },
    
};
</script>

<style>
</style>

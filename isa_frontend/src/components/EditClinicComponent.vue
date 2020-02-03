<template>
  <div>
      <h3>Edit clinic</h3>
      <div class="container">
          <form @submit="validateAndSubmit">
            <fieldset class="form-group" name="nameField">
                <label>Name</label>
                <input type="text" class="form-control" v-model="name" required>
            </fieldset>
            <fieldset class="form-group">
                <label>Address</label>
                <input type="text" class="form-control" v-model="adress" required>
            </fieldset>
            <fieldset class="form-group">
                <label>Description</label>
                <input type="text" class="form-control" v-model="description">
            </fieldset>
            <fieldset class="form-group">            
                <label>Longitude</label>
                <input type="number" class="form-control" step="any" v-model="longitude">
            </fieldset>
            <fieldset class="form-group">
                <label>Latitude</label>
                <input type="number" class="form-control" step="any" v-model="latitude">
            </fieldset>             
            <button class="btn btn-success" type="submit">Save</button>
          </form>
            <!--This is the map-->
            <div id="map"> 
            </div>
      </div>
  </div>
</template>

<script>
import ClinicCenterService from '../service/ClinicCenterService';
import 'ol/ol.css';
import Map from 'ol/Map';
import View from 'ol/View';
import TileLayer from 'ol/layer/Tile';
import OSM from 'ol/source/OSM';
import {fromLonLat} from 'ol/proj';
export default {
    name: "EditClinic",
    data(){
        return {
            name: "",
            adress: "",
            description: "",
            longitude: undefined,
            latitude: undefined,
            coords: []
        }
    },

    methods: {
        
        validateAndSubmit(e){
            e.preventDefault();
            var temp = {
                "name": this.name,
                "adress": this.adress,
                "description": this.description,
                "gradeSum":0,
                "gradeNumber":0,
                "longitude": this.longitude,
                "latitude": this.latitude
            }
            ClinicCenterService.editClinic(temp);
            this.$router.push("/clinics");
        },

        drawMap(){
            this.coords = fromLonLat(this.coords);
            let map = new Map({
                target: 'map',
                layers: [
                    new TileLayer({source: new OSM()})
                ],
                view: new View({
                    center: this.coords,
                    zoom: 17
                })
            })
            map.message;
        },

        refreshClinic(){
            ClinicCenterService.retrieveClinic(this.$route.params.id).then(res => {
                this.name = res.data.name;
                this.adress = res.data.adress;
                this.description = res.data.description;
                this.longitude = res.data.longitude;
                this.latitude = res.data.latitude;
                this.coords = [this.longitude, this.latitude];
                // Because functions in javascript execute asynchronous I had to make nested call
                this.drawMap();
            });
        }

    },

    created(){
    },

    mounted(){
        this.refreshClinic();
    }
}
</script>

<style>
@import "~ol/ol.css";
  #map{
    height: 400px;
    width: 700px;
  }
</style>
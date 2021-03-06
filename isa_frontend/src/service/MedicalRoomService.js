import axios from "axios";

class MedicalRoomService{
    retrieveAllMedicalRooms(){
        return axios.get(`http://localhost:8082/api/medicalrooms/all`);
    }

    deleteRoom(id){
        return axios.delete(`http://localhost:8082/api/medicalrooms/${id}`);
    }

    retrieveRoom(id){
        return axios.get(`http://localhost:8082/api/medicalrooms/${id}`);
    }

    editRoom(room){
        return axios.put("http://localhost:8082/api/medicalrooms", room);
    }
}

export default new MedicalRoomService();
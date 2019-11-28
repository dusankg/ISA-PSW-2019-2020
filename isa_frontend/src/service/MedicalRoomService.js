import axios from "axios";

class MedicalRoomService{
    retrieveAllMedicalRooms(){
        return axios.get(`http://localhost:8082/api/medicalrooms/all`);
    }
}

export default new MedicalRoomService();
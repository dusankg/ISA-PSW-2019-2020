import axios from "axios";

class AbsenceRequestService {

    retrieveAllAbsenceRequests(){
        return axios.get(`http://localhost:8082/api/absencerequests/all`);
    }

    retrieveDoctorThatSentRequest(id){
        return axios.get(`http://localhost:8082/api/absencerequests/${id}/doctor`)
    }

    retrieveNurseThatSentRequest(id){
        return axios.get(`http://localhost:8082/api/absencerequests/${id}/nurse`)
    }

    deleteAbsenceRequest(id){
        return axios.delete(`http://localhost:8082/api/absencerequests/${id}`);
    }

}

export default new AbsenceRequestService();
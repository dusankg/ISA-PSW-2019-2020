import axios from "axios";

class AbsenceRequestService {

    retrieveAllAbsenceRequests(){
        return axios.get(`http://localhost:8082/api/absencerequests/all`);
    }

}

export default new AbsenceRequestService();
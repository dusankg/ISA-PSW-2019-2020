import axios from "axios";

class ClinicAdministratorService {
    retrieveAdministratorInformation(id){
        return axios.get(`http://localhost:8082/api/clinicalCenterAdministrators/${id}`)
    }
}

export default new ClinicAdministratorService();
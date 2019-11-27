import axios from "axios";



class ClinicCenterService {
  retrieveAllClinics() {
    return axios.get("http://localhost:8082/api/clinics/all");
    }

}


export default new ClinicCenterService();
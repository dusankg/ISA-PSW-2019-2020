import axios from "axios";



class PatientService {
  retrieveAllPatients() {
    return axios.get(`http://localhost:8082/api/patients/all`);
  }
}

export default new PatientService();
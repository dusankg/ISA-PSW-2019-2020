import axios from "axios";



class PatientService {
  retrieveAllPatients() {
    return axios.get("http://localhost:8082/api/patients/all");
 
  }

  retrievePatient(id){
    return axios.get(`http://localhost:8082/api/patients/${id}`);
  }
}

export default new PatientService();
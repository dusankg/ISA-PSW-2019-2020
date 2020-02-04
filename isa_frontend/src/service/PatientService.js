import axios from "axios";



class PatientService {
  retrieveAllPatients() {
    return axios.get("http://localhost:8082/api/patients/all", {withCredentials: true});
 
  }

  // Had to add this to avoid session
  retrievePatientNormal(id){
    return axios.get(`http://localhost:8082/api/patients/${id}`)
  }

  retrievePatient(){
    return axios.get(`http://localhost:8082/api/patients//loggedPatient`, {withCredentials: true});
  }
}

export default new PatientService();
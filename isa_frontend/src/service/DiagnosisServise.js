import axios from "axios";



class DiagnosisService {
  retrieveAllDiagnosis() {
    return axios.get(`http://localhost:8082/api/diagnosis/all`);
  }
}

export default new DiagnosisService();
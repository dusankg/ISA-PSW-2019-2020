import axios from "axios";



class DoctorService {
  retrieveAllDoctors() {
    return axios.get(`http://localhost:8082/api/doctors/all`);
  }
}

export default new DoctorService();
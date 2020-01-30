import axios from "axios";


class DoctorService {
  retrieveAllDoctors() {
    return axios.get(`http://localhost:8082/api/doctors/all`);
  }

  deleteDoctor(id){
    return axios.delete(`http://localhost:8082/api/doctors/${id}`);
  }

  retrieveDoctor(id){
    return axios.get(`http://localhost:8082/api/doctors/${id}`);
  }

  editDoctor(doctor){
    return axios.put("http://localhost:8082/api/doctors", doctor);
  }
}

export default new DoctorService();
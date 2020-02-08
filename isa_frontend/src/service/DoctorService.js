import axios from "axios";


class DoctorService {
  retrieveAllDoctors() {
    return axios.get(`http://localhost:8082/api/doctors/all`,{withCredentials: true});
  }

  deleteDoctor(id){
    return axios.delete(`http://localhost:8082/api/doctors/${id}`,{withCredentials: true});
  }

  retrieveDoctor(id){
    return axios.get(`http://localhost:8082/api/doctors/${id}`,{withCredentials: true});
  }

  editDoctor(doctor){
    return axios.put("http://localhost:8082/api/doctors", doctor),{withCredentials: true};
  }
  retrieveDoctorsOfClinic(id){
      return  axios.get('http://localhost:8082/api/clinics/getDoctors/' + id,{withCredentials: true})
  }
  retrieveAllDoctorsWherePatientWas() {
    return axios.get("http://localhost:8082/api/doctors/allDoctorsOfPatient", {withCredentials: true});
  }

}

export default new DoctorService();
import axios from "axios";


class ExaminationService {
  retrieveAllExaminations() {
    return axios.get(`http://localhost:8082/api/examinations/all`,{withCredentials: true});
  }
  retrieveAllExaminationsOfSelectedClinic() {
    return axios.get(`http://localhost:8082/api/examinations/allByClinic`,{withCredentials: true});
  }
  retrieveAllNonReservedExaminations() {
    return axios.get(`http://localhost:8082/api/examinations/nonReserved`,{withCredentials: true});
  }
  retrieveExamination(id) {
    return axios.get(`http://localhost:8082/api/examinations/${id}`, {withCredentials: true});
  }

}

export default new ExaminationService();
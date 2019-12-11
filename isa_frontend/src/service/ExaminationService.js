import axios from "axios";


class ExaminationService {
  retrieveAllExaminations() {
    return axios.get(`http://localhost:8082/api/examinations/all`);
  }

}

export default new ExaminationService();
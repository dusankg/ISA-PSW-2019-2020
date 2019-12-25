import axios from "axios";

class ExaminationTypeService {
    retrieveAllExaminationTypes(){
        return axios.get(`http://localhost:8082/api/examinationtypes/all`);
    }
}

export default new ExaminationTypeService();
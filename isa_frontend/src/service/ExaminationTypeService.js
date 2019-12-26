import axios from "axios";

class ExaminationTypeService {
    retrieveAllExaminationTypes(){
        return axios.get(`http://localhost:8082/api/examinationtypes/all`);
    }

    retrieveExaminationType(id){
        return axios.get(`http://localhost:8082/api/examinationtypes/${id}`);
    }

    deleteExaminationType(id){
        return axios.delete(`http://localhost:8082/api/examinationtypes/${id}`)
    }

    //For now I did not use these 2 methods but maybe in future I will, so I won't delete them
    createExaminationType(examinationtype){
        return axios.post("http://localhost:8082/api/examinationtypes", examinationtype);
    }

    editExaminationType(examinationtype){
        return axios.put("http://localhost:8082/api/examinationtypes", examinationtype);
    }
      
}

export default new ExaminationTypeService();
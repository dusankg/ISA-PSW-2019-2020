import axios from "axios";

class ExaminationTypeService {
    retrieveAllExaminationTypes(){
        return axios.get(`http://localhost:8082/api/examinationtypes/all`, {withCredentials: true});
    }

    retrieveExaminationType(id){
        return axios.get(`http://localhost:8082/api/examinationtypes/${id}`, {withCredentials: true});
    }

    deleteExaminationType(id){
        return axios.delete(`http://localhost:8082/api/examinationtypes/${id}`, {withCredentials: true})
    }

    //For now I did not use these 2 methods but maybe in future I will, so I won't delete them
    createExaminationType(examinationtype){
        return axios.post("http://localhost:8082/api/examinationtypes", examinationtype, {withCredentials: true});
    }

    editExaminationType(examinationtype){
        return axios.put("http://localhost:8082/api/examinationtypes", examinationtype, {withCredentials: true});
    }
      
}

export default new ExaminationTypeService();
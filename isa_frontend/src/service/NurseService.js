import axios from "axios";

class NurseService{

    retrieveNurse(id){
        return axios.get(`http://localhost:8082/api/nurses/${id}`, {withCredentials: true});
    }

    editNurse(nurse){
        return axios.put("http://localhost:8082/api/nurses", nurse, {withCredentials: true});
    }
}

export default new NurseService();
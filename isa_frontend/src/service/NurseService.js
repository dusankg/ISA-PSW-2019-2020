import axios from "axios";

class NurseService{

    retrieveNurse(id){
        return axios.get(`http://localhost:8082/api/nurses/${id}`);
    }

    editNurse(nurse){
        return axios.put("http://localhost:8082/api/nurses", nurse);
    }
}

export default new NurseService();
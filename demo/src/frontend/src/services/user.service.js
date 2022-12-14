import axios from 'axios';
import authHeader from './auth-header';
const API_URL = 'http://49.50.161.140:8090/api/test/';
// const API_URL = 'http://localhost:8090/api/test/';
class UserService {
  getPublicContent() {
    return axios.get(API_URL + 'all');
  }
  getUserBoard() {
    return axios.get(API_URL + 'user', { headers: authHeader() });
  }
  getAdminBoard() {
    return axios.get(API_URL + 'admin', { headers: authHeader() });
  }
}
export default new UserService();
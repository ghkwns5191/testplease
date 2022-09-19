import axios from "axios";
export default axios.create({
  baseURL: "http://49.50.161.140:8090/api",
  headers: {
    "Content-type": "application/json"
  }
});
import axios from "axios";
export default axios.create({
  baseURL: "http://101.101.218.198:8090/api",
  headers: {
    "Content-type": "application/json"
  }
});
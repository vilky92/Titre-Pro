import axios from "axios";
import auth from "./utils/auth";

axios.defaults.baseURL = "http://localhost:8181/"; // le port de votre serveur

// LES REQUETES VERS LE BACKEND SONT TOUTES CAPTUREES ICI !!!
axios.interceptors.request.use(
  (config) => {
    // Do something before request is sent...
    // les bodys des reqHTTP partent au format json ...
    config.headers["Content-Type"] = "application/json";
    config.headers["Access-Control-Allow-Origin"]= "*";
    config.headers["Access-Control-Allow-Methods"] ="DELETE, POST, GET, OPTIONS";
    config.headers["Access-Control-Allow-Headers"]= "Origin, Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With";
    //const localAuthToken = auth.getLocalToken();
    const localAuthToken = auth.getLocalToken()
    
    if (localAuthToken) config.headers["Authorization"] = localAuthToken;

    return config;
  },
  error => {
    // Do something with request error
    return Promise.reject(error);
  }
);


export default axios.defaults;
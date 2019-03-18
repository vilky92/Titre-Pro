import axios from "axios";
import auth from "./utils/auth";

axios.defaults.baseURL = "http://localhost:8181/"; // le port de votre serveur

// LES REQUETES VERS LE BACKEND SONT TOUTES CAPTUREES ICI !!!
axios.interceptors.request.use(
  (config) => {
    // Do something before request is sent...
    // les bodys des reqHTTP partent au format json ...

    //const localAuthToken = auth.getLocalToken();
    const localAuthToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGhvcml0aWVzIjpbImFkbWluIl0sImlhdCI6MTU1MjkyODAwNSwiZXhwIjoxNTUzNTMyODA1fQ.1rJ_Yes4CQeMlegHGyc_43RHEG70KaZmSggz_PrOXdWRySbTCjqRv6mXKAqR0R9kpcj1tZwxT42-hSPM2FbgqA"
    console.log("authToken")
    console.log(localAuthToken)
    // on essaie de récupérer le token d'auth
    config.headers["Content-Type"] = "application/json";
    config.headers["Access-Control-Allow-Origin"]= "*";
    config.headers["Access-Control-Allow-Methods"] ="DELETE, POST, GET, OPTIONS";
    config.headers["Access-Control-Allow-Headers"]= "Origin, Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With";
    console.log("config header")
    console.log(config.headers)
    // si le token existe, on l'envoie dans l'entête de chaque reqHTTP
    console.log(window.sessionStorage.getItem("Mon token"))
    if (localAuthToken) config.headers["Authorization"] = "Bearer "+localAuthToken;
    console.log("CONFIG HEADER")
    console.log(config.headers)
    console.log("config")
    console.log(config)
    return config;
  },
  error => {
    // Do something with request error
    return Promise.reject(error);
  }
);


export default axios.defaults;
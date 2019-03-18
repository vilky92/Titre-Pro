<template>
<div>
    <div class="form">
        <h2>Login</h2>
        <div class="username">
            <label for="email">Username</label>
            <input type="text" name="username" id="email" v-model="login.username">
        </div>
        <div class="password">
            <label for="password">Password</label>
            <input type="password" name="password" id="password" v-model="login.password">
        </div>
        <button class="connexion" @click='handleSubmit'>Connexion</button>
        <p>{{msgError}}</p>
        <p>{{login.username}} {{login.password}}</p>
        <p>{{login}}</p>
        <p>{{this.$store.token}}</p>
    </div>
    <router-link class="inscription" to="/inscription">S'inscrire</router-link>
    <router-view />
</div>
</template>

<script>
//import auth from "./../utils/auth";
import axios from "axios";
import auth from "@/utils/auth";

export default {
data() {
    return{
        msgError: '',
        logins: {},
        login: {
            username: '',
            password: ''
        },
    }
},
methods: {

        connexion(log) {
            const id = "Mon id";
            const token = "Mon token";
            const role = "Mes roles";
            console.log(log);
        axios.post("http://localhost:8181/ano/login", log)
          .then(response => {
            console.log("sucess", response);
            console.log(response.data)
            auth.setLocalToken("Bearer "+response.data.jwt)
            window.sessionStorage.setItem(token,"Bearer "+response.data.jwt)
            window.sessionStorage.setItem(id, response.data.id);
            window.sessionStorage.setItem(role, response.data.roles);
           // this.$router.push('mon-profil');
          }).catch(error => {
          this.msgError = error.data
          console.log("erreur", error);
        }
     );
    },

    handleSubmit(e) {
    e.preventDefault();
      if (
        !this.login.username ||
        !this.login.password
      ) {
        console.log("error")
      } else this.connexion(this.login);
      console.log("methode password");
    }
}
}
</script>

<style scoped>
.form {
    margin-left: 25%;
    width: 50%;
    text-align: center;
}
.username{
    margin-top: 30px;
}
.password{
    margin-top: 20px;
}

.connexion {
    margin-top: 20px;
    margin-left: 5%;
    padding:6px 0 6px 0;
	font:bold 13px Arial;
	background:#f5f5f5;
	color:#555;
	border-radius:2px;
	width:100px;
	border:1px solid #ccc;
	box-shadow:1px 1px 3px #999;
}

.inscription {
    margin-left: 50%;
    padding:6px 0 6px 0;
	font:bold 13px Arial;
	background:#f5f5f5;
	color:#555;
	border-radius:2px;
	border:1px solid #ccc;
	box-shadow:1px 1px 3px #999;
}

</style>
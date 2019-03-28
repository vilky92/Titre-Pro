<template>
<div>
    <div class="form">
        <h1>{{msgError}}</h1>
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
            console.log("je suis connexion")
            const id = "Mon id";
            const role = "Mes roles";
        axios.post("http://localhost:8181/ano/login", log)
          .then(response => {
            auth.setLocalToken("Bearer "+response.data.jwt)
            window.sessionStorage.setItem(id, response.data.id);
            window.sessionStorage.setItem(role, response.data.role.label);
            this.$router.push('profil');
          }).catch(error => {
            window.sessionStorage.removeItem("Authorization");
            window.sessionStorage.removeItem("Mes roles");
            window.sessionStorage.removeItem("Mon id");
          this.msgError = "Mauvais login"
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
        this.msgError = "veuillez remplir les champs"
      } else this.connexion(this.login);
      console.log("sucess");
    }
}
}
</script>

<style scoped>
.form {
    margin-left: 25%;
    width: 50%;
    text-align: center;
    margin-top: 50px;
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
    margin-bottom: 50px;
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
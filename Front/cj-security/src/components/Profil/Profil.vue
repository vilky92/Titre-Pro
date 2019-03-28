<template>
<div class="container">  
  <form id="contact" action="" method="put">
     <h2>{{message}}</h2>
    <h2>{{msg}}</h2>
    <h2>{{msgCls}}</h2> 
    <h3>Profil</h3>
    <fieldset>
      <label>Your login : {{userG.login}} </label>
      <input placeholder="Your login" type="text" tabindex="1" required autofocus v-model="user.login">
    </fieldset>
    <fieldset>
        <label>Your mail : {{userG.mail}} </label>
      <input placeholder="Your Email Address" type="email" tabindex="2" required v-model="user.mail">
    </fieldset>
    <fieldset>
        <label>Your first name : {{userG.firstName}} </label>
      <input placeholder="Your first name" type="text" tabindex="3" required v-model="user.firstName">
    </fieldset>
    <fieldset>
        <label>Your last name : {{userG.lastName}} </label>
      <input placeholder="Your last name" type="text" tabindex="4" required v-model="user.lastName">
    </fieldset>
    <fieldset>
        <label>Your password :  </label>
      <input placeholder="Your password" type="password" tabindex="5" required v-model="passwordOne">
    </fieldset>
    <fieldset>
        <label>Confirm password : </label>
      <input placeholder="Confirm password" type="password" tabindex="6" required v-model="passwordTwo">
    </fieldset>
    <fieldset>            
        <button id="contact-submit" @click="handleSubmit">Modifier mon compte</button>
    </fieldset>
  </form>
 
  
</div>
</template>

<script>
import axios from "axios"
import auth from "@/utils/auth";
import Axios from 'axios';

export default {
data() {
    return {
      msg: "",
      msgCls: "",
        message: "",
        passwordOne: "",
        passwordTwo: "",
       userG: {
        id: sessionStorage.getItem("Mon id"),
        login: "",
        passwordHash: "",
        mail: "",
        lastName: "",
        firstName: "",
      },
      user: {
        id: sessionStorage.getItem("Mon id"),
        login: "",
        passwordHash: "",
        mail: "",
        lastName: "",
        firstName: "",
      },
    };
  },

    mounted() {
         axios.get("user/get/" + sessionStorage.getItem("Mon id"))
         .then(res => {
            console.log("sucess", res);
            this.userG = res.data;
          })
          .catch(err => {
            console.log("aaaaaaaaa")
            console.log(auth);
            console.log("error", err);
          })
     },

  methods: {

      updateUser(user) {
        console.log(user.id);
      axios.put("user/put/"+ sessionStorage.getItem("Mon id"), user).then(
        response => {
          this.users = response.data;
          this.$store.state.userId= response.data.id;
        axios.get("http://localhost:8181/user/get/"+ sessionStorage.getItem("Mon id"))
         .then(res => {
            console.log("sucess", res);
            this.userG = res.data;
          })
          .catch(err => {
            console.log("error", err);
          })


        }).catch((response) => {
          console.log("erreur", response);
        }
      );
      },

    password() {
      console.log("password")
        if(this.passwordOne === this.passwordTwo && this.passwordOne != null) {
            console.log("success password")
            this.user.passwordHash = this.passwordOne
            console.log(this.user)
            return this.updateUser(this.user)
        }
        else {
            console.log("fail")

            return this.message = "mot de passe différent"
        }
  },

      handleSubmit() {
          console.log("je suis one")
      if (
        this.user.login ||
        this.user.mail ||
        this.user.firstName ||
        this.user.lastName 
      ) {
       this.password();
      console.log("methode password");
      } else console.log("error")
        return this.displayMessage(
          "Vous devez remplir l'un des champs",
          "warning"
        )
      },

          displayMessage(msg, status) {
            console.log("displaymessage")
      if (!msg) return console.error(`the message is required !`);
      const possibleStatuses = ["success", "warning", "error"];
      if (possibleStatuses.includes(status)) {
        this.msgCls = status;
        this.msg = msg;
      } else console.warning(`${status} is not a valid css class for messages`);
    },
  }
}
</script>

<style scoped>
* {
	margin:0;
	padding:0;
	box-sizing:border-box;
	-webkit-box-sizing:border-box;
	-moz-box-sizing:border-box;
	-webkit-font-smoothing:antialiased;
	-moz-font-smoothing:antialiased;
	-o-font-smoothing:antialiased;
	text-rendering:optimizeLegibility;
}

.container {
	width:40%;
	margin-left: 5%;  
	position:relative;
}

#contact input[type="text"], #contact input[type="email"], #contact input[type="tel"], #contact input[type="url"], #contact textarea, #contact button[type="submit"] { font:400 12px/16px "Open Sans", Helvetica, Arial, sans-serif; }

#contact {
	background:#F9F9F9;
	padding:25px;
	margin:50px 0;
}

#contact h3 {
	color: black;
	display: block;
	font-size: 30px;
	font-weight: 400;
}

#contact h4 {
	margin:5px 0 15px;
	display:block;
	font-size:13px;
}

fieldset {
	border: medium none !important;
	margin: 0 0 10px;
	min-width: 100%;
	padding: 0;
	width: 100%;
}

#contact input[type="text"], #contact input[type="email"], #contact input[type="tel"], #contact input[type="url"], #contact textarea {
	width:100%;
	border:1px solid #CCC;
	background:#FFF;
	margin:0 0 5px;
	padding:10px;
}

#contact input[type="text"]:hover, #contact input[type="email"]:hover, #contact input[type="tel"]:hover, #contact input[type="url"]:hover, #contact textarea:hover {
	-webkit-transition:border-color 0.3s ease-in-out;
	-moz-transition:border-color 0.3s ease-in-out;
	transition:border-color 0.3s ease-in-out;
	border:1px solid #AAA;
}

#contact textarea {
	height:100px;
	max-width:100%;
  resize:none;
}

#contact button[type="submit"] {
	cursor:pointer;
	width:100%;
	border:none;
	background:black;
	color:#FFF;
	margin:0 0 5px;
	padding:10px;
	font-size:15px;
}

#contact button[type="submit"]:active { box-shadow:inset 0 1px 3px rgba(0, 0, 0, 0.5); }

#contact input:focus, #contact textarea:focus {
	outline:0;
	border:1px solid #999;
}
::-webkit-input-placeholder {
 color:#888;
}
:-moz-placeholder {
 color:#888;
}
::-moz-placeholder {
 color:#888;
}
:-ms-input-placeholder {
 color:#888;
}

#contact-submit {

  padding:6px 0 6px 0;
	font:bold 13px Arial;
	background:#f5f5f5;
	color:#555;
	border-radius:2px;
	width:40%;
	border:1px solid #ccc;
	box-shadow:1px 1px 3px #999;
  margin-left: 25%;
  margin-top: 15px;

}

#contact-submit:hover {
  cursor: pointer;
}

@media screen and (max-width: 780px) {
  h1 {
    margin-left: 35%
  }
#contactes {
    width: 80%;
    margin-left: 10%;
    margin-bottom: 20px;
  }
}
</style>

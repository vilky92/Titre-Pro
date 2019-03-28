<template>
    <div>
        <h1>Inscription</h1>
        <form id="contactes" action method="post">
          <p>{{message}}</p>
          <fieldset class="field">
            <input placeholder="Nom..." type="noms" required v-model="user.lastName">
          </fieldset>

          <fieldset class="field">
            <input placeholder="prenom..." type="prenoms" required v-model="user.firstName">
          </fieldset>

          <fieldset class="field">
            <input placeholder="pseudo...." type="pseudo" required v-model="user.login">
          </fieldset>

          <fieldset class="field">
            <input
              placeholder="Votre adresse mail..."
              type="email"
              tabindex="2"
              required
              v-model="user.mail"
            >
          </fieldset>

          <fieldset class="field">
            <input
              placeholder="mot de passe "
              type="password"
              tabindex="3"
              required
              v-model="passwordOne"
            >
          </fieldset>

          <fieldset class="field">
            <input
              placeholder="resaissisez votre mot de passe "
              type="password"
              tabindex="3"
              required
              v-model="passwordTwo"
            >
          </fieldset>
          <!--  -->
          <fieldset class="fieldI">
            <button
              name="submit"
              type="submit"
              id="newcontactsubmit"
              data-submit="...Sending"
              @click="handleSubmit"
            >
              <span>Inscription</span>
            </button>
          </fieldset>
        </form>
    </div>
</template>

<script>
import axios from "axios";

export default {

  data() {
    return {
      msg: null,
      msgCls: null,
      message: "",
      users: [],
      passwordOne: "",
      passwordTwo: "",
      user: {
        id: null,
        login: "",
        passwordHash: "",
        mail: "",
        lastName: "",
        firstName: "",
      },
    };
  },
  methods: {
    displayMessage(msg, status) {
      if (!msg) return console.error(`the message is required !`);
      const possibleStatuses = ["success", "warning", "error"];
      if (possibleStatuses.includes(status)) {
        this.msgCls = status;
        this.msg = msg;
      } else console.warning(`${status} is not a valid css class for messages`);
    },

    createUser(user) {
      console.log(this.user);
      console.log(user);
      axios.post("http://localhost:8181/ano/post", this.user).then(
        response => {
          this.users = response.data;
          console.log("sucess", response);
          this.$router.push("profil")
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
            return this.createUser(this.user)
        }
        else {
            console.log("fail")

            return this.message = "mot de passe différent"
        }
    },
    handleSubmit(e) {
      e.preventDefault();
      if (
        !this.user.login ||
        !this.user.mail ||
        !this.user.firstName ||
        !this.user.lastName 
      ) {
        console.log("error")
        return this.displayMessage(
          "Vous devez remplir tout les champs",
          "warning"
        );
      } else this.password();
      console.log("methode password");
    }
  }
};
</script>

<style scoped>
h1{
  margin-top: 100px;
  margin-left: 45%;
}
#contactes {
    margin-top: 100px;
    width: 20%;
    margin-left: 40%;
    border: 2px solid black;
    display:flex;
    flex-direction: column;
    background:#F9F9F9;

}
.field {
  margin-top: 10px;
  border: 1px solid black;
  margin-bottom: 10px;
}

input{
  width: 100%;
}
#newcontactsubmit {
    padding:6px 0 6px 0;
	font:bold 13px Arial;
	background:#f5f5f5;
	color:#555;
	border-radius:2px;
	width:60%;
	border:1px solid #ccc;
	box-shadow:1px 1px 3px #999;
    margin-left: 20%;
  margin-right: 20%;
  margin-top: 5px;
}

.fieldI {
  margin-top: 10px;
  border: 1px solid black;
  margin-bottom: 10px;
  margin-left: 20%;
  margin-right: 20%;
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

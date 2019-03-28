<template>
    <div class="formulaire">
        <h1>Modifier ma candidature</h1>
        <form id="contactes" action method="post">
          <p>{{message}}</p>
          <fieldset>
            <input placeholder="Numéro de carte Pro" type="texte" required v-model="application.numberCard">
          </fieldset>

          <fieldset>
            <input placeholder="Numéro de téléphone..." type="tel" required v-model="application.numberPhone">
          </fieldset>

          <fieldset>
            <input placeholder="Adresse...." type="texte" required v-model="application.address">
          </fieldset>

          <fieldset>
            <input placeholder="Ville...." type="texte" required v-model="application.city">
          </fieldset>

          <fieldset class="menu-deroulant">
            <label for="pet-select">Votre Poste :</label>
            <select class="yes" name="titre" v-model="application.sectorId" required>
              <option value="1">Garde du corps</option>
              <option value="2">Sécurité Incendie</option>
              <option value="3">Maître chien</option>
              <option value="4">Agent de sécurité</option>
            </select>
          </fieldset>



          <fieldset>
            <textarea placeholder="Votre motivation...." tabindex="5" required v-model="application.coverLetter"></textarea>
          </fieldset>
          
          <fieldset>
            <button
              name="submit"
              type="submit"
              id="newcontactsubmit"
              data-submit="...Sending"
              @click="handleSubmit"
            >
              <span>Modifier ma candidature</span>
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
      applications: [],
      application: {
        userId: sessionStorage.getItem("Mon id"),
        numberCard: "",
        numberPhone: "",
        address: "",
        city: "",
        coverLetter: "",
        sectorId: null
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

    updateApplication(application) {
      console.log(this.application);
      console.log(application);
      axios.put("http://localhost:8181/apli/put", this.application).then(
        response => {
          this.applications = response.data;
          console.log("sucess", response);
          location.reload();
        }).catch((response) => {
          console.log("erreur", response);
        }
      );
    },


    handleSubmit(e) {
      e.preventDefault();
      if (
        !this.application.numberCard ||
        !this.application.numberPhone ||
        !this.application.address ||
        !this.application.city ||
        !this.application.coverLetter
      ) {
        console.log("error")
        return this.displayMessage(
          "Vous devez remplir tout les champs",
          "warning"
        );
      } else this.updateApplication(this.application);
      console.log("methode password");
    }
  }
};
</script>

<style scoped>
.formulaire {
  width: 75%;
    margin-left: 40%;
    text-align: center;
    background: #F9F9F9;
}
#newcontactsubmit {
    padding:6px 0 6px 0;
	font:bold 13px Arial;
	background:#f5f5f5;
	color:#555;
	border-radius:2px;
	width:100px;
	border:1px solid #ccc;
	box-shadow:1px 1px 3px #999;
}
fieldset{
  border: 1px solid black;
}
@media screen and (max-width: 780px) { 
  .formulaire {
  width: 80%;
  margin-left: 0%;
    text-align: center;
    background: #F9F9F9;
}
#newcontactsubmit {
    padding:6px 0 6px 0;
	font:bold 13px Arial;
	background:#f5f5f5;
	color:#555;
	border-radius:2px;
	width:100px;
	border:1px solid #ccc;
	box-shadow:1px 1px 3px #999;
}
fieldset{
  border: 1px solid black;
}
}
</style>


<template>
    <div class="formulaire">
        <h1>Ma candidature</h1>
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
            <label for="pet-select">Votre Poste : {{application.sectorLabel}}</label>
            </select>
          </fieldset>
          <fieldset>
            <textarea placeholder="Votre motivation...." tabindex="5" required v-model="application.coverLetter"></textarea>
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
        sectorLabel: "",
        userLabel: ""
      }
    };
  },

  mounted() {
      axios.get("http://localhost:8181/apli/get/"+ sessionStorage.getItem("Mon id")).then(
        response => {
          this.application = response.data;
          console.log("sucess", response);
        }).catch((response) => {
          console.log("erreur", response);
        }
      );
  },
  methods: {

  }
};
</script>

<style scoped>
.formulaire {
    margin-top: 100px;
    width: 20%;
    margin-left: 40%;
    text-align: center;
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
</style>


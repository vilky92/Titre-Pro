<template>
    <div>
        <button @click="handlesubmit">Suprimer mon compte</button>
    </div>
</template>

<script>
import axios from "axios"

export default {
methods: {
    delete() {
        axios.delete("http://localhost:8181/user/delete/"+sessionStorage.getItem("Mon id"))
         .then(res => {
            console.log("sucess", res);
            console.log("account delete");
            window.sessionStorage.removeItem("Authorization");
            window.sessionStorage.removeItem("Mes roles");
            window.sessionStorage.removeItem("Mon id");
            this.$router.push("connexion")
          })
          .catch(err => {
            console.log("error", err);
          })
    },

    handlesubmit() {
        console.log("handlesubmit")
        this.delete();
    }
}
}
</script>

<style scoped>
    button{
          padding:6px 0 6px 0;
	font:bold 13px Arial;
	background:#f5f5f5;
	color:#555;
	border-radius:2px;
	width:20%;
	border:1px solid #ccc;
	box-shadow:1px 1px 3px #999;
  margin-left: 15%;
    }

    button:hover{
        cursor: pointer;
    }
        @media screen and (max-width: 780px) {
        button {
            width: 80%;
            margin-left: 5%;
            margin-bottom: 50px;
        }
    }
</style>

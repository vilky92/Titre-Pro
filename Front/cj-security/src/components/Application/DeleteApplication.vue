<template>
    <div>
        <button @click="handlesubmit">Suprimer ma candidature</button>
    </div>
</template>

<script>
import axios from "axios"

export default {
methods: {
    delete() {
        axios.delete("http://localhost:8181/apli/delete/"+sessionStorage.getItem("Mon id"))
         .then(res => {
            console.log("sucess", res);
            console.log("application delete");
            location.reload();
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
        margin-top: 30px;
    padding:6px 0 6px 0;
	font:bold 13px Arial;
	background:#f5f5f5;
	color:#555;
	border-radius:2px;
	width:60%;
	border:1px solid #ccc;
	box-shadow:1px 1px 3px #999;
     margin-left: 50%;
     margin-bottom: 20px;
    }

    button:hover{
        cursor: pointer;
    }
    @media screen and (max-width: 780px) {
        button {
            width: 80%;
            margin-left: 0%;
        }
    }

</style>

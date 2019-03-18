<template>
    <div>
        <h1>JE SUIS DELETE</h1>
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

<style>

</style>

<template>
    <div class=all>
     <div v-if = admin>
       <Admin/>
     </div>
     <div v-else-if = connected>
        <Profil class="profil"/>
        <DeleteAccount class="delete"/>
        <MyApplication class="application"/>
      </div>
      
      <div class="co" v-else>
        <Connexion/>
      </div>
    </div>
</template>

<script>
import Profil from "@/components/Profil/Profil.vue"
import DeleteAccount from "@/components/Profil/DeleteAccount.vue"
import Connexion from '@/components/Connexion/Connexion.vue'
import MyApplication from '@/views/Application/MyApplication.vue'
import Admin from '@/views/Admin/Admin.vue'

export default {
  components : {
    Profil,
    DeleteAccount,
    Connexion,
    MyApplication,
    Admin
  },

  data() {
    return {
      connected: false,
      admin: false
    }
       },
  
  mounted() {
    if(window.sessionStorage.getItem("Mon id") != null && !(window.sessionStorage.getItem("Mes roles") == "admin")) {
      this.connected = true;
    } else if (window.sessionStorage.getItem("Mes roles") == "admin") {
      this.admin = true;
    }else {
      this.connected = false;
    }
  }
}
</script>

<style scoped>
.co {
  margin-top: 81px;
}

.all {
  width: 100%;
}
@media screen and (max-width: 780px) {
  .profil {
    width: 80%;
  }

  .application {
    width: 90%;
    margin-left: 5%;
  }
}
</style>

<template>
    <div>
      <!-- connected -->
     <div v-if = true>
        <Profil/>
        <!-- <DeleteAccount/>
        <MyApplication/> -->
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

export default {
  components : {
    Profil,
    DeleteAccount,
    Connexion,
    MyApplication
  },

  data() {
    return {
      connected: false,
    }
       },
  
  mounted() {
    if(this.$store.getters["userId"] != null) {
      this.connected = true;
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
</style>

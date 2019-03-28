<template>
<div>
    <div class="header">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li>
                    <figure class="slide" id="garcon">
                        <img src="./assets/logo.jpg" alt="logo" class="logo">
                    </figure>
                </li>
                <li class="nav-item active">
                    <a class="btn"><router-link to="/about">CJ-S&eacute;curit&eacute;</router-link></a>
                </li>
                <li class="nav-item">
                    <a class="btn"><router-link  to="/application">Recrutement</router-link></a>
                </li>
                <li class="nav-item">
                    <a class="btn"><router-link  to="/profil">Profil</router-link></a>
                </li>
                <li class="nav-item">
                    <a class="btn"><router-link  to="/connexion">S'inscrire/se connecter</router-link></a>
                </li> 
                <li class="nav-item">
                    <a class="btn" @click="Disconnected">D&eacute;connexion</a>
                </li>           
            </ul>
        </div>
    </nav>
    </div>
    <router-view/>
</div>
</template>
<script>
export default {
    methods: {
        Disconnected() {
            console.log("je suis disconnected")
            window.sessionStorage.removeItem("Authorization");
            window.sessionStorage.removeItem("Mes roles");
            window.sessionStorage.removeItem("Mon id");
            this.$router.push("connexion")
        }
    }
}
</script>


<style scoped>
body {
    width: 100%;
    height: 100%
}


.bg-light {
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;
    width: 100%;
    background: black !important;
    position: fixed;
    top: 0;
    left: 0;
    z-index: 2;
    height: 80px;
}

.navbar-toggler {
    position: fixed;
    background: white;
    z-index: 5;
}



.slide{
width: 100%;
background: white
}

figure {
    margin-top: 0px;
    background: white
}

.logo{
width: 100%;
height: 70px;
    margin-left: 0px;
    padding-left: 0px;
    background: white

}


.header a{
    background: black;
    color: white;
    text-decoration:none;
    margin:auto;
    margin-top: 18px;
}

a:hover {
    cursor: pointer
}

a:not([href]):not([tabindex]) {
color: white;
}
 

</style>
<style>
a {
    font-family: 'Roboto', sans-serif;   
}

p {
    font-family: 'Roboto', sans-serif;
} 

</style>

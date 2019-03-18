<template>
<div>
<div class="header">
    <nav class="nav" role="navigation">
        <figure class="slide" id="garcon">
            <img src="./assets/logo.jpg" alt="logo" class="logo">
        </figure>
        <a class="btn"><router-link to="/about">CJ-S&eacute;curit&eacute;</router-link></a>
        <a class="btn"><router-link  to="/">Nos pr&eacute;stations</router-link></a>
        <a class="btn"><router-link  to="/">Devis</router-link></a>
        <a class="btn"><router-link  to="/application">Recrutement</router-link></a>
        <a class="btn"><router-link  to="/profil">Profil</router-link></a>
        <a class="btn"><router-link  to="/connexion">S'inscrire/se connecter</router-link></a>
    </nav>
</div>
      <router-view/>
</div>
</template>

<style scoped>
body{
    width: 100%;
    height: 100%;
}

.header{
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
    width: 100%;
    background: black;
    position: fixed;
    top: 0;
    left: 0;
    z-index: 2;
    height: 80px;
}

h1{
    margin-top: auto;
}

.slide{
width: 20%;
}

figure {
    margin-top: 0px;
}

.logo{
width: 100%;
height: 80px;
}

nav{
    display: flex;
    width:100%;
}
.header a{
    border: 1px solid black;
    width: 20%;
    text-align:center;
    text-decoration:none;
    color: white;
    margin:auto;
    margin-top: 30px;
}

a {
    font-family: 'Roboto', sans-serif;   
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

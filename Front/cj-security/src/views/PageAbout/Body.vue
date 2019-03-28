<template>
  <div class="main">
    <h1>PRESENTATION DE LA SOCI&Eacute;T&Eacute;E</h1>
    <p
      class="presentation"
    >CJ-S&eacute;curit&eacute; est une société de sécurité spécialisée dans la gestion et la prévention des risques pour assurer la sécurité, la surveillance et le gardiennage des biens et des personnes.</p>
    <section class="un">
      <article>
        <figure>
          <img src="@/assets/protection.png" alt="protection rapprochée" class="resp3">
          <p
            class="protection"
          >CJ-S&eacute;curit&eacute; assure votre protection 24h/24 et 7j/7 où que vous alliez.</p>
        </figure>
        <figure>
          <img src="@/assets/Biens.png" alt="protection des biens" class="resp3">
          <p
            class="biens"
          >CJ-S&eacute;curit&eacute; assure la sécurité incendie et la surveillance des sièges sociaux d’entreprises françaises et internationales. Elle assure aussi la s&eacute;curit&eacute; des biens des particuliers</p>
        </figure>
      </article>
    </section>
    <section class="deux">
      <article>
        <figure>
          <img src="@/assets/luxe.png" alt="magasin de luxe" class="resp">
          <p
            class="luxe"
          >Par son savoir-faire et ses prestations haut-de-gamme, CJ-S&eacute;curit&eacute; s’est spécialisé dans le luxe et a su convaincre de grandes maisons leaders du secteur.</p>
        </figure>
        <figure>
          <img src="@/assets/shop.png" alt="magasin" class="resp">
          <P
            class="mag"
          >Les magasins, centres commerciaux et showrooms sont caractérisés par une forte affluence de client et un aménagement qui peut être propice au vol.</P>
        </figure>
      </article>
    </section>
    <section class="trois">
      <article class="bloc_PR">
        <h3>Agent de S&eacute;curit&eacute; de Protection Rapproch&eacute;e</h3>
        <p class="prix" id="prix">
          <span class="euro">23&euro;</span> 50
        </p>
        <p>par heure</p>
      </article>
      <article class="bloc_SI">
        <h3>Agent de S&eacute;curit&eacute; Incendie</h3>
        <p class="prix">
          <span class="euro">23&euro;</span> 50
        </p>
        <p>par heure</p>
      </article>
      <article class="bloc_cyno">
        <h3>Agent de S&eacute;curit&eacute; Cynophile</h3>
        <p class="prix">
          <span class="euro">23&euro;</span> 50
        </p>
        <p>par heure</p>
      </article>
    </section>
    <section class="quatre">
      <article class="bloc_Ev">
        <h3>Agent de S&eacute;curit&eacute; &Eacute;v&eacute;nementielle</h3>
        <p class="prix">
          <span class="euro">23&euro;</span> 50
        </p>
        <p>par heure</p>
      </article>
      <article class="luxe">
        <h3>Agent de S&eacute;curit&eacute; Luxe</h3>
        <p class="prix" id="luxe">
          <span class="euro">23&euro;</span> 50
        </p>
        <p>par heure</p>
      </article>
      <article class="S&amp;P">
        <h3>Agent de S&eacute;curit&eacute; et pr&eacute;vention</h3>
        <p class="prix">
          <span class="euro">23&euro;</span> 50
        </p>
        <p>par heure</p>
      </article>
    </section>
  </div>
</template>

<script>
export default {}
</script>

<style scoped>
.main {
  width: 100%;
  margin-top: 80px;
}

p.presentation {
  text-align: center;
}

h1 {
  text-align: center;
}

section.un {
  margin-top: 50px;
  width: 100%;
  margin-bottom: 100px;
}

section.un article {
  flex-wrap: wrap;
  display: flex;
  width: 100%;
  height: 200px;
  justify-content: space-around;
}

section.un figure {
  width: 40%;
  display: flex;
}

section.un p {
  width: 80%;
  margin-left: 5%;
}

section.deux {
  width: 100%;
}

section.deux article {
  flex-wrap: wrap;
  display: flex;
  width: 100%;
  height: 200px;
  justify-content: space-around;
}

section.deux figure {
  width: 40%;
  display: flex;
}


section.deux p {
  width: 80%;
  margin-left: 5%;
}

img.resp3,
img.resp {
  height: 100%;
}

section.trois {
  margin-top: 50px;
  width: 100%;
  height: 300px;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  text-align: center;
}

section.trois article {
  border: 1px solid black;
  width: 25%;
}

section.trois article h3 {
  margin-top: 20px;
}

section.trois article p.prix {
  margin-top: 180px;
}

section.quatre {
  margin-top: 50px;
  width: 100%;
  height: 300px;

  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  text-align: center;
}

section.quatre article {
  border: 1px solid black;
  width: 25%;
}

section.quatre article h3 {
  margin-top: 20px;
}

section.quatre article p.prix {
  margin-top: 180px;
}

@media screen and (max-width: 1200px) {
.main {
  width: 100%;
  margin-top: 80px;
}

p.presentation {
  text-align: center;
}

h1 {
  text-align: center;
}

section.un {
  margin-top: 50px;
  width: 100%;
  margin-bottom: 100px;
}

section.un article {
  flex-wrap: wrap;
  display: flex;
  width: 100%;
  height: 300px;
  justify-content: space-around;
}

section.un figure {
  width: 40%;
  display: flex;
}


section.un p {
  width: 80%;
  margin-left: 5%;
}

section.deux {
  width: 100%;
}

section.deux article {
  flex-wrap: wrap;
  display: flex;
  width: 100%;
  height: 300px;
  justify-content: space-around;
}

section.deux figure {
  width: 40%;
  display: flex;
}


section.deux p {
  width: 80%;
  margin-left: 5%;
}

img.resp3,
img.resp {
  height: 50%;
}

section.trois {
  margin-top: 50px;
  width: 100%;
  height: 400px;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  text-align: center;
}

section.trois article {
  border: 1px solid black;
  width: 25%;
}

section.trois article h3 {
  margin-top: 20px;
}

section.trois article p.prix {
  margin-top: 180px;
}

section.quatre {
  margin-top: 50px;
  width: 100%;
  height: 400px;

  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  text-align: center;
}

section.quatre article {
  border: 1px solid black;
  width: 25%;
}

section.quatre article h3 {
  margin-top: 20px;
}

section.quatre article p.prix {
  margin-top: 180px;
}
}


@media screen and (max-width: 780px) {
.main {
  width: 100%;
  margin-top: 80px;
}

p.presentation {
  text-align: center;
}

h1 {
  text-align: center;
}

section.un {
  margin-top: 50px;
  width: 100%;
  margin-bottom: 150px
}

section.un article {
  display: block;
  width: 100%;
}

section.un figure {
  display: flex;
  width: 100%;
}

section.un p {
  width: 100%;
  margin-left: 5%;
}

section.deux {
  width: 100%;
}

section.deux article {
  display: block;
  width: 100%;
  height: 300px;
}

section.deux figure {
  width: 100%;
  display: flex;
}

section.deux p {
  margin-left: 5%;
}
img.resp3,
img.resp {
  height: 5%;
}
img.resp3 {
  width: 200px;
}

p.biens {
  width: 100% !important;
}
section.trois {
  margin-top: 200px;
  width: 100%;
  height: 400px;
  display: flex;
  text-align: center;
}

section.trois article {
  border: 1px solid black;
  width: 33%;
}

section.trois article h3 {
  margin-top: 20px;
  text-align: center;
  font-size: 20px;
}

section.trois article p.prix {
  margin-top: 180px;
}
section.trois article p#prix{
  margin-top: 156px;
}

section.quatre {
  margin-top: 50px;
  width: 100%;
  height: 400px;
  display: flex;
  text-align: center;
}

section.quatre article {
  border: 1px solid black;
  width: 33%;
}

section.quatre article h3 {
  margin-top: 20px;
    font-size: 20px;
}

section.quatre article p.prix {
  margin-top: 180px;
}
section.quatre article p#luxe {
  margin-top: 203px;
}
}
</style>

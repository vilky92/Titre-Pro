<template>
  <div id="contact">
    <iframe
      src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d10501.770135793022!2d2.2768305!3d48.8497712!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xde0c144a285ee0c5!2zQ0ogU8OpY3VyaXTDqSBQcml2w6ll!5e0!3m2!1sfr!2sfr!4v1547463610185"
      width="600"
      height="450"
      frameborder="0"
      style="border:0"
      allowfullscreen
    ></iframe>
    <figure class="reseau">
      <a href class="face">
        <img src="@/assets/images/facebook.png" alt>
      </a>
      <a href class="insta">
        <img src="@/assets/images/instagram.png" alt>
      </a>
      <a href class="link">
        <img src="@/assets/images/linkedin.png" alt>
      </a>
      <a href class="twit">
        <img src="@/assets/images/twitter.png" alt>
      </a>
    </figure>
    <section class="cinq">
      <a href class="conf">Politique de confidentialit&eacute;</a>
      <a href class="cond">Condition d'utilisation</a>
      <p>&copy; 2019 CJ-S&eacute;curit&eacute;</p>
    </section>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
#contact{
    margin-top: 50px;
    width: 100%;
    background: black;
    }
    iframe{
        margin-top: 50px;
        width: 60%;
        margin-left: 20%;
    }
    
    figure{
        margin-top: 20px;
        width: 100%;
        display: flex;
        flex-wrap: wrap;
        justify-content: space-around;
    }

     figure a {
        text-align: center;
        width: 5%;
    }
    
     figure a img{
        height: 75px;  
    }
    
    section.cinq{
        height: 50px;
        margin-top: 15px;
        display: flex;
        flex-wrap: wrap;
        justify-content: space-around;
        justify-items: center;
        align-items: center;
    }

     a,  p {
        color: white;
    }
</style>

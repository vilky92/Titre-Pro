import Vue from 'vue'
import VueMq from 'vue-mq'

Vue.use(VueMq, {
  breakpoints: {
    mobile: 450,
    tablet: 900,
    laptop: 1250,
    desktop: Infinity,
  }
})

new Vue({
    template: `
      <mobile-menu v-if="$mq === 'mobile'">
      </mobile-menu>
    `,
  })

  new Vue({
    template: `
      <mq-layout mq="mobile">
        <mobile-menu></mobile-menu>
      </mq-layout>
      <mq-layout mq="tablet+">
        <desktop-menu></desktop-menu>
      </mq-layout>
    `,
  })

  new Vue({
    template: `
      <grid-component :column="$mq | mq({
        phone: 1,
        tablet: 2,
        laptop: 3
      })">
      </grid-component>
    `,
  })
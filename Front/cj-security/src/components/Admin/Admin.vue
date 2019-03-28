<template>
  <div>
    <table>
      <thead>
        <tr>
          <th v-for="(prop, p) in usersProp" :key="p">{{prop}}</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(prop, p) in users" :key="p">
          <td v-for="(user, n) in prop" :key="n">{{user}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from "axios";
export default {
  computed: {
        usersProp() {
      return this.users[0] ? Object.keys(this.users[0]) : [];
    }
  },

  mounted() {
          axios
        .get("user/get/all")
        .then(res => {
          this.users = res.data;
        })
        .catch(err => {
          console.error("error ", err);
        });
  },
  data() {
    return {
      users : [],
      user : {},
    }
  },

}
</script>

<style scoped>
table {
  border-collapse: collapse;
  margin-left: 70px;
  text-align: center;
  }

td, th {
  border: solid 2px black;
  border-radius: 6px;
  background-color: white;
  width: 270px;
  height: 55px;
  color: black;
  align-items: center;
  font-weight: 600;
  text-transform: uppercase;
}

tr {
  background-color: #ffffff;
}
</style>

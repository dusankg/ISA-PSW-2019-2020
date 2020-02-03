<template>
  <div>
      <h1>Doctor home page</h1>
      <ul>  
        <li><router-link to="/patients">List of patients</router-link></li>        
        <li><router-link to="/diagnosis">Diagnosis</router-link></li>
        <li><router-link to="/addabsencerequest/id">Create new absence request</router-link></li>
        <li><router-link :to="{name: 'editdoctor', params: { id: this.id }}">See personal profile</router-link></li>
        <li><router-link to="/addexamination">Schedule new examination</router-link></li>
      </ul>
  </div>
</template>

<script>
export default {
    computed: {
      id() {
        return this.$route.params.id;
      }
    }
}
</script>

<style>
/*Navigation bar*/
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: rgb(29, 168, 64);
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: rgb(10, 78, 14);
  text-decoration: none;
  color: white;
}

</style>
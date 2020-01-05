<template>
  <div>
      <h1>Doctor home page</h1>
      <p><button @click="()=>$router.push('/examinations')"> View and manage examinations  </button></p>
      <p><button @click="()=>$router.push('/diagnosis')"> View and manage diagnosis  </button></p>
      <p><button @click="()=>$router.push('/medicalrooms')"> View and manage medical rooms  </button></p>
      <p><button @click="()=>$router.push('/patients')"> View and manage patients  </button></p>
      <p><button @click="()=>$router.push('/addabsencerequest/id')"> Create new absence request  </button></p>
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

</style>
<template>
  <div>
      <h1>Doctor home page</h1>
      <p><button @click="()=>$router.push('/examinations')"> View and manage examinations  </button></p>
      <p><button @click="()=>$router.push('/diagnosis')"> View and manage diagnosis  </button></p>
      <p><button @click="()=>$router.push('/medicalrooms')"> View and manage medical rooms  </button></p>
      <p><button @click="()=>$router.push('/patients')"> View and manage patients  </button></p>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>
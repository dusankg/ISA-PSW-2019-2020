<template>
    <div>
        <h1>List of Rooms</h1>
        <ListMedicalRoomsComponent></ListMedicalRoomsComponent>
    </div>
</template>

<script>
import ListMedicalRoomsComponent from "./ListMedicalRoomsComponent";
export default {
    name:"MedicalRoomApp",
    components: {
        ListMedicalRoomsComponent
    }
}
</script>

<style scoped>

</style>
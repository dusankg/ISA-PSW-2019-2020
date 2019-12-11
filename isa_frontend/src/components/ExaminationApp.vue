<template>
    <div>
        <h1>Examinations list</h1>
        <ListExaminationsComponent></ListExaminationsComponent>
    </div>
</template>

<script>
    import ListExaminationsComponent from "./ListExaminationsComponent";
    export default {
        name: "ExaminationApp",
        components: {
            ListExaminationsComponent
        }
    }
</script>
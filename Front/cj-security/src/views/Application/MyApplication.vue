<template>
<div class=appli>
    <GetApplication/>
    <UpdateApplication/>
    <DeleteApplication/>
</div>
</template>

<script>
import GetApplication from '@/components/Application/GetApplication.vue';
import UpdateApplication from '@/components/Application/UpdateApplication.vue';
import DeleteApplication from '@/components/Application/DeleteApplication.vue';

export default {
components: {
    GetApplication,
    UpdateApplication,
    DeleteApplication
}
}
</script>

<style scoped>
    .appli {
        width: 40%;
        margin-left: 50%;
    }
</style>

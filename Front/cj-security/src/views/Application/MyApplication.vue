<template>
<div>
    <h1>Je suis my application</h1>
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

<style>

</style>

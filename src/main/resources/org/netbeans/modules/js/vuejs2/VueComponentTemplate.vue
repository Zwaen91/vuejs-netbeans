<template>
    <div>
        <div v-text="msg"></div>
    </div>
</template>
<style>
    #msg {
        color: red;
    }
</style>
<script>
    export default {
        data() {
            return {
                msg: 'hello vue'
            }
        }
    }
</script>
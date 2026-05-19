<script setup>
const test = () => {
  console.log(import.meta.env.MODE, import.meta.env.VITE_API_URL)
};

</script>

<template>
  <h1 class="tw:text-primary">You did it!</h1>
  <q-btn color="accent" label="abc" @click="test" />
  <p>
    Visit <a href="https://vuejs.org/" target="_blank" rel="noopener">vuejs.org</a> to read the
    documentation
  </p>
</template>

<style scoped></style>

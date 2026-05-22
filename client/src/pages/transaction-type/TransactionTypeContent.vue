<script setup>
import { ref } from 'vue';
import TableTemplate from 'components/TableTemplate.vue';

// 1) =============== INITIALIZATION   ===============
const COLUMNS = [
  { name: 'id', field: 'id', label: 'ID', align: 'center' },
  { name: 'name', field: 'name', label: 'Name', align: 'center' },
  { name: 'color', field: 'color', label: 'Color', align: 'center' },
];

// 2) =============== VARIABLE REF     ===============
const rows = ref([
  { id: 1 },
  { id: 2 },
]);
const rowSelected = ref([]);

// 3) =============== METHOD/FUNCTION  ===============
// 4) =============== VUE JS LIFECYCLE ===============
</script>

<template>
  <div class="table-template">
    <table-template :columns="COLUMNS" :rows="rows" check-field="id" v-model:check-selected="rowSelected"
      max-height="200px" />
  </div>

  <div class="common-box">
    <div class="box-title">abc</div>
    <div class="box-content">abc</div>
  </div>
</template>

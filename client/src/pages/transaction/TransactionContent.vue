<script setup>
import { ref } from 'vue';
import dialog from 'utilities/dialog';
import TableTemplate from 'components/TableTemplate.vue';
import TransactionAdd from 'pages/transaction/TransactionAdd.vue';

// 1) =============== INITIALIZATION   ===============
const COLUMNS = [
  { name: 'id', field: 'id', label: '#', align: 'center' },
  { name: 'category', field: 'category', label: 'Category', align: 'center' },
  { name: 'type', field: 'type', label: 'Loại', align: 'center' },
  { name: 'transactionDate', field: 'transactionDate', label: 'Ngày thực hiện', align: 'center' },
  { name: 'Note', field: 'Note', label: 'Ghi chú', align: 'center' },
  { name: 'amountLabel', field: 'amountLabel', label: 'Số tiền', align: 'center' },
];

// 2) =============== VARIABLE REF     ===============
const transactionData = ref([
  { id: 1, categoryId: 1, type: 1, transactionDate: '2026/11/11', note: 'Ăn trưa đây mà' },
]);

// 3) =============== METHOD/FUNCTION  ===============
const openAddDialog = (item = {}) => {
  dialog.showContent('', TransactionAdd, { params: { transaction: item } });
};

// 4) =============== VUE JS LIFECYCLE ===============
</script>

<template>
  <div class="tw:max-w-250">
    <div class="flex tw:space-x-5">
      <q-space />
      <div><q-btn no-caps label="Thêm" icon="add" color="lime-1" @click="openAddDialog" /></div>

    </div>
    <table-template :columns="COLUMNS" :rows="transactionData" class="tw:mt-5" />
    <div>abc</div>
  </div>
</template>

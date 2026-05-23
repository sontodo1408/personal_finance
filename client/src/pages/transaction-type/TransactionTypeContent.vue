<script setup>
import { onMounted, ref } from 'vue';
import TableTemplate from 'components/TableTemplate.vue';

// 1) =============== INITIALIZATION   ===============
const COLUMNS = [
  { name: 'id', field: 'id', label: 'ID', align: 'center' },
  { name: 'name', field: 'name', label: 'Tên loại', align: 'center' },
  { name: 'colorIcon', field: 'colorIcon', label: 'Màu đại diện', align: 'center', isIcon: true, cellBind: { class: 'tw:text-center tw:text-lg' } },
  { name: 'preview', field: 'preview', label: 'Xem trước', align: 'center', isChip: true },
];

// 2) =============== VARIABLE REF     ===============
const transactionTypes = ref([
  { id: 1, name: 'Giải trí', color: '#ff0000' },
  { id: 2, name: 'Sinh hoạt', color: '#ff0000' },
]);

const tableRowSelected = ref([]);

// 3) =============== METHOD/FUNCTION  ===============
const convertTypeItem = (item) => ({
  ...item,
  colorIcon: { name: 'circle', style: { color: item.color } },
  preview: { label: item.name, chipBind: { style: { background: item.color, color: 'white' }, size: 'sm' } },
});

// 4) =============== VUE JS LIFECYCLE ===============
onMounted(() => {
  transactionTypes.value = transactionTypes.value.map(convertTypeItem);
});
</script>

<template>
  <div class="tw:max-w-250">
    <div class="flex tw:space-x-5">
      <q-space />
      <div><q-btn no-caps color="lime-1" label="Thêm mới" icon="add" /></div>
      <div><q-btn no-caps color="lime-1" label="Sử dụng mẫu đã có" icon="add" /></div>
      <div><q-btn no-caps color="negative" label="Xóa" icon="delete" /></div>
    </div>

    <table-template :columns="COLUMNS" :rows="transactionTypes" class="tw:mt-5" check-field="id"
      v-model:check-selected="tableRowSelected" />
  </div>
</template>

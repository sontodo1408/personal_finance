<script setup>
import { onMounted, ref } from 'vue';
import dialog from 'utilities/dialog';
import TableTemplate from 'components/TableTemplate.vue';
import CategoryAdd from 'pages/category/CategoryAdd.vue';
import { getMoneyLabel } from '@/utilities/common';

// 1) =============== INITIALIZATION   ===============
const COLUMNS = [
  { name: 'id', field: 'id', label: 'ID', align: 'center' },
  { name: 'name', field: 'name', label: 'Tên loại', align: 'center' },
  { name: 'colorIcon', field: 'colorIcon', label: 'Màu đại diện', align: 'center', isIcon: true, cellBind: { class: 'tw:text-center tw:text-lg' } },
  { name: 'preview', field: 'preview', label: 'Xem trước', align: 'center', isChip: true },
  { name: 'maxAmountLabel', field: 'maxAmountLabel', label: 'Số tiền DĐ', align: 'center' },
];

// 2) =============== VARIABLE REF     ===============
const categoryData = ref([
  { id: 1, name: 'Giải trí', color: '#ff0000', maxAmount: 10000000 },
  { id: 2, name: 'Sinh hoạt', color: '#ff0000', maxAmount: 10000000 },
]);

const tableRowSelected = ref([]);

// 3) =============== METHOD/FUNCTION  ===============
const convertCategory = (item) => ({
  ...item,
  colorIcon: { name: 'circle', style: { color: item.color } },
  preview: { label: item.name, chipBind: { style: { background: item.color, color: 'white' }, size: 'sm' } },
  maxAmountLabel: getMoneyLabel(item.maxAmount),
});

const updateCategory = async (item = {}) => {
  const result = await dialog.showContent('', CategoryAdd, { params: { category: item } });
  console.log(result);
};

// 4) =============== VUE JS LIFECYCLE ===============
onMounted(() => {
  categoryData.value = categoryData.value.map(convertCategory);
});
</script>

<template>
  <div class="tw:max-w-250">
    <div class="flex tw:space-x-5">
      <q-space />
      <div><q-btn no-caps color="lime-1" label="Thêm mới" icon="add" @click="updateCategory" /></div>
      <div><q-btn no-caps color="lime-1" label="Sử dụng mẫu đã có" icon="add" disable /></div>
      <div><q-btn no-caps color="negative" label="Xóa" icon="delete" :disable="tableRowSelected.length === 0" /></div>
    </div>

    <table-template :columns="COLUMNS" :rows="categoryData" class="tw:mt-5" check-field="id"
      v-model:check-selected="tableRowSelected" :row-click="updateCategory" />
  </div>
</template>

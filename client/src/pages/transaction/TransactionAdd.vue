<script setup>
import { onMounted, ref, watch } from 'vue';
import { E_TRANSACTION_TYPE } from '@/helpers/enums';
import { clone } from '@/utilities/common';
import dayjs from '@/utilities/day';

// 1) =============== INITIALIZATION   ===============
/** 
 * component property 
 * transaction: transaction data
 */
const props = defineProps({
  transaction: Object
});

/** component emits */
const emits = defineEmits(['done']);

/** 
 * initial data
 * it was used when create new transaction 
 */
const initialData = {
  type: E_TRANSACTION_TYPE.E.OUTCOME,
  transactionDate: dayjs().format('YYYY/MM/DD'),
};

// 2) =============== VARIABLE REF     ===============
/** check component have already mounted or not */
const componentReady = ref(false);

const categories = ref([
  { id: 1, name: 'Giải trí', color: '#ff0000', maxAmount: 10000000 },
  { id: 2, name: 'Sinh hoạt', color: '#ff0000', maxAmount: 10000000 },
  { id: 3, name: 'Sinh hoạt', color: '#ff0000', maxAmount: 10000000 },
  { id: 4, name: 'Sinh hoạt', color: '#ff0000', maxAmount: 10000000 },
  { id: 5, name: 'Sinh hoạt', color: '#ff0000', maxAmount: 10000000 },
]);

const transactionData = ref(initialData);

// 3) =============== METHOD/FUNCTION  ===============
const getCategoryStyle = (item) => ({
  cursor: 'pointer',
  color: 'white',
  backgroundColor: item.id === transactionData.value.categoryId ? item.color : 'grey',
});

const clickCategoryItem = (item) => {
  transactionData.value.categoryId = item.id;
};

const submit = () => {
  emits('done', transactionData.value);
};

// 4) =============== VUE JS LIFECYCLE ===============
watch(() => props.transaction, () => {
  if (componentReady.value) {
    transactionData.value = clone(props.transaction, initialData);
  }
});

onMounted(() => {
  transactionData.value = clone(props.transaction, initialData);
  componentReady.value = true;
});

</script>

<template>
  <div class="dialog-header">Thêm mục chi tiêu</div>
  <div class="dialog-content">

    <div class="flex">
      <div class="tw:w-28 tw:translate-y-1.5">Category: </div>
      <div class="flex tw:flex-wrap tw:max-w-100">
        <div v-for="item in categories" :key="item.id">
          <q-chip clickable :style="getCategoryStyle(item)" @click="clickCategoryItem(item)">{{ item.name }}</q-chip>
        </div>
      </div>
    </div>

    <div class="flex items-center tw:mt-4">
      <div class="tw:w-28">Thu / Chi:</div>
      <q-radio v-model="transactionData.type" color="positive" :val="E_TRANSACTION_TYPE.E.INCOME"
        :label="E_TRANSACTION_TYPE.L[E_TRANSACTION_TYPE.E.INCOME]" />
      <q-radio v-model="transactionData.type" color="negative" :val="E_TRANSACTION_TYPE.E.OUTCOME"
        :label="E_TRANSACTION_TYPE.L[E_TRANSACTION_TYPE.E.OUTCOME]" />
    </div>

    <div class="flex items-center tw:mt-4">
      <div class="tw:w-28">Số tiền: </div>
      <q-input dense outlined v-model="transactionData.amount" class="tw:w-50" />
    </div>

    <div class="flex items-center tw:mt-4">
      <div class="tw:w-28">Ngày thực hiện:</div>
      <c-date-picker v-model="transactionData.transactionDate" class="tw:w-50" />
    </div>
  </div>
  <q-card-section class="dialog-btn-container">
    <c-btn outline label="Đóng" v-close-popup />
    <c-btn label="Lưu" @click="submit" />
  </q-card-section>
</template>

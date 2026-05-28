<script setup>
import { onMounted, ref, watch } from 'vue';
import { clone } from 'utilities/common';

// 1) =============== INITIALIZATION   ===============
const props = defineProps({
  category: Object,
});
const emits = defineEmits(['done']);

// 2) =============== VARIABLE REF     ===============
const componentReady = ref(false);
const dataShow = ref({});

// 3) =============== METHOD/FUNCTION  ===============
const submit = () => {
  emits('done', true);
}
// 4) =============== VUE JS LIFECYCLE ===============
watch(() => props.category, (v) => {
  if (!componentReady.value) { return; }
  dataShow.value = clone(v);
});

onMounted(() => {
  dataShow.value = clone(props.category) || {};
  componentReady.value = true;
});
</script>

<template>
  <div class="dialog-header">{{ category?.id ? 'Sửa loại thu chi' : 'Thêm mới loại thu chi' }}</div>
  <div class="dialog-content">
    <div class="flex items-center">
      <div class="tw:w-32">Tên loại thu chi: </div>
      <q-input dense outlined v-model="dataShow.name" class="tw:flex-1" />
    </div>
    <div class="flex items-center tw:mt-5">
      <div class="tw:w-32">Số tiền dự định: </div>
      <q-input mask="###,###,###" reverse-fill-mask dense outlined v-model="dataShow.maxAmount" class="tw:flex-1">
        <template #append>
          <span class="tw:text-sm">VNĐ</span>
        </template>
      </q-input>
    </div>
    <div class="flex tw:mt-5">
      <div class="tw:w-32">
        <div>Màu đại diện: </div>
        <q-icon name="circle" size="xl" :style="{ color: dataShow.color }" class="tw:translate-x-5 tw:mt-3" />
      </div>
      <q-color name="ty-color" v-model="dataShow.color" no-header-tabs format-model="hex" class="tw:w-60" />
    </div>
  </div>
  <q-card-section class="dialog-btn-container">
    <q-btn no-caps outline label="Đóng" color="lime-1" v-close-popup />
    <q-btn no-caps label="Lưu" color="lime-1" @click="submit" />
  </q-card-section>
</template>

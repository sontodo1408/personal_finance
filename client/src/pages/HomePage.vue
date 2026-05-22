<script setup>
import { ref, reactive, computed } from 'vue';
import { GridLayout, GridItem } from 'grid-layout-plus'

// 1) =============== INITIALIZATION   ===============
const pageContainer = ref(null);

// 2) =============== VARIABLE REF     ===============
const rowHeight = computed(() => {
  return ((pageContainer.value?.offsetHeight || 0)) / 8;
});

const layout = reactive([
  { x: 0, y: 0, w: 2, h: 2, i: '0' },
  { x: 0, y: 0, w: 2, h: 4, i: '1' }
]);
// 3) =============== METHOD/FUNCTION  ===============
// 4) =============== VUE JS LIFECYCLE ===============
</script>

<template>
  <q-page class="fit column tw:p-4">
    <div class="tw:flex-1 tw:relative" ref="pageContainer">
      <div class="background-main"></div>
      <GridLayout :vertical-compact="false" :margin="[0, 0]" v-model:layout="layout" :col-num="12"
        :row-height="rowHeight" :max-rows="8" :is-draggable="true" :is-resizable="true" class="tw:h-full">
        <GridItem v-for="item in layout" :key="item.i" v-bind="item" class="tw:p-1">
          <div class="tw:bg-white tw:h-full! tw:rounded-md"></div>
        </GridItem>
      </GridLayout>
    </div>
  </q-page>
</template>

<style scoped lang="scss">
.background-main {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  height: 100%;

  background-image:
    linear-gradient(to right, #d1d5db 1px, transparent 1px),
    linear-gradient(to bottom, #d1d5db 1px, transparent 1px);

  background-size:
    calc(100% / 12) calc(100% / 8);

  box-shadow:
    inset -1px 0 0 #d1d5db,
    inset 0 -1px 0 #d1d5db;
}
</style>

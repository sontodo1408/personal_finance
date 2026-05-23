<script setup>
import { ref } from 'vue';
import draggable from 'vuedraggable';

// 1) =============== INITIALIZATION   ===============
// 2) =============== VARIABLE REF     ===============
const commonTypes = ref([
  { uuid: '1', id: 1, name: 'Tiền sinh hoạt', color: '#ff0000' },
  { uuid: '2', id: 1, name: 'Tiền trọ', color: '#ff0000' },
  { uuid: '3', id: 1, name: 'Tiền giải trí', color: '#ff0000' },
]);
const ownType = ref([
  { uuid: '4', id: null, name: 'Tiền A', color: '#ff0000' },
  { uuid: '5', id: null, name: 'Tiền B', color: '#ff0000' },
  { uuid: '6', id: null, name: 'Tiền C', color: '#ff0000' },
]);

// 3) =============== METHOD/FUNCTION  ===============
// 4) =============== VUE JS LIFECYCLE ===============
</script>

<template>
  <div class="c-draggable">
    <div class="common-box">
      <div class="box-title">Loại chi tiêu chung</div>
      <div class="box-content">
        <draggable v-model="commonTypes" group="shared" item-key="id" :animation="200"
          easing="cubic-bezier(0.2, 0, 0, 1)" ghost-class="ghost" chosen-class="chosen" drag-class="drag">
          <template #item="{ element }">
            <div class="cd-item">
              {{ element.name }}
            </div>
          </template>
        </draggable>
      </div>
    </div>

    <div class="common-box">
      <div class="box-title">Loại chi tiêu của tôi</div>
      <div class="box-content">
        <draggable v-model="ownType" group="shared" item-key="id" :animation="200" easing="cubic-bezier(0.2, 0, 0, 1)"
          ghost-class="ghost" chosen-class="chosen" drag-class="drag">
          <template #item="{ element }">
            <div class="cd-item">
              {{ element.name }}
            </div>
          </template>
        </draggable>
      </div>
    </div>
  </div>
</template>

<style scoped lang="scss">
.c-draggable {
  display: flex;
  gap: 20px;

  .box-content {
    min-width: 300px;
    overflow: hidden;

    .cd-item {
      display: flex;
      align-items: center;
      padding: 5px 10px;
    }
  }
}
</style>

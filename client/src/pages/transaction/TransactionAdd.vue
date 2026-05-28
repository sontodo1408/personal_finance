<script setup>
// 1) =============== INITIALIZATION   ===============
// 2) =============== VARIABLE REF     ===============
// 3) =============== METHOD/FUNCTION  ===============
// 4) =============== VUE JS LIFECYCLE ===============
</script>

<template>
  <div class="dialog-header">Thêm mục chi tiêu</div>
  <div class="dialog-content">
    <div>
      <div>Category: </div>
      <c-select />
    </div>
  </div>
  <q-card-section class="dialog-btn-container">
    <q-btn no-caps outline label="Đóng" color="lime-1" />
    <q-btn no-caps label="Lưu" color="lime-1" />
  </q-card-section>
</template>

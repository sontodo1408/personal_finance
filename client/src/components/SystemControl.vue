<script setup>
import { reactive, computed } from 'vue';

import dialog from 'utilities/dialog';
import logo_o from 'assets/imgs/logo_o.png';

// 1) =============== INITIALIZATION   ===============
// 2) =============== VARIABLE REF     ===============
/** current position of dialog */
const dialogPosition = reactive({
  x: 0,
  y: 0,
});
/** style after drag */
const draggableStyle = computed(() => ({ transform: `translate(${dialogPosition.x}px, ${dialogPosition.y}px)` }));

// 3) =============== METHOD/FUNCTION  ===============
/** change position when drag */
const onPan = (evt) => {
  dialogPosition.x += evt.delta.x;
  dialogPosition.y += evt.delta.y;
};

/** show warning */
const warning = () => {
  dialog.showConfirm('Title', 'Content');
};

// 4) =============== VUE JS LIFECYCLE ===============
</script>

<template>
  <q-dialog :model-value="true" seamless>
    <q-fab padding="10px" direction="down" color="lime-4" v-touch-pan.mouse="onPan" :style="draggableStyle"
      class="tw:absolute tw:right-[calc(50vw-250px)] tw:bottom-[calc(50vh-25px)]">
      <template #icon>
        <q-img :src="logo_o" sizes="100" />
      </template>
      <template #active-icon>
        <q-img :src="logo_o" sizes="100" />
      </template>

      <q-fab-action padding="5px" color="primary" external-label @click="warning" label-position="left">
        <template v-slot:icon>
          <q-icon name="mail" />
        </template>
        <template v-slot:label>
          Mail
        </template>
      </q-fab-action>
      <q-fab-action padding="5px" color="secondary" external-label icon="alarm" label="Alarm" label-position="left" />
    </q-fab>
  </q-dialog>
</template>

<style scoped lang="scss">
.q-dialog__inner>div {
  overflow: visible;
}
</style>
<script setup>
import { ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import { ROUTER_NAME } from 'helpers/const';

import logo_o from 'assets/imgs/logo_o.png';

// 1) =============== INITIALIZATION   ===============
const route = useRoute();
const router = useRouter();

const navItem = [
  { label: 'Dashboard', icon: 'add', selected: [ROUTER_NAME.HOME], to: ROUTER_NAME.HOME },
  { label: 'Category', icon: 'close', selected: [ROUTER_NAME.CATEGORY], to: ROUTER_NAME.CATEGORY },
  { label: 'Các mục chi tiêu', icon: 'close', selected: [ROUTER_NAME.TRANSACTION_ADD], to: ROUTER_NAME.TRANSACTION_ADD },
];

// 2) =============== VARIABLE REF     ===============
const leftDrawerOpen = ref(true);

// 3) =============== METHOD/FUNCTION  ===============
const toggleLeftDrawer = () => { leftDrawerOpen.value = !leftDrawerOpen.value; };

const navItemOnClick = (item) => {
  router.push({ name: item.to });
};

// 4) =============== VUE JS LIFECYCLE ===============
</script>

<template>
  <q-layout view="hHh Lpr lFf">
    <q-header elevated class="bg-white text-grey-8">
      <q-toolbar>
        <div class="tw:transition-all tw:duration-400" :class="leftDrawerOpen ? 'tw:rotate-180' : ''">
          <q-btn round flat icon="menu_open" @click="toggleLeftDrawer" />
        </div>
        <div class="tw:text-[28px] tw:ml-1 tw:text-lime-1 font-dancing">
          Quản lý thu chi
        </div>

        <q-space />

        <!-- <div class="tw:mx-3">{{ `${auth.ME.lastName} ${auth.ME.firstName}` }}</div> -->
        <q-btn round flat>
          <q-img :src="logo_o" alt="" width="25px" />
          <q-tooltip class="tw:whitespace-nowrap">SonToDo's Application</q-tooltip>
        </q-btn>
      </q-toolbar>
    </q-header>

    <q-drawer side="left" v-model="leftDrawerOpen" class="bg-lime-4">
      <q-list class="tw:mt-3">
        <div v-for="item in navItem" :key="item">
          <q-item class="nav-item" clickable :class="{ 'nav-selected': item.selected?.includes(route.name) }"
            @click="navItemOnClick(item)">
            <q-icon :name="item.icon" size="20px" class="tw:mr-5" color="lime-1" />
            <span class="nav-label">{{ item.label }}</span>
          </q-item>
        </div>
      </q-list>
    </q-drawer>

    <q-page-container class="tw:bg-lime-6">
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<style lang="scss" scoped>
// navigation
.nav-item {
  display: flex;
  align-items: center;

  .nav-label {
    font-size: 14px;
    color: $lime-1;
    font-weight: 600;
    transition: all .3s;
  }

  &:hover .nav-label {
    transform: translateX(10px);
  }
}

.nav-selected {
  background-color: $lime-6;
}
</style>
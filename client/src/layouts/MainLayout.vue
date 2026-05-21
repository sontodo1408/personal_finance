<script setup>
import { ref } from 'vue';

// 1) =============== INITIALIZATION   ===============
// 2) =============== VARIABLE REF     ===============
const leftDrawerOpen = ref(true);

// 3) =============== METHOD/FUNCTION  ===============
const toggleLeftDrawer = () => { leftDrawerOpen.value = !leftDrawerOpen.value; }
// 4) =============== VUE JS LIFECYCLE ===============
</script>

<template>
  <q-layout view="hHh Lpr lFf">
    <q-header elevated class="bg-white text-grey-8">
      <q-toolbar>
        <div class="tw:transition-all tw:duration-400" :class="leftDrawerOpen ? 'tw:rotate-180' : ''">
          <q-btn round flat icon="menu_open" @click="toggleLeftDrawer">
          </q-btn>
        </div>
        <div class="tw:text-[20px] tw:ml-2 tw:font-bold tw:text-lime-1">
          Quản lý thu chi
        </div>

        <q-space />

        <!-- <div class="tw:mx-3">{{ `${auth.ME.lastName} ${auth.ME.firstName}` }}</div> -->
        <q-btn round flat>
          <q-avatar size="30px">
            <img src="https://cdn.quasar.dev/img/boy-avatar.png" alt="">
          </q-avatar>
          <q-tooltip>Account</q-tooltip>

          <q-menu anchor="bottom right" self="top right">
            <q-list class="tw:w-[200px]">
              <q-item clickable v-close-popup class="flex items-center" @click="logout">
                <q-icon name="logout" size="20px" class="tw:mr-5" />
                <span>Đăng xuất</span>
              </q-item>
            </q-list>
          </q-menu>
        </q-btn>
      </q-toolbar>
    </q-header>

    <!-- <q-drawer side="left" v-model="leftDrawerOpen" class="bg-lime-1 text-white">
      <q-list class="tw:mt-3">
        <div v-for="item in navItem" :key="item" v-show="item.accept.includes(auth.ME.role)">
          <q-item class="nav-item" clickable :class="{ 'nav-selected': item.selected.includes(route.name) }"
            @click="router.push(item.to)" v-if="!item.isComponent">
            <q-icon :name="item.icon" size="24px" class="tw:mr-5" />
            <span class="nav-label">{{ item.label }}</span>
          </q-item>

          <component v-else :is="item.component" :nav-item="item" />
        </div>
      </q-list>
    </q-drawer> -->

    <q-page-container class="tw:bg-lime-6">
      <router-view />
    </q-page-container>
  </q-layout>
</template>

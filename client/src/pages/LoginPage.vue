<script setup>
import { reactive, ref } from 'vue';
// import { useRouter } from 'vue-router';

// 1) =============== INITIALIZATION   ===============
/** Router plugin */
// const router = useRouter();

// 2) =============== VARIABLE REF     ===============
/** Check show password or not */
const showPassword = ref(false);
/** Login data */
const formData = reactive({
  username: '',
  password: '',
});

// 3) =============== METHOD/FUNCTION  ===============
/** Login function */
const login = async () => {
  // await authService.login(formData);
  // if (router.currentRoute.value.name === ROUTER_NAMES.LOGIN) {
  //   router.push({ name: ROUTER_NAMES.INFO });
  //   return;
  // }
  // router.push({ name: router.currentRoute.value.name });
};

// 4) =============== VUE JS LIFECYCLE ===============
</script>

<template>
  <q-layout view="hHh LpR fff">
    <q-page-container>
      <q-page class="fit column">
        <div class="login-bg">
          <div class="form-box">
            <div class="tw:text-center q-pa-sm">
              <q-img src="assets/imgs/logo_o.png" spinner-color="primary" style="height: 50px; width: 50px" />
              <p class="tw:text-[30px] tw:text-primary-0">Quản lý thu chi</p>
            </div>
            <div class="tw:mt-2">
              <span class="tw:font-bold tw:text-sm tw:text-[#4B5C6B]">Mail</span>
              <q-input outlined v-model.trim="formData.username" autocomplete="off" maxlength="24">
                <template v-slot:prepend>
                  <q-icon name="person" />
                </template>
              </q-input>
            </div>
            <div class="tw:mt-2">
              <span class="tw:font-bold tw:text-sm tw:text-[#4B5C6B]">Password</span>
              <q-input outlined v-model="formData.password" autocomplete="off"
                :type="showPassword ? 'text' : 'password'" maxlength="16">
                <template v-slot:prepend>
                  <q-icon name="lock" />
                </template>
                <template v-slot:append>
                  <q-icon left :name="showPassword ? 'visibility_off' : 'visibility'"
                    @click="showPassword = !showPassword" />
                </template>
              </q-input>
            </div>
            <div class="text-center">
              <q-btn no-caps class="!t-w-full !t-h-12 tw:mt-5" color="primary" label="Login" size="md"
                @click="login()" />
            </div>
            <div class="row tw:mt-10"></div>
          </div>
        </div>
      </q-page>
    </q-page-container>
  </q-layout>
</template>
<style scoped lang="scss">
/* animation  */
@keyframes shadow {
  from {
    box-shadow: none;
    transform: translateY(20px);
  }

  to {
    transform: translateY(0);
    box-shadow: 8px 8px 15px $lime-2;
  }
}

.login-bg {
  flex: 1;
  background: linear-gradient(180deg, $lime-3, $lime-6);
  width: 100%;
  min-height: 100%;
  height: inherit;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 0 20px;
  overflow: hidden;
}

.form-box {
  position: relative;
  animation: shadow 0.5s ease;
  animation-fill-mode: forwards;
  border-radius: 8px;
  padding: 40px 20px 0 20px;
  background-color: #fff;
  width: 24rem;
}
</style>

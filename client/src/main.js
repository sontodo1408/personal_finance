import { createApp } from 'vue';
import { createPinia } from 'pinia';

import App from './App.vue';
import router from './router';

import { Quasar } from 'quasar';
import 'quasar/src/css/index.sass';
import '@quasar/extras/material-icons/material-icons.css';

import '@/assets/css/style.scss';
import '@/assets/css/tailwind.css';

import CBtn from '@/components/common/CBtn.vue';
import CSelect from '@/components/common/CSelect.vue';
import CDatePicker from '@/components/common/CDatePicker.vue';

const app = createApp(App);

app.use(createPinia());
app.use(router);
app.use(Quasar, {
  plugins: {},
});

app.component('CSelect', CSelect);
app.component('CDatePicker', CDatePicker);
app.component('CBtn', CBtn);

app.mount('#app');

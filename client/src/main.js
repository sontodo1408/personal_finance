import { createApp } from 'vue';
import { createPinia } from 'pinia';

import App from './App.vue';
import router from './router';

import { Quasar } from 'quasar';
import 'quasar/src/css/index.sass';
import '@quasar/extras/material-icons/material-icons.css';

import '@/assets/css/style.scss';
import '@/assets/css/tailwind.css';

import CSelect from 'components/common/CSelect.vue';

const app = createApp(App);

app.use(createPinia());
app.use(router);
app.use(Quasar, {
  plugins: {},
});

app.component('CSelect', CSelect);

app.mount('#app');

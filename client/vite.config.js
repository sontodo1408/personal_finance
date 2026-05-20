import { fileURLToPath, URL } from 'node:url';

import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';
import vueDevTools from 'vite-plugin-vue-devtools';
import { quasar, transformAssetUrls } from '@quasar/vite-plugin';
import tailwindcss from '@tailwindcss/vite';

// https://vite.dev/config/
export default defineConfig({
  plugins: [
    vue({
      template: { transformAssetUrls },
    }),
    quasar({
      sassVariables: '@/assets/css/quasar-variables.sass',
    }),
    tailwindcss(),
    vueDevTools(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
      assets: fileURLToPath(new URL('./src/assets', import.meta.url)),
      components: fileURLToPath(new URL('./src/components', import.meta.url)),
      helpers: fileURLToPath(new URL('./src/helpers', import.meta.url)),
      stores: fileURLToPath(new URL('./src/stores', import.meta.url)),
      pages: fileURLToPath(new URL('./src/pages', import.meta.url)),
      utilities: fileURLToPath(new URL('./src/utilities', import.meta.url)),
    },
  },
});

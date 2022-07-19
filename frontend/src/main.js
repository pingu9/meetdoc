import { createApp } from 'vue'
import App from './App.vue'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import index from './store/index.js';

createApp(App).use(index).mount('#app')

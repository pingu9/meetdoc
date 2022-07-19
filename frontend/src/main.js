import { createApp } from 'vue'
import App from './App.vue'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import index from './store/index.js';
import router from './routes/router.js';


createApp(App).use(index).use(router).mount('#app')

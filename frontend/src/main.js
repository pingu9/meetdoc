import { createApp } from 'vue'
import App from './App.vue'
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap"
import index from './store/index.js';
import router from './routes/router.js';


createApp(App).use(index).use(router).mount('#app')

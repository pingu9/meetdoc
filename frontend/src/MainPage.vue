<template>
  <div>
    <div>
    <Header/>
    </div>
    <div>
    <router-view></router-view>
    </div>
    <div>
    <Footer/>
    </div>
    <LoginDialog/>
  </div>
</template>

<script>
import Footer from './components/MainFooter.vue';
import Header from './components/MainHeader.vue';
import LoginDialog from './components/LoginDialog.vue';

export default {
  components:{
    Footer,
    Header,
    LoginDialog,
  },
  data () {
    return {
    }
  },
}
</script>

<style>

</style>
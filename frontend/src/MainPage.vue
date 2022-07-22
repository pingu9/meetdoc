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
    <SignUpDialog/>
  </div>
</template>

<script>
import Footer from './components/MainFooter.vue';
import Header from './components/MainHeader.vue';
import LoginDialog from './components/LoginDialog.vue';
import SignUpDialog from './components/SignUpDialog.vue';

export default {
  components:{
    Footer,
    Header,
    LoginDialog,
    SignUpDialog,
  },
  data () {
    return {
    }
  },
}
</script>

<style>
@import './common/css/common.css';

</style>
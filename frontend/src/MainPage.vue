<template>
  <div>
    <div>
    <Header @openLoginDialog="onOpenLoginDialog"/>
    </div>
    <div>
    <router-view></router-view>
    </div>
    <div>
    <Footer/>
    </div>
    <LoginDialog
    :open="loginDialogOpen"/>
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
      loginDialogOpen: false,
      signupDialogOpen: false,
    }
  },
  methods: {
    onOpenLoginDialog () {
      this.loginDialogOpen = true
    },
    onCloseLoginDialog () {
      this.loginDialogOpen = false
    },
    onOpenSignupDialog () {
      this.signupDialogOpen = true
    },
    onCloseSignupDialog () {
      this.signupDialogOpen = false
    }
  }
}
</script>

<style>

</style>
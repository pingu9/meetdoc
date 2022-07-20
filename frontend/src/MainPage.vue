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
  </div>
</template>

<script>
import Footer from './components/MainFooter.vue';
import Header from './components/MainHeader.vue';

export default {
  components:{
    Footer,
    Header,
  }
}
</script>

<style>

</style>
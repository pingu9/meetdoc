<template>
  <div>
    <h4>MyPage</h4>
    <div class="shadow-sm p-3 bg-body rounded w-25 p-3" style="margin:15px">아이디 : {{user1.user_id}}</div>
    <div class="shadow-sm p-3 bg-body rounded w-25 p-3" style="margin:15px">이름 : {{user1.name}}</div>
    <div class="shadow-sm p-3 bg-body rounded w-25 p-3" style="margin:15px">성별 : {{user1.gender}}</div>
    <div class="shadow-sm p-3 bg-body rounded w-25 p-3" style="margin:15px">생년월일 : {{user1.birthdate}}</div>

  </div>
  
</template>

<script>
import { mapState } from 'vuex'

export default {

  computed: {
    ...mapState(['user1']),
  }
}
</script>

<style>

</style>
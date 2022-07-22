<template>
  <div>
    <h4>MyPage</h4>
    <div class="shadow-sm p-3 bg-body rounded w-25 p-3" style="margin:15px">아이디 : {{user1.user_id}}</div>
    <div class="shadow-sm p-3 bg-body rounded w-25 p-3" style="margin:15px">이름 : {{user1.name}}</div>
    <div class="shadow-sm p-3 bg-body rounded w-25 p-3" style="margin:15px">성별 : {{user1.gender}}</div>
    <div class="shadow-sm p-3 bg-body rounded w-25 p-3" style="margin:15px">생년월일 : {{user1.birthdate}}</div>
    <div class="shadow-sm p-3 bg-body rounded w-25 p-3" style="margin:15px">주소 : {{user1.address}}</div>
    <div class="shadow-sm p-3 bg-body rounded w-25 p-3" style="margin:15px">연락처 번호 : {{user1.phone}}</div>
    <div class="shadow-sm p-3 bg-body rounded w-25 p-3" style="margin:15px">e-mail : {{user1.email}}</div>
    <div>
      <button type="button" class="btn btn-outline-primary m-5">회원정보 수정</button>
      <button type="button" class="btn btn-outline-warning">회원탈퇴</button>
    </div>
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
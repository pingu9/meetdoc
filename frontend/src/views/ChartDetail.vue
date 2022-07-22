<template>
<div class="container-body">
    <h1>진료 상세내역</h1>
    <h3>환자명 : {{chartDetail.userName}}</h3>
    <h4>환자 증상</h4>
    <p>웅 여기도 아프고 저기도 아프고</p>
    <div class="h4">
        <label for="exampleFormControlTextarea1" class="form-label">처방전</label>
        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
    </div>
</div>
</template>

<script>
import { mapState } from 'vuex'
export default {
    computed: {
        ...mapState(['chartDetail']),
    }
}
</script>

<style>

h3{
    text-align: right;
    margin: 10px;
}
</style>
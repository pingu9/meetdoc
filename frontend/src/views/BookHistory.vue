<template>
  <div>
    <h1>Reservation List</h1>
    <div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">원격진료 입장 가능</h5>
    <h6 class="card-subtitle mb-2 text-muted">환자 님</h6>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <div class="d-grid gap-2">
    <button class="btn btn-primary" type="button" a href="#">진료실 입장하기</button>
    </div>
  </div>
</div>
<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">원격진료 입장 불가</h5>
    <h6 class="card-subtitle mb-2 text-muted">환자 님</h6>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <div class="d-grid gap-2">
    <button class="btn btn-danger" type="button" a href="#">진료 대기중</button>
    </div>
  </div>
</div>
<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">진료 완료</h5>
    <h6 class="card-subtitle mb-2 text-muted">환자 님</h6>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <div class="d-grid gap-2">
    <button class="btn btn-secondary" type="button" a href="#">진료 완료</button>
    </div>
  </div>
</div>
  </div>
</template>

<script>
export default {

}
</script>

<style>

h1{
  text-align: center;
  margin: 20px;
}
.card{
  margin:auto;
  display: block;
  }

  .card-title{
    font-weight: bold;
  }
</style>
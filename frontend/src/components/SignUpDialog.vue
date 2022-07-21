<template>
  <div class="modal fade" id="signupModalToggle" aria-hidden="true" aria-labelledby="signupModalToggleLabel" tabindex="-1">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="signupModalToggleLabel">회원가입</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="form-floating mb-3">
        <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
        <label for="floatingInput">Email address</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
        <label for="floatingPassword">Password</label>
      </div>
      <div class="modal-footer">
        <button class="btn btn-primary" data-bs-target="#signupModalToggle2" data-bs-toggle="modal">Open second modal</button>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="signupModalToggle2" aria-hidden="true" aria-labelledby="signupModalToggleLabel2" tabindex="-1">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="signupModalToggleLabel2">Modal 2</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        Hide this modal and show the first with the button below.
      </div>
      <div class="modal-footer">
        <button class="btn btn-primary" data-bs-target="#signupModalToggle2" data-bs-toggle="modal">Back to first</button>
      </div>
    </div>
  </div>
</div>
<!-- <a class="btn btn-primary" data-bs-toggle="modal" href="#signupModalToggle" role="button">Open first modal</a> -->
</template>

<script>
export default {

}
</script>

<style>

</style>
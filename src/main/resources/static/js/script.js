const signUpButton = document.getElementById('signUp');
const signIpButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', ()=> {
  container.classList.add("right-panel-active");
});

signIpButton.addEventListener('click', () => {
  container.classList.remove("right-panel-active");
});
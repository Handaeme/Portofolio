// Toggle class active
const navbarnav = document.querySelector(".navbar-nav");
// Ketika hamburger menu diclick
document.querySelector("#hamburger-menu").onclick = () => {
  navbarnav.classList.toggle("active");
};

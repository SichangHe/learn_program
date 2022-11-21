window.onload = init;
function init() {
    var canvas = document.querySelector("canvas");
    var ctx = canvas.getContext("2d");
    ctx.fillStyle = "red";
    ctx.fillRect(0, 0, 100, 100);
    ctx.fillStyle = "blue";
    ctx.fillRect(25, 25, 50, 50);
}

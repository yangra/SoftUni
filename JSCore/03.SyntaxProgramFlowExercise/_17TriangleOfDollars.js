function drawTriangle(n){
    for (let i = 1; i <= n; i++) {
        console.log('$'.repeat(i));
    }
}


function draw(n) {
    for (let i = 1; i <= n; i++) {
        console.log(new Array(i+1).join('$'));
    }
}

function printOddToN(n){
    let limit = Number.parseInt(n);
    for (let i = 1; i <= limit; i+=2) {
        console.log(i);
    }
}

printOddToN(6);
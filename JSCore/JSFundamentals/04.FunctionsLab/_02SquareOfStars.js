function squareOfStars(n) {
    function printStars(count = n) {
        console.log('* '.repeat(n).trim());
    }

    for (let i = 0; i < n; i++) {
        printStars();
    }
}

squareOfStars(5);
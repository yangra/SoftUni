function figureOfSquares(n) {

    let limit = n % 2 === 0 ? n - 1 : n;
    for (let row = 0; row < limit; row++) {

        if (row === 0 || row === Math.floor(limit / 2) || row === limit - 1) {
            console.log(Line(n, '+', '-'));
        } else {
            console.log(Line(n, '|', ' '));
        }
    }

    function Line(n, separator, repSymb) {
        let line = separator;
        for (let i = 0; i < 2; i++) {
            line += repSymb.repeat(n - 2);
            line += separator;
        }
        return line;
    }

}

figureOfSquares(2);
figureOfSquares(3);
figureOfSquares(4);
figureOfSquares(5);
figureOfSquares(6);

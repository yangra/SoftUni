function spiralMatrix(rows, cols) {
    let end = rows * cols;
    let matrix = zeroFill(rows,cols);

    let counter = 1;
    let startCol = -1;
    let startRow = 0;
    let rotation = 0;

    while (counter <= end) {
        changeDirection(0, 1, cols-rotation);
        changeDirection(1, 0,rows-1 -rotation);
        changeDirection(0, -1,cols-1-rotation);
        changeDirection(-1, 0,rows-2-rotation);
        rotation+=2;
    }

    printMatrix(matrix);

    function zeroFill(rows,cols) {
        let matrix = [];
        for (let row = 0; row < rows; row++) {
            matrix.push('0'.repeat(cols).split('').map(Number));
        }
        return matrix;
    }

    function changeDirection(offsetY, offsetX, limit ) {
        for (let i = 0; i < limit; i++) {
            startRow+=offsetY;
            startCol+=offsetX;
            matrix[startRow][startCol] = counter++;


        }
    }

    function printMatrix(matrix) {
        for (let row = 0; row < matrix.length; row++) {
            console.log(matrix[row].join(' '));
        }
    }
}

spiralMatrix(3, 3);
spiralMatrix(5, 4);
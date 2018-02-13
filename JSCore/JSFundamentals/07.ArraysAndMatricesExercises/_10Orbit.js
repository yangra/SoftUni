function drawOrbits(arr) {

    let rows = Number(arr[0]);
    let cols = Number(arr[1]);
    let X = Number(arr[2]);
    let Y = Number(arr[3]);

    let matrix = zeroFill(rows, cols);
    let orbitNum = 0;
    while (orbitNum < Math.max(rows, cols)) {
        for (let row = 0; row < matrix.length; row++) {
            for (let col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col]===0&&
                    row >= X - orbitNum && row <= X  + orbitNum
                    && col >= Y  - orbitNum && col <= Y  + orbitNum) {
                    matrix[row][col] = orbitNum + 1;
                }
            }
        }
        orbitNum++;
    }

    printMatrix();

    function zeroFill(rows, cols) {
        let matrix = [];
        for (let row = 0; row < rows; row++) {
            matrix.push('0'.repeat(cols).split('').map(Number));
        }
        return matrix;
    }

    function printMatrix() {
        for (let i = 0; i < matrix.length; i++) {
            console.log(matrix[i].join(' '));
        }
    }

}

drawOrbits([4, 4, 0, 0]);
drawOrbits([5, 4, 2, 2]);
drawOrbits([3, 3, 2, 2]);
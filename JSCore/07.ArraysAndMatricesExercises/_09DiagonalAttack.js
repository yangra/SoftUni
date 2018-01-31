function diagonalAttack(arr) {
    let matrix = readMatrix(arr);

    let sumRightDiagonal = 0;
    let sumLeftDiagonal = 0;

    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[i].length; j++) {
            if (i === j) {
                sumRightDiagonal += matrix[i][j];
            }
            if (i + j === matrix.length-1) {
                sumLeftDiagonal += matrix[i][j];
            }
        }
    }

    if (sumLeftDiagonal === sumRightDiagonal) {
        for (let i = 0; i < matrix.length; i++) {
            for (let j = 0; j < matrix[i].length; j++) {
                if (i !== j && i + j !== matrix.length-1) {
                    matrix[i][j] = sumRightDiagonal;
                }
            }
        }
    }

    printMatrix();

    function readMatrix(arr) {
        let matrix = [];
        for (let i = 0; i < arr.length; i++) {
            matrix.push(arr[i].split(' ').map(Number));
        }
        return matrix;
    }

    function printMatrix() {
        for (let i = 0; i < matrix.length; i++) {
            console.log(matrix[i].join(' '));
        }
    }
}

diagonalAttack(['5 3 12 3 1',
    '11 4 23 2 5',
    '101 12 3 21 10',
    '1 4 5 2 2',
    '5 22 33 11 1']);
diagonalAttack(['1 1 1',
    '1 1 1',
    '1 1 0']);
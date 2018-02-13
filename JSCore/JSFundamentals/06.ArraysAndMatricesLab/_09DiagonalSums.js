function diagonalSums(matrix) {
    let result = [0, 0];
    for (let row = 0; row < matrix.length; row++) {
        result[0] += matrix[row][row];
        result[1] += matrix[row][matrix.length-row-1];
    }

    console.log(result.join(' '));
}

diagonalSums([[3, 5, 17], [-1, 7, 4], [1, 8, 99]]);
function isMagic(matrix) {

    let rowSums = matrix.map(r => r.reduce((a, b) => a + b));
    let equalRowSums = rowSums.every(e => e === rowSums[0]);

    let sumColCurrent = 0;
    let colSums = [];
    for (let col = 0; col < matrix[0].length; col++) {
        for (let row = 0; row < matrix.length; row++) {
            sumColCurrent += matrix[row][col];
        }
        colSums.push(sumColCurrent);
        sumColCurrent = 0;
    }
    let equalColSums = colSums.every(e => e === colSums[0]);

    return equalColSums&&equalRowSums;
}

//isMagic([[4, 5, 6], [6, 5, 4], [5, 5, 5]]);
// isMagic([[11, 32, 45], [21, 0, 1], [21, 1, 1]]);
// isMagic([[1, 0, 0], [0, 0, 1], [0, 1, 0]]);
isMagic([[0, 0, 0], [0,0,0], [0, 0, 0]]);
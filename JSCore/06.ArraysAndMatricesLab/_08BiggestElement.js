function biggestElementInMatrix(matrix) {
    let biggestNum = Number.NEGATIVE_INFINITY;
    matrix.forEach(r => r.forEach(e => biggestNum = Math.max(e, biggestNum)));
    console.log(biggestNum);
}

biggestElementInMatrix([[3, 5, 17, 12, 91, 5], [-1, 7, 4, 33, 6, 22], [1, 8, 99, 3, 10, 43]]);
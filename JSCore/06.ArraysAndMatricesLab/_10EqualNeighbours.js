function equalNeighbors(matrix) {
    let result = 0;
    for (let row = 0; row < matrix.length; row++) {
        for (let col = 0; col < matrix[row].length; col++) {
            if(row+1<matrix.length&&matrix[row][col] === matrix[row+1][col]){
                result++;
            }
            if(col+1<matrix.length&&matrix[row][col] === matrix[row][col+1]){
                result++;
            }
        }
    }
    console.log(result);
}

equalNeighbors([[2, 2, 5, 7, 4], [4, 0, 5, 3 ,4], [2, 5, 5, 4, 2]])
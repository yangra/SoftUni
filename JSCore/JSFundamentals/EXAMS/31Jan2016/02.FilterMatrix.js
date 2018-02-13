function filter(arr) {
    let matrix = [];
    let booleanMatrix = [];
    arr = arr.filter(s => s !== '');
    let seqLength = Number(arr[arr.length - 1].trim());
    for (let i = 0; i < arr.length - 1; i++) {
        matrix.push(arr[i].split(/\s/).filter(s => s !== ''));
        booleanMatrix.push(arr[i].split(/\s/).filter(s => s !== '').map(s => true));
    }

    function isValidRow(row) {
        return row >= 0 && row < matrix.length;
    }

    let count = 1;
    let savedSymbol;
    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[i].length; j++) {
            savedSymbol = matrix[i][j];
            let row = i;
            let col = j;
            for (let times = 1; times < seqLength; times++) {
                if (col + 1 < matrix[row].length) {
                    col++;
                } else {
                    if (isValidRow(row + 1)) {
                        row++;
                    } else {
                        break;
                    }
                    col = 0;
                }

                if (savedSymbol === matrix[row][col]) {
                    count++;
                } else {
                    break;
                }
            }

            if (count === seqLength) {
                row = i;
                col = j - 1;
                for (let times = 0; times < seqLength; times++) {
                    if (col + 1 < matrix[row].length) {
                        col++;
                    } else {
                        if (isValidRow(row + 1)) {
                            row++;
                        } else {
                            break;
                        }
                        col = 0;
                    }
                    booleanMatrix[row][col] = false;
                }
                i = row;
                j = col;
            }
            count = 1;
        }
    }

    for (let i = 0; i < booleanMatrix.length; i++) {
        let output = '';
        for (let j = 0; j < booleanMatrix[i].length; j++) {

            if (booleanMatrix[i][j] === true) {
                output += matrix[i][j] + ' ';
            }
        }
        if (output === '') {
            console.log('(empty)');
        } else {
            console.log(output.trim());
        }
    }
}

filter(['3 3 3 2 5 9 9 9 9 1 2',
    '1 1 1 1 1 2 5 8 1 1 7',
    '7 7 1 2 3 5 7 4 4 1 2',
    '2']);

filter(['1 2 3 3',
    '3 5 7 8',
    '3 2 2 1',
    '3']);

filter(['2 1 1 1',
    '1 1 1 ',
    '3 7 3 3 1',
    '2']);

filter(['1 2 3 3 2 1 ',
    '5 2 2 1 1 0',
    '3 3 1 3 3',
    '2']);



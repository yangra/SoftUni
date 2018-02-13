function findExit(primaryMatrix, secondaryMatrix, overlayCoordinates, startCoordiantes) {
    for (let edgeCoords of overlayCoordinates) {
        let xEdge = edgeCoords[0];
        let yEdge = edgeCoords[1];
        for (let i = 0; i < secondaryMatrix.length; i++) {
            for (let j = 0; j < secondaryMatrix[0].length; j++) {
                if (isValidXCoordinate(i + xEdge) && isValidYCoordinate(j + yEdge) && secondaryMatrix[i][j] === 1) {
                    if (primaryMatrix[i + xEdge][j + yEdge] === 1) {
                        primaryMatrix[i + xEdge][j + yEdge] = 0;
                    } else {
                        primaryMatrix[i + xEdge][j + yEdge] = 1;
                    }
                }

            }

        }
    }

    let currentX = startCoordiantes[0];
    let currentY = startCoordiantes[1];
    let prevDir = '';
    let steps = 1;

    while (true) {
        if (isValidXCoordinate(currentX + 1) && prevDir !== 'up' && primaryMatrix[currentX + 1][currentY] === 0) {
            prevDir = 'down';
            currentX++;
            steps++;
        }
        else if (isValidXCoordinate(currentX - 1) && prevDir !== 'down' && primaryMatrix[currentX - 1][currentY] === 0) {
            prevDir = 'up';
            currentX--;
            steps++;
        }
        else if (isValidYCoordinate(currentY - 1) && prevDir !== 'right' && primaryMatrix[currentX][currentY - 1] === 0) {
            prevDir = 'left';
            currentY--;
            steps++;
        }
        else if (isValidYCoordinate(currentY + 1) && prevDir !== 'left' && primaryMatrix[currentX][currentY + 1] === 0) {
            prevDir = 'right';
            currentY++;
            steps++;
        }
        else {
            break;
        }
    }


    let output = '';
    if (currentX === 0) {
        output += 'Top';
    } else if (currentX === primaryMatrix.length - 1) {
        output += 'Bottom';
    } else if (currentY === 0) {
        output += 'Left';
    } else if (currentY === primaryMatrix[0].length - 1) {
        output += 'Right';
    } else {
        output += 'Dead end ';
        if (currentX < primaryMatrix.length / 2 && currentY < primaryMatrix[0].length / 2) {
            output += '2';
        } else if (currentX >= primaryMatrix.length / 2 && currentY < primaryMatrix[0].length / 2) {
            output += '3';
        } else if (currentX < primaryMatrix.length / 2 && currentY >= primaryMatrix[0].length / 2) {
            output += '1';
        } else {
            output += '4';
        }
    }

    console.log(steps);
    console.log(output);

    function isValidXCoordinate(number) {
        if (number >= 0 && number < primaryMatrix.length) {
            return true;
        }
        return false;
    }

    function isValidYCoordinate(number) {
        if (number >= 0 && number < primaryMatrix[0].length) {
            return true;
        }
        return false;
    }
}


findExit([[1, 1, 0, 1, 1, 1, 1, 0],
        [0, 1, 1, 1, 0, 0, 0, 1],
        [1, 0, 0, 1, 0, 0, 0, 1],
        [0, 0, 0, 1, 1, 0, 0, 1],
        [1, 0, 0, 1, 1, 1, 1, 1],
        [1, 0, 1, 1, 0, 1, 0, 0]],
    [[0, 1, 1],
        [0, 1, 0],
        [1, 1, 0]],
    [[1, 1],
        [2, 3],
        [5, 3]],
    [0, 2]
);

findExit([[1, 1, 0, 1],
        [0, 1, 1, 0],
        [0, 0, 1, 0],
        [1, 0, 1, 0]],
    [[0, 0, 1, 0, 1],
        [1, 0, 0, 1, 1],
        [1, 0, 1, 1, 1],
        [1, 0, 1, 0, 1]],
    [[0, 0],
        [2, 1],
        [1, 0]],
    [2, 0]
);
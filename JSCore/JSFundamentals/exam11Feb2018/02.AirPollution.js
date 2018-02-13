function solve(air, forces) {
    let airMatrix = [];
    for (let line of air) {
        airMatrix.push(line.split(/\s+/).filter(s => s !== '').map(s => Number(s)));
    }

    for (let str of forces) {
        let [force, index] = str.split(/\s/).filter(s => s !== '');
        switch (force) {
            case 'breeze':
                breeze(Number(index));
                break;
            case 'gale':
                gale(Number(index));
                break;
            case 'smog':
                smog(Number(index));
                break;
        }
    }

    let output = [];
    for (let i = 0; i < airMatrix.length; i++) {
        for (let j = 0; j < airMatrix[0].length; j++) {
            if (airMatrix[i][j] >= 50) {
                output.push(`[${i}-${j}]`);
            }
        }
    }

    if (output.length > 0) {
        console.log('Polluted areas: ' + output.join(', '));
    } else {
        console.log('No polluted areas');
    }


    function breeze(row) {
        for (let i = 0; i < airMatrix[0].length; i++) {
            airMatrix[row][i] -= 15;
            if (airMatrix[row][i] < 0) {
                airMatrix[row][i] = 0;
            }
        }
    }

    function gale(column) {
        for (let i = 0; i < airMatrix.length; i++) {
            airMatrix[i][column] -= 20;
            if (airMatrix[i][column] < 0) {
                airMatrix[i][column] = 0;
            }
        }
    }


    function smog(amount) {
        for (let i = 0; i < airMatrix.length; i++) {
            for (let j = 0; j < airMatrix[0].length; j++) {
                airMatrix[i][j] += amount;
            }
        }
    }
}


solve([
        "5 7 72 14 4",
        "41 35 37 27 33",
        "23 16 27 42 12",
        "2 20 28 39 14",
        "16 34 31 10 24",
    ],
    ["breeze 1", "gale 2", "smog 25"]
);

solve([
        "5 7 2 14 4",
        "21 14 2 5 3",
        "3 16 7 42 12",
        "2 20 8 39 14",
        "7 34 1 10 24",
    ],
    ["breeze 1", "gale 2", "smog 35"]
);

solve([
        "5 7 3 28 32",
        "41 12 49 30 33",
        "3 16 20 42 12",
        "2 20 10 39 14",
        "7 34 4 27 24",
    ],
    [
        "smog 11", "gale 3",
        "breeze 1", "smog 2"
    ]
);
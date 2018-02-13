function detonate(arr) {
    let hangar = [];
    let damageTotal = 0;
    let killed = 0;

    arr = arr.filter(s => s !== '');
    for (let i = 0; i < arr.length - 1; i++) {
        hangar.push(arr[i].split(/\s+/).map(e => Number(e)));
    }

    let bombs = arr[arr.length - 1].split(/\s+/);
    for (let bomb of bombs) {
        let coords = bomb.split(/,/).filter(s => s !== '');
        let row = Number(coords[0]);
        let col = Number(coords[1]);
        if (hangar[row][col] > 0) {
            let damage = hangar[row][col];
            doDamageAround(row, col, damage);
            damageTotal += damage;
            killed++;
        }
    }

    for (let row = 0; row < hangar.length; row++) {
        for (let col = 0; col < hangar[0].length; col++) {
            if (hangar[row][col] > 0) {
                damageTotal += hangar[row][col];
                killed++;
                hangar[row][col] = 0;
            }
        }
    }

    console.log(damageTotal);
    console.log(killed);

    function doDamageAround(row, col, damage) {
        for (let i = row - 1; i <= row + 1; i++) {
            if (i < 0 || i > hangar.length - 1) continue;
            for (let j = col - 1; j <= col + 1; j++) {
                if (j < 0 || j > hangar[0].length - 1) continue;
                if (hangar[i][j] <= 0) continue;
                hangar[i][j] -= damage;
            }
        }
    }
}


detonate(['5 10 15 20',
    '10 10 10 10',
    '10 15 10 10',
    '10 10 10 10',
    '2,2 0,1']);

detonate(['10 10 10',
    '10 10 10',
    '10 10 10',
    '0,0']);
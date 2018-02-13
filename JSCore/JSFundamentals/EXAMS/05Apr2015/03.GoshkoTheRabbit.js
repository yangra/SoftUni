function rabbit(arr) {
    let carrots = 0;
    let cabbage = 0;
    let lettuce = 0;
    let turnip = 0;
    let bumps = 0;
    let result = [];
    let garden = [];
    let directions = arr[0].split(/,\s/).filter(s => s !== '');
    arr.shift();
    for (let i = 0; i < arr.length; i++) {
        garden[i] = arr[i].split(/,\s/).filter(s => s !== '');
    }

    let row = 0;
    let col = 0;

    for (let i = 0; i < directions.length; i++) {
        switch (directions[i]) {
            case 'up':
                if (row - 1 < 0) {
                    bumps++;
                    continue;
                }
                row -= 1;
                break;
            case 'down':
                if (row + 1 >= garden.length) {
                    bumps++;
                    continue;
                }
                row += 1;
                break;
            case 'left':
                if (col - 1 < 0) {
                    bumps++;
                    continue;
                }
                col -= 1;
                break;
            case 'right':
                if (col + 1 >= garden[row].length) {
                    bumps++;
                    continue;
                }
                col += 1;
                break;
        }

        let matches = garden[row][col].match(/{[!*&#]}/g);
        if (matches !== null) {
            for (let match of matches) {
                switch (match) {
                    case '{!}':
                        carrots++;
                        garden[row][col] = garden[row][col].replace('{!}', '@');
                        break;
                    case '{*}':
                        cabbage++;
                        garden[row][col] = garden[row][col].replace('{*}', '@');
                        break;
                    case '{&}':
                        lettuce++;
                        garden[row][col] = garden[row][col].replace('{&}', '@');
                        break;
                    case '{#}':
                        turnip++;
                        garden[row][col] = garden[row][col].replace('{#}', '@');
                        break;
                }
            }
        }
        result.push(garden[row][col]);

    }

    console.log(`{"&":${lettuce},"*":${cabbage},"#":${turnip},"!":${carrots},"wall hits":${bumps}}`);
    if (result.length > 0) {
        console.log(result.join('|'));
    } else {
        console.log('no');
    }

}

rabbit(['right, up, up, down',
    'asdf, as{#}aj{g}dasd, kjldk{}fdffd, jdflk{#}jdfj',
    'tr{X}yrty, zxx{*}zxc, mncvnvcn, popipoip',
    'poiopipo, nmf{X}d{X}ei, mzoijwq, omcxzne']);

rabbit(['up, right, left, down', 'as{!}xnk']);
rabbit(['right, right, down, left, left, down, right, right, down, left',
    'qwekjs, asd{#}a, mxz{#}{*}',
    'qwekjs, asd{#}a, xnc{&}a',
    'qwekjs, asd{#}a, xnc{&}a',
    'qwekjs, asd{#}a, xnc{&}a']);
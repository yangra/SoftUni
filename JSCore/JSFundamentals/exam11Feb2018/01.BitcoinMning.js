function solve(arr) {
    let totalGain = 0;
    let bitcoins = 0;
    let firstDay = -1;
    for (let i = 0; i < arr.length; i++) {
        let gainGold = Number(arr[i]);
        if (i % 3 === 2) {
            gainGold = gainGold - (gainGold * 30 / 100);
        }
        let gainLv = gainGold * 67.51;
        totalGain += gainLv;
        if (totalGain >= 11949.16) {
            bitcoins += parseInt((totalGain / 11949.16).toString());
            totalGain %= 11949.16;
            if (firstDay === -1) {
                firstDay = i + 1;
            }
        }
    }

    console.log(`Bought bitcoins: ${bitcoins}`);
    if (firstDay !== -1) {
        console.log(`Day of the first purchased bitcoin: ${firstDay}`);
    }
    console.log(`Left money: ${totalGain.toFixed(2)} lv.`);
}

solve(['100', '200', '300']);

solve(['3124.15',
    '504.212',
    '2511.124']);

solve(['50',
    '100']);
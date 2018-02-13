function countCoins(arr) {
    let coins = 0;
    for (let str of arr) {
        str = str.split(' ');
        if (str[0].toLowerCase() !== 'coin') {
            continue;
        }
        if (parseInt(str[1]) !== Number(str[1]) || Number(str[1]) < 0) {
            continue;
        }

        coins += parseInt(str[1]);
    }

    let gold = Math.floor(coins / 100);
    coins -= gold * 100;
    let silver = Math.floor(coins / 10);
    coins -= silver * 10;

    console.log(`gold : ${gold}`);
    console.log(`silver : ${silver}`);
    console.log(`bronze : ${coins}`);
}

countCoins(['coin 1', 'coin two', 'coin 5', 'coin 10.50', 'coin 20', 'coin 50', 'coin hundred', 'cigars 1']);
countCoins(['coin one', 'coin two', 'coin five', 'coin ten', 'coin twenty', 'coin fifty', 'coin hundred', 'cigars 1']);
countCoins(['coin 1', 'coin 2.00', 'coin 5', 'coin 10', 'coin 20', 'coin 50', 'coin 100', 'coin 200', 'coin -500', 'cigars 1']);
countCoins(['coin -500']);

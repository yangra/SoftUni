function fillBottles(arr) {
    let result = {};
    let filling = {};
    for (let entry of arr) {
        let [juice, quantity] = entry.split(/\s*=>\s*/).filter(s => s !== '');
        if (filling.hasOwnProperty(juice)) {
            filling[juice] += Number(quantity);
        } else {
            filling[juice] = Number(quantity);
        }

        if (filling[juice] >= 1000) {
            let filledBottles = Math.floor(filling[juice] / 1000);
            if (result.hasOwnProperty(juice)) {
                result[juice] += filledBottles;
            }else {
                result[juice] = filledBottles;
            }
            filling[juice] -= filledBottles * 1000;
        }

    }

    for (let juice in result) {
        console.log(`${juice} => ${result[juice]}`);
    }
}

fillBottles(['Orange => 2000',
    'Peach => 1432',
    'Banana => 450',
    'Peach => 600',
    'Strawberry => 549']);

fillBottles(['Kiwi => 234',
'Pear => 2345',
'Watermelon => 3456',
'Kiwi => 4567',
'Pear => 5678',
'Watermelon => 6789']);
function registerLuggage(arr) {
    let luggageRegister = {};

    let entry = 0;
    while (arr[entry] !== 'strict' && arr[entry] !== 'luggage name' && arr[entry] !== 'weight') {
        let [person, luggage, isFood, isDrink, isFragile, weight, transfer] = arr[entry].split(/\.*\*\.*/).filter(s => s !== '');
        if (person === undefined) {
            continue;
        }
        if (luggageRegister.hasOwnProperty(person)) {
            fillObject(isFood, isDrink, person, luggage, weight, isFragile, transfer);
        } else {
            luggageRegister[person] = {};
            fillObject(isFood, isDrink, person, luggage, weight, isFragile, transfer);
        }
        entry++;
    }

    switch (arr[entry]) {
        case 'weight':

            for (let person in luggageRegister) {
                let sortedLuggage = {};
               let sortedKeys = Object.keys(luggageRegister[person]).sort((a, b) => luggageRegister[person][a].kg - luggageRegister[person][b].kg);
                for (let key of sortedKeys) {
                    sortedLuggage[key] = luggageRegister[person][key];
                }
                luggageRegister[person] = sortedLuggage;
            }
            break;
        case 'luggage name':

            for (let person in luggageRegister) {
                let sortedLuggage = {};
               let sortedKeys = Object.keys(luggageRegister[person]).sort((a, b) => a.localeCompare(b));
                for (let key of sortedKeys) {
                    sortedLuggage[key] = luggageRegister[person][key];
                }
                luggageRegister[person] = sortedLuggage;
            }
            break;
    }

    console.log(JSON.stringify(luggageRegister));


    function fillObject(isFood, isDrink, person, luggage, weight, isFragile, transfer) {
        let type;
        if (isFood === 'true') {
            type = 'food'
        } else if (isDrink === 'true') {
            type = 'drink';
        } else {
            type = 'other';

        }

        luggageRegister[person][luggage] = {};
        luggageRegister[person][luggage]['kg'] = Number(weight);
        luggageRegister[person][luggage]['fragile'] = isFragile === 'true';
        luggageRegister[person][luggage]['type'] = type;
        luggageRegister[person][luggage]['transferredWith'] = transfer;
    }
}

registerLuggage(['Yana Slavcheva.*.clothes.*.false.*.false.*.false.*.2.2.*.backpack',
    'Kiko.*.socks.*.false.*.false.*.false.*.0.2.*.backpack',
    'Kiko.*.banana.*.true.*.false.*.false.*.3.2.*.backpack',
    'Kiko.*.sticks.*.false.*.false.*.false.*.1.6.*.ATV',
    'Kiko.*.glasses.*.false.*.false.*.true.*.3.*.ATV',
    'Manov.*.socks.*.false.*.false.*.false.*.0.3.*.ATV',
    'weight', '']);
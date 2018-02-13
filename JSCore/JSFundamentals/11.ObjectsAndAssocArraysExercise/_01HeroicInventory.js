function inventorize(arr) {
    let heroes = [];
    for (let str of arr) {
        let [hero, level, items] = str.split(/\s*\/\s*/).filter(s => s !== '');
        let record = {};
        record['name'] = hero;
        record['level'] = Number(level);
        record['items'] = [];
        if (items !== undefined) {
            record['items'] = items.split(/,\s*/).filter(s => s !== '');
        }
        heroes.push(record);
    }

    console.log(JSON.stringify(heroes));
}

inventorize(['Isacc / 25 / Apple, GravityGun',
    'Derek / 12 / BarrelVest, DestructionSword',
    'Hes / 1 / Desolator, Sentinel, Antara']);
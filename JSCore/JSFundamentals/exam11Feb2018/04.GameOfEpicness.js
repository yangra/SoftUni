function solve(kms, battles) {
    let kingdoms = new Map();
    for (let obj of kms) {
        if (kingdoms.has(obj.kingdom)) {
            if (kingdoms.get(obj.kingdom).has(obj.general)) {
                kingdoms.get(obj.kingdom).get(obj.general)['army'] += obj.army;
            } else {
                kingdoms.get(obj.kingdom).set(obj.general, {});
                kingdoms.get(obj.kingdom).get(obj.general)['army'] = obj.army;
                kingdoms.get(obj.kingdom).get(obj.general)['wins'] = 0;
                kingdoms.get(obj.kingdom).get(obj.general)['loses'] = 0;
            }

        } else {
            kingdoms.set(obj.kingdom, new Map());
            kingdoms.get(obj.kingdom).set(obj.general, {});
            kingdoms.get(obj.kingdom).get(obj.general)['army'] = obj.army;
            kingdoms.get(obj.kingdom).get(obj.general)['wins'] = 0;
            kingdoms.get(obj.kingdom).get(obj.general)['loses'] = 0;
        }
    }

    for (let arr of battles) {
        if (arr[0] === arr[2]) {
            continue;
        }
        if (kingdoms.get(arr[0]).get(arr[1])['army'] > kingdoms.get(arr[2]).get(arr[3])['army']) {
            kingdoms.get(arr[0]).get(arr[1])['army'] = Math.floor(kingdoms.get(arr[0]).get(arr[1])['army'] * 1.1);
            kingdoms.get(arr[0]).get(arr[1])['wins'] += 1;
            kingdoms.get(arr[2]).get(arr[3])['army'] = Math.floor(kingdoms.get(arr[2]).get(arr[3])['army'] * 0.9);
            kingdoms.get(arr[2]).get(arr[3])['loses'] += 1;
            continue;
        }

        if (kingdoms.get(arr[0]).get(arr[1])['army'] < kingdoms.get(arr[2]).get(arr[3])['army']) {
            kingdoms.get(arr[0]).get(arr[1])['army'] = Math.floor(kingdoms.get(arr[0]).get(arr[1])['army'] * 0.9);
            kingdoms.get(arr[0]).get(arr[1])['loses'] += 1;
            kingdoms.get(arr[2]).get(arr[3])['army'] = Math.floor(kingdoms.get(arr[2]).get(arr[3])['army'] * 1.1);
            kingdoms.get(arr[2]).get(arr[3])['wins'] += 1;
        }
    }

    let sortedKingdoms = Array.from(kingdoms.keys()).sort((a, b) => {
        let kgBWins = Array.from(kingdoms.get(b).values()).map(o=>o['wins']).reduce((m, n) => m + n);
        let kgAWins = Array.from(kingdoms.get(a).values()).map(o=>o['wins']).reduce((m, n) => m + n);
        if (kgBWins !== kgAWins) {
            return kgBWins - kgAWins;
        }
        let kgALose = Array.from(kingdoms.get(a).values()).map(o=>o['loses']).reduce((m, n) => m + n);
        let kgBLose = Array.from(kingdoms.get(b).values()).map(o=>o['loses']).reduce((m, n) => m + n);
        if(kgALose!== kgBLose){
            return kgALose - kgBLose;
        }
        return a.localeCompare(b);
    });

    let sortedGenerals = Array.from(kingdoms.get(sortedKingdoms[0]).keys()).sort((a,b)=>{
        let armyA = kingdoms.get(sortedKingdoms[0]).get(a)['army'];
        let armyB = kingdoms.get(sortedKingdoms[0]).get(b)['army'];
        return armyB - armyA;
    });


    console.log('Winner: '+ sortedKingdoms[0]);
    for (let gen of sortedGenerals) {
        console.log('/\\general: ' + gen);
        console.log('---army: ' + kingdoms.get(sortedKingdoms[0]).get(gen)['army']);
        console.log('---wins: ' + kingdoms.get(sortedKingdoms[0]).get(gen)['wins']);
        console.log('---losses: ' + kingdoms.get(sortedKingdoms[0]).get(gen)['loses']);
    }
}

// Winner: Stonegate
// /\general: Doran
// ---army: 77000
// ---wins: 1
// ---losses: 0
// /\general: Ulric
// ---army: 5336
// ---wins: 2
// ---losses: 1


solve([{kingdom: "Maiden Way", general: "Merek", army: 5000},
        {kingdom: "Stonegate", general: "Ulric", army: 4900},
        {kingdom: "Stonegate", general: "Doran", army: 70000},
        {kingdom: "YorkenShire", general: "Quinn", army: 0},
        {kingdom: "YorkenShire", general: "Quinn", army: 2000},
        {kingdom: "Maiden Way", general: "Berinon", army: 100000}],
    [["YorkenShire", "Quinn", "Stonegate", "Ulric"],
        ["Stonegate", "Ulric", "Stonegate", "Doran"],
        ["Stonegate", "Doran", "Maiden Way", "Merek"],
        ["Stonegate", "Ulric", "Maiden Way", "Merek"],
        ["Maiden Way", "Berinon", "Stonegate", "Ulric"]]);

solve([ { kingdom: "Stonegate", general: "Ulric", army: 5000 },
        { kingdom: "YorkenShire", general: "Quinn", army: 5000 },
        { kingdom: "Maiden Way", general: "Berinon", army: 1000 } ],
    [ ["YorkenShire", "Quinn", "Stonegate", "Ulric"],
        ["Maiden Way", "Berinon", "YorkenShire", "Quinn"] ]
);


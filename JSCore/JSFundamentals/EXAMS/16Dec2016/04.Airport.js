function airport(arr) {
    let planes = new Set();
    let towns = new Map();
    for (let params of arr) {
        let plane = params.split(/\s+/g).filter(s => s !== '');
        if (planes.has(plane[0])) {
            if (plane[3] === 'depart') {
                if(towns.has(plane[1])){
                    towns.get(plane[1])['departures'] += Number(plane[2]);
                    if (towns.get(plane[1])['planes'].indexOf(plane[0]) === -1) {
                        towns.get(plane[1])['planes'].push(plane[0]);
                    }
                }else{
                    towns.set(plane[1], {});
                    towns.get(plane[1])['arrivals'] = 0;
                    towns.get(plane[1])['departures'] = Number(plane[2]);
                    towns.get(plane[1])['planes'] = [];
                    towns.get(plane[1])['planes'].push(plane[0]);
                }
                planes.delete(plane[0]);

            }
        } else {
            if (plane[3] === 'land') {
                planes.add(plane[0]);
                if (towns.has(plane[1])) {
                    towns.get(plane[1])['arrivals'] += Number(plane[2]);
                    if (towns.get(plane[1])['planes'].indexOf(plane[0]) === -1) {
                        towns.get(plane[1])['planes'].push(plane[0]);
                    }
                } else {
                    towns.set(plane[1], {});
                    towns.get(plane[1])['arrivals'] = Number(plane[2]);
                    towns.get(plane[1])['departures'] = 0;
                    towns.get(plane[1])['planes'] = [];
                    towns.get(plane[1])['planes'].push(plane[0]);
                }
            }
        }
    }

    let sortedPlanes = Array.from(planes.keys()).sort((a, b) => a.localeCompare(b));
    let sortedTowns = Array.from(towns.keys()).sort((a, b) => {
        if (towns.get(b)['arrivals'] !== towns.get(a)['arrivals']) {
            return towns.get(b)['arrivals'] - towns.get(a)['arrivals'];
        }
        return a.localeCompare(b);
    });

    for (let [key, value] of towns) {
        towns.get(key)['planes'].sort((a, b) => a.localeCompare(b));
    }

    console.log('Planes left:');
    for (let plane of sortedPlanes) {
        console.log('- ' + plane);
    }
    for (let key of sortedTowns) {
        console.log(key);
        console.log('Arrivals: ' + towns.get(key)['arrivals']);
        console.log('Departures: ' + towns.get(key)['departures']);
        console.log('Planes:');
        for (let plane of towns.get(key)['planes']) {
            console.log('-- ' + plane);
        }
    }
}

airport([
    "Airbus London 265 depart",
    "ATR72 WashingtonDC 272 land",
    "ATR72 Madrid 135 depart"]);

airport([
    "Airbus Paris 356 land",
    "Airbus London 321 land",
    "Airbus Paris 213 depart",
    "Airbus Ljubljana 250 land"
]);
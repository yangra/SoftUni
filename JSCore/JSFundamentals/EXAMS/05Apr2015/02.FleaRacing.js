function fleaRace(arr) {
    let allowedJumps = Number(arr[0]);
    let raceTrackLength = Number(arr[1]);
    let fleas = {};
    for (let i = 2; i < arr.length; i++) {
        let [name, jumpLength] = arr[i].split(/,\s*/).filter(s => s !== '');
        let flea = {};
        flea['name'] = name;
        flea['jumpDistance'] = Number(jumpLength);
        flea['position'] = 0;
        fleas[name] = flea;
    }

    let round = 1;
    let isPrinted = false;
    while (round <= allowedJumps) {
        for (let flea in fleas) {
            fleas[flea].position += fleas[flea].jumpDistance;
            if (fleas[flea]['position'] >= raceTrackLength - 1) {
                console.log('#'.repeat(raceTrackLength));
                console.log('#'.repeat(raceTrackLength));
                for (let key in fleas) {
                    let result = '';
                    if (fleas[key] === fleas[flea]) {
                        result += '.'.repeat(raceTrackLength - 1);
                        result += fleas[key]['name'].charAt(0).toUpperCase();
                    } else {
                        result += '.'.repeat(fleas[key]['position']);
                        result += fleas[key]['name'].charAt(0).toUpperCase();
                        result += '.'.repeat(raceTrackLength - fleas[key]['position'] - 1);
                    }
                    console.log(result);
                }
                console.log('#'.repeat(raceTrackLength));
                console.log('#'.repeat(raceTrackLength));
                console.log(`Winner: ${flea}`);
                isPrinted = true;
                break;
            }


        }
        if(isPrinted){
            break;
        }
        round++;
    }

    if(!isPrinted){
        console.log('#'.repeat(raceTrackLength));
        console.log('#'.repeat(raceTrackLength));
        let winner;
        let maxPosition = 0;
        for (let key in fleas) {
            let result = '';
            result += '.'.repeat(fleas[key]['position']);
            result += fleas[key]['name'].charAt(0).toUpperCase();
            result += '.'.repeat(raceTrackLength - fleas[key]['position'] - 1);
            console.log(result);
            if(maxPosition<=fleas[key]['position']){
                maxPosition = fleas[key]['position'];
                winner = fleas[key]['name'];
            }
        }
        console.log('#'.repeat(raceTrackLength));
        console.log('#'.repeat(raceTrackLength));
        console.log(`Winner: ${winner}`);
    }

}

fleaRace(['10', '19', 'angel, 9', 'Boris, 10', 'Georgi, 3', 'Dimitar, 7']);
fleaRace([ '3', '5', 'cura, 1', 'Pepi, 1', 'UlTraFlee, 1', 'BOIKO, 1' ]);
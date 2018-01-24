function checkSpeed(situation) {
    let speed = situation[0];
    let territory = situation[1].toLowerCase();
    let overSpeedLimit = isOver(speed, territory);
    if (overSpeedLimit) {
        if (overSpeedLimit > 40) {
            console.log('reckless driving');
        } else if (overSpeedLimit > 20) {
            console.log('excessive speeding');
        } else {
            console.log('speeding');
        }
    }


    function isOver(speed, territory) {
        switch (territory) {
            case 'motorway':
                return speed > 130 ? speed - 130 : false;
            case 'interstate':
                return speed > 90 ? speed - 90 : false;
            case 'city':
                return speed > 50 ? speed - 50 : false;
            case 'residential':
                return speed > 20 ? speed - 20 : false;
        }
    }
}

checkSpeed([40, 'city']);
checkSpeed([21, 'residential']);
checkSpeed([120, 'interstate']);
checkSpeed([200, 'motorway']);
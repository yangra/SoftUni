function snatchMeals(portions, commands) {
    let mealsEaten = 0;
    let commandManager = {
        serve: () => {
            if (portions.length < 1) {
                return;
            }
            console.log(`${portions.pop()} served!`);
        },
        add: ([portion]) => {
            if (portion) {
                portions.unshift(portion)
            }
        },
        shift: (indices) => {
            let index1 = Number(indices[0]);
            let index2 = Number(indices[1]);
            if (isValidIndex(index1) && isValidIndex(index2)) {
                let temp = portions[index1];
                portions[index1] = portions[index2];
                portions[index2] = temp;
            }
        },
        eat:
            () => {
                if (portions.length < 1) {
                    return;
                }
                mealsEaten++;
                console.log(`${portions.shift()} eaten`);
            },
        consume:
            (indices) => {
                let index1 = Number(indices[0]);
                let index2 = Number(indices[1]);
                if (isValidIndex(index1) && isValidIndex(index2) && index1 < index2) {
                    mealsEaten += index2 - index1 + 1;
                    portions.splice(index1, index2 - index1 + 1);
                    console.log('Burp!');
                }
            }
    };

    for (let arg of commands) {
        let commandParams = arg.split(/\s+/);
        let command = commandParams[0].toLowerCase();
        if (command == 'end') {
            break;
        }
        let args = commandParams.slice(1);
        if (commandManager[command]) {
            commandManager[command](args);
        }
    }

    if (portions.length > 0) {
        console.log('Meals left: ' + portions.join(', '));
    } else {
        console.log('The food is gone');
    }

    console.log('Meals eaten: ' + mealsEaten);

    function isValidIndex(index) {
        if (index >= 0 && index < portions.length) {
            return true;
        }
        return false;
    }
}

snatchMeals(['chicken', 'steak', 'eggs'],
    ['Serve',
        'Eat',
        'End',
        'Consume 0 1']);


snatchMeals(['fries', 'fish', 'beer', 'chicken',
        'beer', 'eggs'],
    ['Add spaghetti',
        'Shift 0 1',
        'Consume 1 4',
        'End']
);

snatchMeals(['carrots', 'apple', 'beet'],
    ['Consume 7',
        'End']
);
function accommodate(rooms, couples) {
    let triples = rooms.filter(r => r.type === 'triple');
    let twins = rooms.filter(r => r.type === 'double-bedded');
    let filledRooms = {};
    let partiallyFilledRooms = {};
    let teaHouse = 0;
    for (let couple of couples) {
        if (couple['first']['gender'] === couple['second']['gender'] && couple['first']['gender'] === 'male') {
            sameGender(couple, 'male');
        } else if (couple['first']['gender'] === couple['second']['gender'] && couple['first']['gender'] === 'female') {
            sameGender(couple, 'female');
        } else {
            if (twins.length > 0) {
                let twin = twins.shift();
                twin['emptyBeds'] = 0;
                twin['guests'] = [];
                twin['guests'].push(couple['first']);
                twin['guests'].push(couple['second']);
                filledRooms[twin['number']] = twin;
            } else {
                teaHouse += 2;
            }
        }
    }

    if (partiallyFilledRooms['female']) {
        filledRooms[partiallyFilledRooms['female']['number']] = partiallyFilledRooms['female'];
    }

    if (partiallyFilledRooms['male']) {
        filledRooms[partiallyFilledRooms['male']['number']] = partiallyFilledRooms['male'];
    }

    for (let room of triples) {
        room['guests'] = [];
        room['emptyBeds'] = 3;
        filledRooms[room['number']] = room;
    }

    for (let room of twins) {
        room['guests'] = [];
        room['emptyBeds'] = 2;
        filledRooms[room['number']] = room;
    }

    let sortedRooms = Object.keys(filledRooms).sort((a, b) => a.localeCompare(b));
    for (let key of sortedRooms) {
        console.log('Room number: ' + key);
        if (filledRooms[key]['guests'].length > 1) {
            filledRooms[key]['guests'].sort((a, b) => a['name'].localeCompare(b['name']));
        }
        for (let guest of filledRooms[key]['guests']) {
            console.log('--Guest Name: ' + guest['name']);
            console.log('--Guest Age: ' + guest['age']);
        }
        console.log('Empty beds in the room: ' + filledRooms[key]['emptyBeds']);
    }
    console.log('Guests moved to the tea house: ' + teaHouse);

    function sameGender(couple, gender) {
        if (couple['first']['gender'] === gender && !partiallyFilledRooms[gender] && triples.length > 0) {
            partiallyFilledRooms[gender] = triples.shift();
            partiallyFilledRooms[gender]['guests'] = [];
            partiallyFilledRooms[gender]['guests'].push(couple['first']);
            partiallyFilledRooms[gender]['guests'].push(couple['second']);
            partiallyFilledRooms[gender]['emptyBeds'] = 1;
        } else if (couple['first']['gender'] === gender && partiallyFilledRooms[gender] &&
            partiallyFilledRooms[gender]['emptyBeds'] === 1 && triples.length > 0) {
            partiallyFilledRooms[gender]['guests'].push(couple['first']);
            partiallyFilledRooms[gender]['emptyBeds'] = 0;
            filledRooms[partiallyFilledRooms[gender]['number']] = partiallyFilledRooms[gender];
            partiallyFilledRooms[gender] = triples.shift();
            partiallyFilledRooms[gender]['guests'] = [];
            partiallyFilledRooms[gender]['guests'].push(couple['second']);
            partiallyFilledRooms[gender]['emptyBeds'] = 2;
        } else if (couple['first']['gender'] === gender && partiallyFilledRooms[gender] &&
            partiallyFilledRooms[gender]['emptyBeds'] === 2) {
            partiallyFilledRooms[gender]['guests'].push(couple['first']);
            partiallyFilledRooms[gender]['guests'].push(couple['second']);
            partiallyFilledRooms[gender]['emptyBeds'] = 0;
            filledRooms[partiallyFilledRooms[gender]['number']] = partiallyFilledRooms[gender];
            delete partiallyFilledRooms[gender];
        } else if (couple['first']['gender'] === gender && partiallyFilledRooms[gender] &&
            partiallyFilledRooms[gender]['emptyBeds'] === 1 && triples.length === 0) {
            partiallyFilledRooms[gender]['guests'].push(couple['first']);
            partiallyFilledRooms[gender]['emptyBeds'] = 0;
            filledRooms[partiallyFilledRooms[gender]['number']] = partiallyFilledRooms[gender];
            delete partiallyFilledRooms[gender];
            teaHouse++;
        } else {
            teaHouse += 2;
        }

    }
}

// accommodate([{number: '206', type: 'double-bedded'},
//         {number: '311', type: 'triple'}],
//     [{
//         first: {name: 'Tanya Popova', gender: 'female', age: 24},
//         second: {name: 'Miglena Yovcheva', gender: 'female', age: 23}
//     },
//         {
//             first: {name: 'Katerina Stefanova', gender: 'female', age: 23},
//             second: {name: 'Angel Nachev', gender: 'male', age: 22}
//         },
//         {
//             first: {name: 'Tatyana Germanova', gender: 'female', age: 23},
//             second: {name: 'Boryana Baeva', gender: 'female', age: 22}
//         }]
// );

accommodate([{number: '101A', type: 'double-bedded'},
        {number: '104', type: 'triple'},
        {number: '101B', type: 'double-bedded'},
        {number: '102', type: 'triple'}],
    [{
        first: {name: 'Sushi & Chicken', gender: 'female', age: 15},
        second: {name: 'Salisa Debelisa', gender: 'female', age: 25}
    },
        {
            first: {name: 'Daenerys Targaryen', gender: 'female', age: 20},
            second: {name: 'Jeko Snejev', gender: 'male', age: 18}
        },
        {
            first: {name: 'Pesho Goshov', gender: 'male', age: 20},
            second: {name: 'Gosho Peshov', gender: 'male', age: 18}
        },
        {
            first: {name: 'Conor McGregor', gender: 'male', age: 29},
            second: {name: 'Floyd Mayweather', gender: 'male', age: 40}
        }]
);
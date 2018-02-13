function decryptMessage(str, text){
    let regexCoordinates = /(north|east)\D*(\d{2})([^,]*?),([^,]*?)(\d{6})/gi;
    let latitude;
    let longitude;
    let match = regexCoordinates.exec(text);
    while(match){
        if(match[1].toLowerCase()==='north'){
            latitude = match[2]+"."+match[5] + " N"
        }
        if(match[1].toLowerCase() === 'east'){
            longitude = match[2]+"."+match[5] + " E"
        }
        match = regexCoordinates.exec(text);
    }

    let regexMessage = new RegExp(`(?:${str})((?:.|\s)*)(?:${str})`, 'gm');
    let message = regexMessage.exec(text);

    console.log(latitude);
    console.log(longitude);
    console.log('Message: ' + message[1]);
}

// decryptMessage('4ds',
// 'eaSt 19,432567noRt north east 53,123456north 43,3213454dsNot all those who wander are\n'+
// 'lost.4dsnorth 47,874532' );

decryptMessage('<>',
    'o u%&lu43t&^ftgv><nortH4276hrv756dcc, jytbu64574655k <>ThE sanDwich is iN the\n' +
    'refrIGErator<>yl i75evEAsTer23,lfwe 987324tlblu6b\n');
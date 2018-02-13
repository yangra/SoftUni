function matchDates(str) {
    let regex = /\b([0-9]{1,2})-([A-Z][a-z]{2})-([0-9]{4})\b/gm;
    let match = regex.exec(str);
    while(match){
        console.log(`${match[0]} (Day: ${match[1]}, Month: ${match[2]}, Year: ${match[3]})`);
        match = regex.exec(str);
    }
}

matchDates('I am born on 30-Dec-1994.\n' +
    'This is not date: 512-Jan-1996.\n' +
    'My father is born on the 29-Jul-1955.');
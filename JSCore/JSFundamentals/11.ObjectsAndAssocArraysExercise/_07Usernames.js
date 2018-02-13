function orderUsernames(arr) {
    let usernames = new Set();
    for (let username of arr) {
        usernames.add(username);
    }
    let sortedSet = [...usernames.keys()].sort((a, b) => {
        if (a.length !== b.length)
            return a.length - b.length;
        return a.localeCompare(b);
    });
    for (let uname of sortedSet) {
        console.log(uname);
    }
}

orderUsernames(['Ashton',
    'Kutcher',
    'Ariel',
    'Lilly',
    'Keyden',
    'Aizen',
    'Billy',
    'Braston']);

orderUsernames(['Denise',
'Ignatius',
'Iris',
'Isacc',
'Indie',
'Dean',
'Donatello',
'Enfuego',
'Benjamin',
'Biser',
'Bounty',
'Renard',
'Rot'])
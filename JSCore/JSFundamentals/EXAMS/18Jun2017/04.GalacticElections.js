function getResults(arr) {
    let galaxies = {};
    for (let vote of arr) {
        let system = vote['system'];
        let candidate = vote['candidate'];
        let votes = vote['votes'];
        if (galaxies.hasOwnProperty(system)) {
            if (galaxies[system].hasOwnProperty(candidate)) {
                galaxies[system][candidate] += votes;
            } else {
                galaxies[system][candidate] = votes;
            }
        } else {
            galaxies[system] = {};
            galaxies[system][candidate] = votes;
        }
    }

    let result = {};
    let totalVotes = 0;
    for (let key in galaxies) {
        let sortedCandidates = Object.keys(galaxies[key]).sort((a, b) => galaxies[key][b] - galaxies[key][a]);
        let votes = Object.values(galaxies[key]).reduce((a, b) => a + b);
        galaxies[key] = {'candidate': sortedCandidates[0], 'votes': votes};
        if (result.hasOwnProperty(sortedCandidates[0])) {
            result[sortedCandidates[0]] += votes;
            totalVotes += votes;
        } else {
            result[sortedCandidates[0]] = votes;
            totalVotes += votes;
        }
    }

    let sortedResult = Object.keys(result).sort((a, b) => result[b] - result[a]);
    let sortedGalaxies = Object.keys(galaxies).sort((a, b) => galaxies[b]['votes'] - galaxies[a]['votes']);
    if (result[sortedResult[0]] > totalVotes / 2 && sortedResult.length > 1) {
        console.log(`${sortedResult[0]} wins with ${result[sortedResult[0]]} votes`);
        console.log(`Runner up: ${sortedResult[1]}`);
        for (let key of sortedGalaxies) {
            if (galaxies[key]['candidate'] === sortedResult[1]) {
                console.log(`${key}: ${galaxies[key]['votes']}`);
            }
        }
    } else if (sortedResult.length === 1) {
        console.log(`${sortedResult[0]} wins with ${result[sortedResult[0]]} votes\n` +
            `${sortedResult[0]} wins unopposed!`);
    } else {
        let percentageFirst = Math.floor(result[sortedResult[0]] / totalVotes * 100);
        let percentageSecond = Math.floor(result[sortedResult[1]] / totalVotes * 100);
        console.log(`Runoff between ${sortedResult[0]} with ${percentageFirst}% and ${sortedResult[1]} with ${percentageSecond}%`);
    }
}

getResults([{system: 'Theta', candidate: 'Flying Shrimp', votes: 10},
    {system: 'Sigma', candidate: 'Space Cow', votes: 200},
    {system: 'Sigma', candidate: 'Flying Shrimp', votes: 120},
    {system: 'Tau', candidate: 'Space Cow', votes: 15},
    {system: 'Sigma', candidate: 'Space Cow', votes: 60},
    {system: 'Tau', candidate: 'Flying Shrimp', votes: 150}]
);

getResults([{system: 'Tau', candidate: 'Flying Shrimp', votes: 150},
    {system: 'Tau', candidate: 'Space Cow', votes: 100},
    {system: 'Theta', candidate: 'Space Cow', votes: 10},
    {system: 'Sigma', candidate: 'Space Cow', votes: 200},
    {system: 'Sigma', candidate: 'Flying Shrimp', votes: 75},
    {system: 'Omicron', candidate: 'Flying Shrimp', votes: 50},
    {system: 'Omicron', candidate: 'Octocat', votes: 75}]);

getResults([{system: 'Theta', candidate: 'Kim Jong Andromeda', votes: 10},
    {system: 'Tau', candidate: 'Kim Jong Andromeda', votes: 200},
    {system: 'Tau', candidate: 'Flying Shrimp', votes: 150}]
);

getResults([{system: 'Theta', candidate: 'Kim Jong Andromeda', votes: 10},
    {system: 'Tau', candidate: 'Kim Jong Andromeda', votes: 200},
    {system: 'Tau', candidate: 'Flying Shrimp', votes: 150}]
);
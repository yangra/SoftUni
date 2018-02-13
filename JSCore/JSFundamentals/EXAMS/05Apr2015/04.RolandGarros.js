function tennisResults(arr) {
    let allPlayersStatistics = {};
    for (let str of arr) {
        let [players, results] = str.split(/\s*:\s*/).filter(s => s !== '');
        let [player1, player2] = players.split(/\s*vs.\s*/).filter(s => s !== '');
        let sets = results.split(/\s+/).filter(s => s !== '');
        player1 = player1.replace(/\s+/g, ' ').trim();
        player2 = player2.replace(/\s+/g, ' ').trim();
        let player1WonSets = 0;
        let player2WonSets = 0;
        let player1WonGames = 0;
        let player2WonGames = 0;
        for (let res of sets) {
            let [first, second] = res.split(/-/).filter(s => s !== '').map(Number);
            player1WonGames += first;
            player2WonGames += second;
            if (first > second) {
                player1WonSets++;
            } else {
                player2WonSets++;
            }
        }
        let winner = player1WonSets > player2WonSets ? player1 : player2;
        if (allPlayersStatistics.hasOwnProperty(player1)) {
            allPlayersStatistics[player1]["matchesWon"] += winner === player1 ? 1 : 0;
            allPlayersStatistics[player1]["matchesLost"] += winner === player1 ? 0 : 1;
            allPlayersStatistics[player1]["setsWon"] += player1WonSets;
            allPlayersStatistics[player1]["setsLost"] += player2WonSets;
            allPlayersStatistics[player1]["gamesWon"] += player1WonGames;
            allPlayersStatistics[player1]["gamesLost"] += player2WonGames;
        } else {
            allPlayersStatistics[player1] = {};
            allPlayersStatistics[player1]["name"] = player1;
            allPlayersStatistics[player1]["matchesWon"] = winner === player1 ? 1 : 0;
            allPlayersStatistics[player1]["matchesLost"] = winner === player1 ? 0 : 1;
            allPlayersStatistics[player1]["setsWon"] = player1WonSets;
            allPlayersStatistics[player1]["setsLost"] = player2WonSets;
            allPlayersStatistics[player1]["gamesWon"] = player1WonGames;
            allPlayersStatistics[player1]["gamesLost"] = player2WonGames;
        }

        if (allPlayersStatistics.hasOwnProperty(player2)) {
            allPlayersStatistics[player2]["matchesWon"] += winner === player1 ? 0 : 1;
            allPlayersStatistics[player2]["matchesLost"] += winner === player1 ? 1 : 0;
            allPlayersStatistics[player2]["setsWon"] += player2WonSets;
            allPlayersStatistics[player2]["setsLost"] += player1WonSets;
            allPlayersStatistics[player2]["gamesWon"] += player2WonGames;
            allPlayersStatistics[player2]["gamesLost"] += player1WonGames;
        } else {
            allPlayersStatistics[player2] = {};
            allPlayersStatistics[player2]["name"] = player2;
            allPlayersStatistics[player2]["matchesWon"] = winner === player1 ? 0 : 1;
            allPlayersStatistics[player2]["matchesLost"] = winner === player1 ? 1 : 0;
            allPlayersStatistics[player2]["setsWon"] = player2WonSets;
            allPlayersStatistics[player2]["setsLost"] = player1WonSets;
            allPlayersStatistics[player2]["gamesWon"] = player2WonGames;
            allPlayersStatistics[player2]["gamesLost"] = player1WonGames;
        }
    }

    let sortedKeys = Object.keys(allPlayersStatistics).sort((a, b) => {
        if (allPlayersStatistics[b]['matchesWon'] !== allPlayersStatistics[a]['matchesWon']) {
            return allPlayersStatistics[b]['matchesWon'] - allPlayersStatistics[a]['matchesWon'];
        }
        if (allPlayersStatistics[a]['setsWon'] !== allPlayersStatistics[b]['setsWon']) {
            return allPlayersStatistics[b]['setsWon'] - allPlayersStatistics[a]['setsWon'];
        }

        if (allPlayersStatistics[a]['gamesWon'] !== allPlayersStatistics[b]['gamesWon']) {
            return allPlayersStatistics[b]['gamesWon'] - allPlayersStatistics[a]['gamesWon'];
        }
        return a.localeCompare(b);
    });

    let result = '[';
    for (let key of sortedKeys) {
        result += JSON.stringify(allPlayersStatistics[key]) + ','
    }
    result = result.slice(0, result.length - 1);
    result += ']';

    console.log(result);
}

tennisResults(['Novak Djokovic vs. Roger Federer : 6-3 6-3',
    'Roger    Federer    vs.        Novak Djokovic    :         6-2 6-3',
    'Rafael Nadal vs. Andy Murray : 4-6 6-2 5-7',
    'Andy Murray vs. David     Ferrer : 6-4 7-6',
    'Tomas   Bedrych vs. Kei Nishikori : 4-6 6-4 6-3 4-6 5-7',
    'Grigor Dimitrov vs. Milos Raonic : 6-3 4-6 7-6 6-2',
    'Pete Sampras vs. Andre Agassi : 2-1',
    'Boris Beckervs.Andre        Agassi:2-1']);
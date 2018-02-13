function calculateResult(arr) {
    arr = arr.filter(a => a !== '');
    let request = arr[arr.length - 1].trim();
    let count = 0;
    let totalPoints = 0;
    for (let i = 0; i < arr.length - 1; i++) {
        let params = arr[i].split(/\s+/).filter(s=>s!=='');
        let [name, exam, examPoints, bonus] = params;
        if (request === exam) {
            totalPoints += Number(examPoints);
            count++;
        }
        if (Number(examPoints) < 100) {
            console.log(`${name} failed at "${exam}"`);
            continue;
        }

        let coursePoints = Math.round(((Number(examPoints) / 5 )+ Number(bonus)) * 100) / 100;
        let result = coursePoints > 80 ? (6).toFixed(2) : (Math.round((((coursePoints / 80) * 4) + 2) * 100) / 100).toFixed(2);
        console.log(`${name}: Exam - "${exam}"; Points - ${coursePoints}; ` +
            `Grade - ${result }`);
    }

    console.log(`"${request}" average points -> ${Math.round((totalPoints / count) * 100) / 100}`);
}

calculateResult(['Pesho C#-Advanced 100 3',
    'Gosho Java-Basics 157 3',
    'Tosho HTML&CSS 317 12',
    'Minka C#-Advanced 57 15',
    'Stanka C#-Advanced 157 15',
    'Kircho C#-Advanced 300 0',
    'Niki C#-Advanced 400 10',
    'C#-Advanced']);
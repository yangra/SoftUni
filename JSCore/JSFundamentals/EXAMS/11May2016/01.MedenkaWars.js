function getWinnerStats(arr) {
    let naskor = 0;
    let vitkor = 0;
    let vitkorAttcks = 0;
    let naskorAttacks = 0;
    let attackStrengthVitkor = -1;
    let attackStrengthNaskor = -1;

    for (let str of arr) {
        let params = str.split(/\s+/).filter(s => s !== '');
        let damageCoef = Number(params[0]);
        let player = params[1];
        if (player === 'white') {
            vitkor += damageCoef * 60;
            if (attackStrengthVitkor === damageCoef) {
                vitkorAttcks++;
            } else {
                vitkorAttcks = 1;
                attackStrengthVitkor = damageCoef
            }

            if (vitkorAttcks === 2) {
                vitkorAttcks = 0;
                attackStrengthVitkor = -1;
                vitkor += damageCoef * 60 * 1.75;
            }
        } else if(player === 'dark') {
            naskor += damageCoef * 60;
            if (attackStrengthNaskor === damageCoef) {
                naskorAttacks++;
            } else {
                naskorAttacks = 1;
                attackStrengthNaskor = damageCoef
            }

            if (naskorAttacks === 5) {
                naskorAttacks = 0;
                attackStrengthNaskor = -1;
                naskor += damageCoef * 60 * 3.5;
            }
        }
    }

    if(naskor > vitkor){
        console.log('Winner - Naskor');
        console.log(`Damage - ${naskor}`);
    } else{
        console.log('Winner - Vitkor');
        console.log(`Damage - ${vitkor}`);
    }
}

getWinnerStats(['5 white medenkas',
    '5 dark medenkas',
    '4 white medenkas']);

getWinnerStats(['2 dark medenkas',
    '1 white medenkas',
    '2 dark medenkas',
    '2 dark medenkas',
    '15 white medenkas',
    '2 dark medenkas',
    '2 dark medenkas',
'']);
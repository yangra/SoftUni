function bestMarketer(arr) {
    let people = new Map();
    for (let param of arr) {
        if (param.indexOf('-') !== -1) {
            let subs = param.split(/-/).filter(s=>s!=='');
            if(people.has(subs[0])&&people.has(subs[1])&&subs[0]!==subs[1]){
                people.get(subs[1]).push(subs[0]);
            }
        } else {
            if (!people.has(param)) {
                people.set(param, []);
            }
        }
    }

    let sortedBySubs = Array.from(people.keys()).sort((a,b)=>{
        if(people.get(b).length!==people.get(a).length){
            return people.get(b).length - people.get(a).length;
        }else{
            let ASubsTo = 0;
            let BSubsTo = 0;
            for (let [key, value] of people) {
                if(value.indexOf(a)!==-1){
                    ASubsTo++;
                }
                if(value.indexOf(b)!==-1){
                    BSubsTo++;
                }
            }
            if(ASubsTo>BSubsTo){
                return -1;
            }else if(ASubsTo<BSubsTo){
                return 1;
            }else{
                return 0;
            }
        }
    });

    console.log(sortedBySubs[0]);
    let counter = 1;
    for (let sub of people.get(sortedBySubs[0])) {
        console.log(counter+ '. '+sub);
        counter++;
    }
}

bestMarketer(['A',
    'B',
    'C',
    'D',
    'A-B',
    'B-A',
    'A-A',
    'D-A']);

bestMarketer(['J',
'G',
'P',
'R',
'C',
'J-G',
'G-J',
'P-R',
'R-P',
'C-J']);
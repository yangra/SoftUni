function sortAlphabetically(arr) {
    let result = {};
    arr.sort();
    for (let entry of arr) {
        let firstLetter = entry.charAt(0);
        entry = entry.replace(' : ', ': ');
        if(result.hasOwnProperty(firstLetter)){
            result[firstLetter].push(entry);
        }else{
            result[firstLetter] = [];
            result[firstLetter].push(entry);
        }

    }

    for (let obj in result) {
        console.log(obj);
        for (let entry of result[obj]) {
            console.log('  '+ entry);
        }
    }
}

sortAlphabetically(['Appricot : 20.4',
    'Fridge : 1500',
    'TV : 1499',
    'Deodorant : 10',
    'Boiler : 300',
    'Apple : 1.25',
    'Anti-Bug Spray : 15',
    'T-Shirt : 10']);
function countWords(arr) {
    let result = {};
    for (let str of arr) {
        let currentWords = str.split(/[^0-9a-zA-Z_]+/).filter(s => s !== '');
        for (let word of currentWords) {
            if(!result.hasOwnProperty(word)){
                result[word] = 1;
            }else{
                result[word]++;
            }
        }
    }

    console.log(JSON.stringify(result));
}

countWords(['Far too slow, you\'re far too slow.']);
countWords(['JS devs use Node.js for server-side JS.-- JS for devs']);
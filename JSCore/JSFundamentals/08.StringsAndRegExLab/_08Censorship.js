function censor(text, arr){
    for (let str of arr) {
        let regex = new RegExp(str, 'g');
        let dashes = '-'.repeat(str.length);
        text = text.replace(regex, dashes);
    }
    
    console.log(text);
}

censor('roses are red, violets are blue', [', violets are', 'red']);
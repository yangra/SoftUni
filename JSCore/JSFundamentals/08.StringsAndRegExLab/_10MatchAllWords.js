function matchWords(str){
    let regex = /[a-zA-Z0-9_]+/g;
    console.log(str.match(regex).join('|'));
}

matchWords('A Regular Expression needs to have the global flag in order to match all occurrences in the text')
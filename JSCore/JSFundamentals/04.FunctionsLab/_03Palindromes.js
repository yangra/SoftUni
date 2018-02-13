function isPalindome(word) {
    let reversed = word.split('').reverse().join('');
    if( reversed === word){
        return true;
    }
    return false;
}

let pal = isPalindome('abcccba');
console.log(pal);
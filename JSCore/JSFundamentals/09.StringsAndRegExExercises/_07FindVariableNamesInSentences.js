function findNames(text) {
    let regex = /\b_([a-zA-Z0-9]+)\b/g;
    let match = regex.exec(text);
    let output = [];
    while(match){
       output.push(match[1]) ;
       match = regex.exec(text);
    }

    console.log(output.join(','));
}

findNames('The _id and _age variables are both integers.');
findNames('Calculate the _area of the _perfectRectangle object.');
findNames('__invalidVariable _evenMoreInvalidVariable_ _validVariable');
function extractText(str) {
    let result = [];
    let start = 0;
    while(start>-1) {
        let start = str.indexOf('(');
        let end = str.indexOf(')');
        if(end<0|| end< start){
            break;
        }
        result.push(str.substring(start+1,end));
        str = str.substring(end+1);
    }

    console.log(result.join(', '));
}

extractText('Rakiya (Bulgarian brandy) is self-made liquor (alcoholic drink)');
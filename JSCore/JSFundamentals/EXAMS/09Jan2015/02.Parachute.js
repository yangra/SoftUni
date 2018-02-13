function jump(arr) {
    let rowIndex, colIndex;
    for (let row = 0; row < arr.length; row++) {
        colIndex = arr[row].indexOf('o');
        if(colIndex !== -1){
            rowIndex = row;
            break;
        }
    }

    for (let row = ++rowIndex; row < arr.length; row++) {
        let windForce = 0;
        for (let col = 0; col < arr[row].length; col++) {
            if(arr[row][col] === '<'){
                windForce--;
            }else if(arr[row][col] === '>'){
                windForce++
            }
        }
        colIndex+= windForce;
        if(arr[row][colIndex] === '_'){
            console.log('Landed on the ground like a boss!');
            console.log(`${rowIndex} ${colIndex}`);
            break;
        }
        if(arr[row][colIndex] === '|'||arr[row][colIndex] === '\\'||arr[row][colIndex] === '/'){
            console.log('Got smacked on the rock like a dog!');
            console.log(`${rowIndex} ${colIndex}`);
            break;
        }
        if(arr[row][colIndex] === '~'){
            console.log('Drowned in the water like a cat!');
            console.log(`${rowIndex} ${colIndex}`);
            break;
        }
        
        rowIndex++;
    }

}

jump(['--o----------------------',
    '>------------------------',
    '>------------------------',
    '>-----------------/\\-----',
    '-----------------/--\\----',
    '>---------/\\----/----\\---',
    '---------/--\\--/------\\--',
    '<-------/----\\/--------\\-',
    '\\------/----------------\\',
    '-\\____/------------------']);

jump([ '-------------o-<<--------',
    '-------->>>>>------------',
    '---------------->-<---<--',
    '------<<<<<-------/\\--<--',
    '--------------<--/-<\\----',
    '>>--------/\\----/<-<-\\---',
    '---------/<-\\--/------\\--',
    '<-------/----\\/--------\\-',
    '\\------/--------------<-\\',
    '-\\___~/------<-----------' ]);
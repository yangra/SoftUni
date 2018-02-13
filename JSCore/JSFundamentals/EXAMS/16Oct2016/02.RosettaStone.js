function decryptMessage(arr){
    let templateRows = Number(arr.shift());
    let template = [];
    let coded = [];

    for (let i = 0; i < templateRows; i++) {
        template.push(arr.shift().split(/\s+/));
    }


    for (let obj of arr) {
        coded.push(arr.shift().split(/\s+/));
    }
    console.log();
    for (let i=0; i<arr.length;i++) {
        coded.push(arr[i].split(/\s+/));
    }

    let stone = ' ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    let output = '';
    for (let i = 0; i < coded.length; i++) {
        for (let j = 0; j < coded[0].length; j++) {
            coded[i][j] = Number(coded[i][j])+Number(template[i%template.length][j%template[0].length]);
            coded[i][j] = stone[coded[i][j]%27];
            output+=coded[i][j];
        }
    }

    console.log(output);
}

// decryptMessage([ '2',
//     '59 36',
//     '82 52',
//     '4 18 25 19 8',
//     '4 2 8 2 18',
//     '23 14 22 0 22',
//     '2 17 13 19 20',
//     '0 9 0 22 22' ]);

decryptMessage(['1',
'1 3 13',
'12 22 14 13 25 0 4 24 23',
'18 24 2 25 22 0 0 11 18',
'8 25 6 26 8 23 13 4 14',
'14 3 14 10 6 1 6 16 14',
'11 12 2 10 24 2 13 24 0',
'24 24 10 14 15 25 18 24 12',
'4 24 0 8 4 22 19 22 14',
'0 11 18 26 1 19 18 13 15'])
//'8 15 14 26 24 14 26 24 14'])
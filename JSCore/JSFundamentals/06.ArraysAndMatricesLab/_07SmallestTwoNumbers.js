function printSmallestTwoNums(array){
    array.sort((a,b)=> a-b);
    console.log(array.slice(0, 2).join(' '));
}

printSmallestTwoNums([30,15,50,5])
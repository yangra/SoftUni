function processOddNumbers(array) {
    let result = array.filter((e, i) => i % 2 !== 0).map(e => e * 2).reverse();
    console.log(result.join(' '));
}

processOddNumbers([3, 0, 10, 4, 7, 3]);
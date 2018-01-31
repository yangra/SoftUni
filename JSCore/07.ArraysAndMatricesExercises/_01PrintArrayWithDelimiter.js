function printWithDelimiter(array) {
    let delimiter = array[array.length - 1];
    let values = array.slice(0, array.length - 1);
    console.log(values.join(delimiter));
}

printWithDelimiter(['addd', 'remove', 'absorb', '-']);
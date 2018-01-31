function printNthElement(array) {
    let step = Number(array.pop());
    array.filter((e, i) => i % step === 0).forEach(e => console.log(e));
}

printNthElement(['abc', 2, 3, 'bcd', 5, 3]);
function evenPosition(array) {
    console.log(array.filter((e, i) => i % 2 === 0).join(' '));
}

evenPosition([1, 2, 3, 4, 5]);
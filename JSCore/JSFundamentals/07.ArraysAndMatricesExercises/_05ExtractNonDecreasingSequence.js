function extractSequence(array) {
    let result = [];
    let currentMax = array[0];
    result.push(array[0]);
    for (let i = 1; i < array.length; i++) {
        if (array[i] >= currentMax) {
            result.push(array[i]);
            currentMax = array[i];
        }
    }

    result.forEach(e => console.log(e));
}

extractSequence([1, 3, 8, 4, 10, 12, 3, 2, 24]);
extractSequence([20, 3, 2, 15, 6, 1]);
extractSequence([1, 2, 3, 4]);

function sortArray(inputArr, sortMethod) {
    let ascendingComparator = (a, b) => a - b;
    let descendingComparator = (a, b) => b - a;

    let sortingMetods = {
        'asc': ascendingComparator,
        'desc': descendingComparator
    }

    return inputArr.sort(sortingMetods[sortMethod]);
}

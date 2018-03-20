function mapSort(map, sortFunc) {
    let sortedKeys;
    if (sortFunc !== undefined) {
        sortedKeys = Array.from(map.entries()).sort(sortFunc).map(a=>a[0]);
        console.log(sortedKeys);
    } else if (Array.from(map.keys()).filter(a => typeof a === 'number').length > 0) {
        sortedKeys = Array.from(map.keys()).sort((a, b) => a - b);
    } else {
        sortedKeys = Array.from(map.keys()).sort((a, b) => a.localeCompare(b));
    }

    let result = new Map();
    for (let key of sortedKeys) {
        result.set(key, map.get(key));
    }
    return result;
}

module.exports = mapSort;
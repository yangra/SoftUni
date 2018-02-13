function getFirstAndLast(array) {
    let n  = Number(array.shift());
    console.log(array.slice(0, n));
    console.log(array.slice(array.length - n));
}
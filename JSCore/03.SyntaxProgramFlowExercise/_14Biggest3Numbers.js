function biggestNum(input) {
    let [a, b, c] = input;
    console.log(Math.max(a, b, c));
}

biggestNum([5, -2, 7]);
biggestNum([130, 5, 99]);
biggestNum([43, 43.1, 43.2]);
biggestNum([5, 5, 5]);
biggestNum([-10, -20, -30]);
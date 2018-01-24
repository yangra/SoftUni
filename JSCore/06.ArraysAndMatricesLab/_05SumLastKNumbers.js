function sumLastKNumbers(n, k) {
    let result = [1];
    for (let i = 1; i < n; i++) {
        result.push(result.slice(result.length - k >= 0 ? result.length - k : 0).reduce((a, b) => a + b));
    }
    console.log(result.join(' '));
}

sumLastKNumbers(8, 2);

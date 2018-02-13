function calculator(a, b, symbol) {
    let add = function (m, n) {
        return m + n;
    };
    let subtract = function (m, n) {
        return m - n;
    };
    let multiply = function (m, n) {
        return m * n;
    };
    let divide = function (m, n) {
        return m / n;
    };

    switch (symbol){
        case '+': return add(a,b);
        case '-': return subtract(a,b);
        case '*': return multiply(a,b);
        case '/': return divide(a,b);
    }
}
function currencyFormatter(separator, symbol, symbolFirst, value) {
    let result = Math.trunc(value) + separator;
    result += value.toFixed(2).substr(-2, 2);
    if (symbolFirst) return symbol + ' ' + result;
    else return result + ' ' + symbol;
}

function predefined(func) {
    function dollarFormatter(value) {
        return func(',', '$', true, value);
    }

    return dollarFormatter;
}

let result = predefined(currencyFormatter);
console.log(result(1000.34444444));
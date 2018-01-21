function rounding(input) {
    let [number, precision] = input;
    if (precision > 15) {
        precision = 15;
    }
    let multiplier = Math.pow(10, precision);
    console.log(Math.round(number * multiplier) / multiplier);
}

rounding([3.15546546546464665, 2]);
rounding([10.5, 3]);
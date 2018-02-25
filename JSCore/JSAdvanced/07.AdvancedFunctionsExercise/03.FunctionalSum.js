let adder = (function add() {

    let sum = 0;

    function inc(num) {
        sum += num;
        return inc;
    }

    inc.toString = function () {
        return sum;
    };

    return inc;
})();


console.log(adder(1)(2)(3).toString());
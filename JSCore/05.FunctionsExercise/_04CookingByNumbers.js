function cookByNumbers(params) {

    let number = Number(params[0]);

    for (let i = 1; i < params.length; i++) {
        number = performOperation(number, getOperation(params[i]));
        console.log(number);
    }

    function performOperation(num, func) {
        return func(num);
    }

    function getOperation(operation) {
        switch (operation) {
            case 'chop':
                return x => x / 2;
            case 'dice':
                return x => Math.sqrt(x);
            case 'spice':
                return x => x + 1;
            case 'bake':
                return x => x * 3;
            case 'fillet':
                return x => x - (0.2 * x);

        }
    }
}

cookByNumbers(['32', 'chop','chop','chop','chop','chop']);
cookByNumbers(['9', 'dice', 'spice', 'chop', 'bake', 'fillet']);
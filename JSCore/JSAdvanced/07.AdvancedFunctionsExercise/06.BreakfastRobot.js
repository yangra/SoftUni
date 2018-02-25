() => {

    let stock = {
        protein: 0,
        carbohydrate: 0,
        fat: 0,
        flavour: 0
    };

    let recipes = {
        apple: {protein: 0, carbohydrate: 1, fat: 0, flavour: 2},
        coke: {protein: 0, carbohydrate: 10, fat: 0, flavour: 20},
        burger: {protein: 0, carbohydrate: 5, fat: 7, flavour: 3},
        omelet: {protein: 5, carbohydrate: 0, fat: 1, flavour: 1},
        cheverme: {protein: 10, carbohydrate: 10, fat: 10, flavour: 10}
    };

    let commandExecutor = {
        restock: (microelement, quantity) => {
            stock[microelement] += quantity;
            return 'Success';
        },
        prepare: (recipe, quantity) => {
            if (recipes[recipe]['protein'] * quantity > stock['protein']) {
                return 'Error: not enough protein in stock';
            }
            if (recipes[recipe]['carbohydrate'] * quantity > stock['carbohydrate']) {
                return 'Error: not enough carbohydrate in stock';
            }
            if (recipes[recipe]['fat'] * quantity > stock['fat']) {
                return 'Error: not enough fat in stock';
            }
            if (recipes[recipe]['flavour'] * quantity > stock['flavour']) {
                return 'Error: not enough flavour in stock';
            }

            stock['protein'] -= recipes[recipe]['protein'] * quantity;
            stock['carbohydrate'] -= recipes[recipe]['carbohydrate'] * quantity;
            stock['fat'] -= recipes[recipe]['fat'] * quantity;
            stock['flavour'] -= recipes[recipe]['flavour'] * quantity;
            return 'Success';
        },
        report: () => {
            return `protein=${stock['protein']} carbohydrate=${stock['carbohydrate']} ` +
                `fat=${stock['fat']} flavour=${stock['flavour']}`;
        }
    };

    return function (str) {
        let params = str.split(' ').filter(s => s !== '');
        let command = params.shift();
        if (params.length > 0) {
            let firstParam = params.shift();
            let quantity = Number(params[0]);
            return commandExecutor[command](firstParam, quantity);
        } else {
            return commandExecutor[command]();
        }
    }
};

solution('restock carbohydrate 10');
solution('restock flavour 10');
solution('prepare apple 1');
solution('restock fat 10');
solution('prepare burger 1');
solution('report');

solution('prepare cheverme 1');
solution('restock protein 10');
solution('prepare cheverme 1');
solution('restock carbohydrate 10');
solution('prepare cheverme 1');
solution('restock fat 10');
solution('prepare cheverme 1');
solution('restock flavour 10');
solution('prepare cheverme 1');
solution('report');
function producedCars(arr) {
    let carsByBrand = new Map();
    for (let str of arr) {
        let [brand, model, quantity] = str.split(/\s*\|\s*/).filter(s => s !== '');
        if(carsByBrand.has(brand)){
            if(carsByBrand.get(brand).has(model)){
                carsByBrand.get(brand).set(model, carsByBrand.get(brand).get(model) + Number(quantity));
            }else{
                carsByBrand.get(brand).set(model, Number(quantity));
            }

        }else {
            carsByBrand.set(brand,new Map);
            carsByBrand.get(brand).set(model, Number(quantity));
        }
    }

    for (let [key, value] of carsByBrand) {
        console.log(key);
        for (let [model, quantity] of carsByBrand.get(key)) {
            console.log(`###${model} -> ${quantity}`);
        }
    }
}

producedCars(['Audi | Q7 | 1000',
    'Audi | Q6 | 100',
    'BMW | X5 | 1000',
    'BMW | X6 | 100',
    'Citroen | C4 | 123',
    'Volga | GAZ-24 | 1000000',
    'Lada | Niva | 1000000',
    'Lada | Jigula | 1000000',
    'Citroen | C4 | 22',
    'Citroen | C5 | 10']);
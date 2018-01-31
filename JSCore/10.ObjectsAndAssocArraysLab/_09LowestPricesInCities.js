function lowestPrice(arr) {
    let products = new Map();
    for (let str of arr) {
        let [town, product, price] = str.split(/\s*\|\s*/).filter(s => s !== '');
        if (products.has(product)) {
            products.get(product).set(town, Number(price));
        } else {
            let townPrice = new Map();
            townPrice.set(town, Number(price));
            products.set(product, townPrice);
        }
    }


    for (let [product, prices] of products) {
        let sortedKeys = Array.from(products.get(product).keys()).sort((a,b)=>products.get(product).get(a)-products.get(product).get(b));
        console.log(product + ' -> '+`${products.get(product).get(sortedKeys[0])} (${sortedKeys[0]})`);
    }

}

lowestPrice(['Sample Town | Sample Product | 1000',
    'Sample Town | Orange | 2',
    'Sample Town | Peach | 1',
    'Sofia | Orange | 3',
    'Sofia | Peach | 2',
    'New York | Sample Product | 1000.1',
    'New York | Burger | 10']);
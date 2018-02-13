function findMaxProduct(arr) {
    let maxProduct = Number.NEGATIVE_INFINITY;
    for (let i = 0; i < arr.length; i++) {
        let number = Number(arr[i]);
        if (number > 0 && number < 10) {
            let product = 1;
            let start = 1;
            while (i + start < arr.length) {
                product *= arr[i + start];
                if (start === number) {
                    break;
                }
                start++;
            }
           if(maxProduct<product){
                maxProduct = product;
           }
        }
    }

    console.log(maxProduct);
}

findMaxProduct(['10',
    '20',
    '2',
    '30',
    '44',
    '3',
    '56',
    '20',
    '24']);

findMaxProduct(['100',
    '200',
    '2',
    '3',
    '2',
    '3',
    '2',
    '1',
    '1']);
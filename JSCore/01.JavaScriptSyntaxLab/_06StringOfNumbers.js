function stringOfNumbers(number){
    let concat = '';
    for (let i = 1; i <= number; i++) {
        concat += i;
    }

    return concat;
}

stringOfNumbers('11');
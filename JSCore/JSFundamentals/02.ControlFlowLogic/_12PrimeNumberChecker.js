function isPrime(num) {
    let prime = true;
    for (let digit = 2; digit <= Math.sqrt(num); digit++) {
        if (num % digit === 0) {
            prime = false;
            break;
        }
    }
    console.log(prime && num > 1);
}

isPrime(27);
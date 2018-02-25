function gcd(num1, num2) {
    if(num2 === 0){
        return num1;
    }
    let quotient  =  Math.floor(num1/num2);
    let remainder = num1%num2;
    return gcd(num2,remainder);
}

gcd(252, 105);

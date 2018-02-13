function solveEquation(a, b, c) {
    let discriminant = (b * b) - (4 * a * c);
    if (discriminant > 0) {
        let x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        let x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        console.log(Math.min(x1, x2));
        console.log(Math.max(x1, x2));
    } else if (discriminant === 0) {
        (b !== 0) ? console.log((-b) / (2 * a)) : console.log(0);
    } else {
        console.log('No');
    }
}


solveEquation(6,0,0);
solveEquation(1, -12, 36);
solveEquation(5, 2, 1);
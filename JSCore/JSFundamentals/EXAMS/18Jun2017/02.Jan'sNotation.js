function calculate(arr) {
    let numbers = [];
    for (let obj of arr) {
        if (typeof obj === 'number') {
            numbers.push(obj);
        } else {
            if (numbers.length > 1) {
                let num1 = numbers.pop();
                let num2 = numbers.pop();
                switch (obj) {
                    case '+':
                        numbers.push(num2 + num1);
                        break;
                    case '-':
                        numbers.push(num2 - num1);
                        break;
                    case '*':
                        numbers.push(num2 * num1);
                        break;
                    case '/':
                        numbers.push(num2 / num1);
                        break;
                    default:
                        break;
                }
            }else{
                console.log('Error: not enough operands!');
                return;
            }
        }
    }

    if (numbers.length === 1) {
        console.log(numbers[0]);
    } else {
        console.log('Error: too many operands!');
    }
}

calculate([15, '/']);
calculate([7, 33, 8, '-']);
calculate([5, 3, 4, '*', '-']);
calculate([31, 2, '+', 11, '/']);
calculate([-1, 1, '+', 101, '*', 18, '+', 3, '/']);
calculate([3, 4, '+']);
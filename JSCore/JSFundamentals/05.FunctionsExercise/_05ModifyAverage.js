function incAverage(number) {
    let numString = number.toString();
    while (true) {
        if (getAverage(number) > 5) {
            console.log(number);
            break;
        }
        numString += '9';
        number = Number(numString);
    }

    function getAverage(number) {
        let numbers = getNumbers(number);
        let sum = 0;
        for (let i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return sum / numbers.length;
    }

    function getNumbers(number) {
        let nums = [];
        for (let i = 0; number >= 1; i++) {
            nums[i] = number % 10;
            number = Math.floor(number / 10);

        }

        return nums;
    }
}

incAverage(101);
incAverage(5835);
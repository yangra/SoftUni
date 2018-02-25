function personalBMI(name, age, weight, height) {
    let result = {
        name: name,
        personalInfo: {
            age: Math.round(Number(age)),
            weight: Math.round(Number(weight)),
            height: Math.round(Number(height))
        },
        BMI: Math.round(Number(weight) / (Number(height)/100 *Number(height) / 100))
    };

    result['status'] = defineStatus(result['BMI']);
    if (result['status'] === 'obese') {
        result['recommendation'] = 'admission required';
    }

    return result;

    function defineStatus(BMI) {
        if (BMI < 18.5) {
            return 'underweight';
        } else if (BMI < 25) {
            return 'normal';
        } else if (BMI < 30) {
            return 'overweight';
        } else {
            return 'obese';
        }
    }
}

personalBMI('Peter', 29, 75, 182);
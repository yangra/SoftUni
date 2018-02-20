function subtract() {
    let firstField = document.getElementById('firstNumber');
    let secondField = document.getElementById('secondNumber');

    let num1 = Number(firstField.value);
    let num2 = Number(secondField.value);
    let result = num1-num2;

    document.getElementById('result').textContent = result.toString();

}
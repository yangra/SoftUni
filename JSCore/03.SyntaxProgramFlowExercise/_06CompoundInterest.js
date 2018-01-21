function calculateCompoundInterest(inputArray) {
    let [sum, interest, compPeriod, timeSpan] = inputArray;
    let compInterest = sum * Math.pow((1 + ((interest / 100) / (12 / compPeriod))), (12 / compPeriod) * timeSpan);
    console.log((compInterest));
}

calculateCompoundInterest([1500, 4.3, 3, 6]);
calculateCompoundInterest([100000, 5, 12, 25]);
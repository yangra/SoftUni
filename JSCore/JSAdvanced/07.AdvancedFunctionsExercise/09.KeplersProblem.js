function eccentricAnomaly(anomaly, ecc) {
    approximate(anomaly);

    function approximate(value) {
        let f = (value - ecc * Math.sin(value) - anomaly);

        if (Math.abs(f) <= Math.pow(10, -9)) {
            console.log(Math.round(value * Math.pow(10, 9)) / Math.pow(10, 9));
            return;
        }

        let newValue = value - (f / (1 - ecc * Math.cos(value)));

        approximate(newValue);
    }
}

eccentricAnomaly(1, 0);
eccentricAnomaly(3.1415926535, 0.75);
eccentricAnomaly(0.25, 0.99);
eccentricAnomaly(4.8, 0.2);

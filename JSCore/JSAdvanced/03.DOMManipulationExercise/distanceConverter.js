function attachEventsListeners() {
    let button = document.getElementById('convert');
    button.addEventListener('click', calcDistance);

    function calcDistance() {
        let firstSelection = document.getElementById('inputUnits').value;
        let secondSelection = document.getElementById('outputUnits').value;
        let input = document.getElementById('inputDistance').value;
        let output = document.getElementById('outputDistance');

        let inMM;
        switch (firstSelection) {
            case "km":
                inMM = Number(input) * 1000 * 1000;
                break;
            case "m":
                inMM = Number(input) * 1000;
                break;
            case "cm":
                inMM = Number(input) * 10;
                break;
            case "mm":
                inMM = Number(input);
                break;
            case "mi":
                inMM = Number(input) * 1609340;
                break;
            case "yrd":
                inMM = Number(input) * 914.4;
                break;
            case "ft":
                inMM = Number(input) * 304.8;
                break;
            case "in":
                inMM = Number(input) * 25.4;
                break;
        }

        let result;
        switch (secondSelection) {
            case "km":
                result = inMM / 1000 / 1000;
                break;
            case "m":
                result = inMM / 1000;
                break;
            case "cm":
                result = inMM / 10;
                break;
            case "mm":
                result = inMM;
                break;
            case "mi":
                result = inMM / 1609340;
                break;
            case "yrd":
                result = inMM / 914.4;
                break;
            case "ft":
                result = inMM / 304.8;
                break;
            case "in":
                result = inMM / 25.4;
                break;
        }

        output.value = result;
    }
}
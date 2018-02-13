function convertInches(inches) {
    let feet = Number.parseInt(inches / 12);
    inches = inches - feet * 12;
    console.log(`${feet}'-${inches}"`)
}

convertInches(36);
convertInches(55);
convertInches(11);
function spice(yield) {
    let spice = 0;
    let counter = 0;
    while (yield >= 100) {
        spice += yield;
        yield -= 10;
        spice -= 26;
        counter++;
    }

    if (counter !== 0) {
        spice -= 26;
    }
    console.log(counter);
    console.log(spice);
}

spice(111);
spice(450);
spice(200);
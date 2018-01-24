function shapeCrystals(params) {
    let targetSize = params[0];
    let operations = {
        'Cut': x => x / 4,
        'Lap': x => x * 0.8,
        'Grind': x => x - 20,
        'Etch': x => x - 2
    };


    for (let i = 1; i < params.length; i++) {
        let size = params[i];
        processCrystal(targetSize, size);

    }


    function processCrystal(targetSize, size) {
        console.log(`Processing chunk ${size} microns`);
        for (let key in operations) {
            let counter = 0;
            while (operations[key](size) >= targetSize || key === 'Etch' && size === targetSize + 1) {
                size = operations[key](size);
                counter++;
            }

            if (counter > 0) {
                console.log(key + ' x' + counter);
                size = Math.floor(size);
                console.log('Transporting and washing');
            }

            if (size === targetSize - 1) {
                console.log('X-ray x1');
                size += 1;
            }
        }
        console.log(`Finished crystal ${size} microns`);
    }
}


shapeCrystals([1000, 4000, 8100]);
shapeCrystals([1375, 50000]);
shapeCrystals([1375, 1376.5]);
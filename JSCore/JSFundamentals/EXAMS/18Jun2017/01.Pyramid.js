function pyramid(width, increment) {
    let lapis = 0;
    let marble = 0;
    let stone = 0;
    let gold = 0;

    let height = 1;
    for (let i = width; i >= 1; i -= 2) {
        if (i === 2) {
            gold += 4;
            break;
        }
        if (i === 1) {
            gold += 1;
            break;
        }
        let currentStone = (i - 2) * (i - 2);
        if (height % 5 === 0) {
            lapis += i * i - currentStone;
        } else {
            marble += i * i - currentStone;
        }
        stone += currentStone;
        height++;
    }

    console.log(`Stone required: ${Math.ceil(stone * increment)}`);
    console.log(`Marble required: ${Math.ceil(marble * increment)}`);
    console.log(`Lapis Lazuli required: ${Math.ceil(lapis * increment)}`);
    console.log(`Gold required: ${Math.ceil(gold * increment)}`);
    console.log(`Final pyramid height: ${Math.floor(height * increment)}`);
}

pyramid(11, 1);
pyramid(11, 0.75);
pyramid(12, 1);
pyramid(23, 0.5);
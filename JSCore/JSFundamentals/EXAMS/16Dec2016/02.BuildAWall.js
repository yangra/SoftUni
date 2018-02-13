function buildWall(arr) {
    let sum = 0;
    let result = [];
    while (arr.length !== 0) {
        let daily = 0;
        for (let i = 0; i < arr.length; i++) {
            if (arr[i] < 30) {
                daily += 195;
                arr[i]++;
            }
        }
        result.push(daily);
        arr = arr.filter(a => a < 30);
    }

    console.log(result.join(', '));
    console.log(result.reduce((a, b) => a + b) * 1900 + ' pesos');
}

buildWall([21, 25, 28]);
buildWall([17]);
buildWall([17, 22, 17, 19, 17]);
function isInside(points) {

    for (let i = 0; i < points.length - 2; i += 3) {
        let result = inVolume(points[i], points[i + 1], points[i + 2]);
        if (result) {
            console.log('inside');
        } else {
            console.log('outside');
        }
    }

    function inVolume(x, y, z) {
        let x1 = 10, x2 = 50;
        let y1 = 20, y2 = 80;
        let z1 = 15, z2 = 50;

        if (x >= x1 && x <= x2) {
            if (y >= y1 && y <= y2) {
                if (z >= z1 && z <= z2) {
                    return true;
                }
            }
        }

        return false;
    }
}

isInside([13.1, 50, 31.5, 50, 80, 50, -5, 18, 43]);
isInside([8, 20, 22]);
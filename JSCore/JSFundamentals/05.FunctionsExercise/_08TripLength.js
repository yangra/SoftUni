function findShortestPath(points) {
    let [x1, y1, x2, y2, x3, y3] = points;
    let result = '';
    let dist12 = calculateLength(x1, y1, x2, y2);
    let dist23 = calculateLength(x2, y2, x3, y3);
    let dist13 = calculateLength(x1, y1, x3, y3);
    let sum = 0;

    if ((dist12 <= dist13) && (dist13 => dist23)) {
        sum = dist12 + dist23;
        console.log('1->2->3: ' + sum);
    } else if ((dist12 <= dist23) && (dist13 < dist23)) {
        sum = dist13 + dist12;
        console.log('2->1->3: ' + sum);
    } else {
        sum = dist23 + dist13;
        console.log('1->3->2: ' + sum);
    }

    function calculateLength(x1, y1, x2, y2) {
        return Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
    }
}

findShortestPath([-1, -2, 3.5, 0, 0, 2]);
findShortestPath([5, 1, 1, 1, 5, 4]);
findShortestPath([0, 0, 2, 0, 4, 0]);

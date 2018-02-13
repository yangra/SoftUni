function pointPosition(coords) {
    let [x, y, xMin, xMax, yMin, yMax] = coords;
    if (x >= xMin && x <= xMax && y >= yMin && y <= yMax) {
        console.log('inside');
    }else{
        console.log('outside');
    }
}

pointPosition([8,-1,2,12,-3,3]);
pointPosition([12.5,-1,2,12,-3,3]);
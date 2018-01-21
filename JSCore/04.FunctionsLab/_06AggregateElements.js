function aggregateElements(array) {
    aggregate(0, (a, b) => {
        return a + b;
    });
    aggregate(0, (a, b) => {
        return a + 1 / b;
    });
    aggregate('', (a, b) => {
        return a + b;
    });

    function aggregate(initialValue, arrow) {
        for (var i = 0; i < array.length; i++) {
            initialValue = arrow(initialValue, array[i]);
        }
        console.log(initialValue);
    }
}

aggregateElements([1,2,3]);
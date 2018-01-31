function sort(array) {
    array.sort((e1, e2) => {
        if (e1.length === e2.length) {
            return e1 > e2;
        }
        return e1.length - e2.length;
    });

    console.log(array.join('\n'));
}

sort(['alpha', 'beta', 'gamma']);
sort(['Isacc','Theodor','Jack','Harrison','George']);
sort(['test', 'Deny', 'omen', 'Default']);
sort(['test', 'Deny','Deny', 'omen', 'Default']);
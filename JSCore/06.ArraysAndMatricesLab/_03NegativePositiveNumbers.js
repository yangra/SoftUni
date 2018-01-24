function arrange(array) {
    let result = [];
    for (let i = 0; i < array.length; i++) {
        let num = Number(array[i]);
        if (num >= 0) {
            result.push(num);
        } else {
            result.unshift(num);
        }
    }
    console.log(result.join('\n'));
}


sort([3,-2,0,-1]);
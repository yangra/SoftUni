function rotate(array) {
    let numberOfRotations = Number(array.pop())%array.length;
    for (let i = 0; i < numberOfRotations; i++) {
       let rotated =  array.pop();
       array.unshift(rotated);
    }
    console.log(array.join(' '));
}

rotate([1,2,3,4,2]);
rotate(['Banana','Orange','Coconut','Apple','15'])
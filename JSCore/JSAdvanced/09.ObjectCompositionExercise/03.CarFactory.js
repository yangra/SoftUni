function assembleCar(obj) {
    let car = {};
    car.model = obj.model;
    car.engine = {};
    if (obj.power <= 90) {
        car.engine.power = 90;
        car.engine.volume = 1800;
    } else if (obj.power <= 120) {
        car.engine.power = 120;
        car.engine.volume = 2400;
    } else {
        car.engine.power = 200;
        car.engine.volume = 3500;
    }

    car.carriage = {
        type: obj.carriage,
        color: obj.color
    };

    if (obj.wheelsize % 2 === 0) {
        obj.wheelsize -= 1;
    }

    obj.wheelsize = Math.trunc(obj.wheelsize);

    let arr = [];
    for (let i = 0; i < 4; i++) {
        arr.push(obj.wheelsize);
    }
    car.wheels = arr;
    return car;
}

let obj = {
    model: 'VW Golf II',
    power: 90,
    color: 'blue',
    carriage: 'hatchback',
    wheelsize: 14
};

console.log(assembleCar(obj));
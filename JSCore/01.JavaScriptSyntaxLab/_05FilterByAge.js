function filterByAge(minAge, nameA, ageA, nameB, ageB) {
    let a = {name: nameA, age: ageA};
    let b = {name: nameB, age: ageB};
    if (a.age >= minAge) console.log(a);
    if (b.age >= minAge) console.log(b);
}

filterByAge(12, 'Ivan', 15, 'Asen', 9);
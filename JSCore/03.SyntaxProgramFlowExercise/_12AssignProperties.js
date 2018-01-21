function assign(properties) {
    let output = {
        [properties[0]]: properties[1],
        [properties[2]]: properties[3],
        [properties[4]]: properties[5]
    };

    return output;
}

assign(['name', 'Pesho', 'age', '23', 'gender', 'male']);
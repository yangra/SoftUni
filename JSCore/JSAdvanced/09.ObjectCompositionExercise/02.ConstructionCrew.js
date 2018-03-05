function drink(obj) {
    if (obj['handsShaking']) {
        obj['bloodAlcoholLevel'] += obj['weight'] * obj['experience'] * 0.1;
        obj['handsShaking'] = false;
    }

    return obj;
}
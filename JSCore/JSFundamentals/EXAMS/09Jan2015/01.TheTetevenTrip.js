function trip(arr) {
    for (let str of arr) {
        let [model, fuel, route, luggage] = str.split(/\s+/).filter(s => s !== '');
        let consumption = 10;
        switch (fuel){
            case 'diesel':
                consumption *= 0.8;
                break;
            case 'petrol':
                consumption *= 1;
                break;
            case 'gas':
                consumption *= 1.2;
                break;
            default:
                continue;
        }
        consumption+= Number(luggage)*0.01;

        let quantity = 0;
        if(route === '1'){
            quantity += Math.round(consumption*(110/100) + (10/100)*(consumption*(30/100)));
        }else{
            quantity += Math.round(consumption*(95/100) + (30/100)*(consumption*(30/100)));
        }

        console.log(`${model} ${fuel} ${route} ${quantity}`);
    }
}

trip(['BMW petrol 1 320.5',
    'Golf petrol 2 150.75',
    'Lada gas 1 202',
    'Mercedes diesel 2 312.54',
'']);
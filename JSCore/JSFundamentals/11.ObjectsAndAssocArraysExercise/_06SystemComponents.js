function systemComponents(arr) {
    let systemsAndComponents = new Map();
    for (let str of arr) {
        let [system, component, subComponent] = str.split(/\s*\|\s*/).filter(s => s !== '');
        if (systemsAndComponents.has(system)) {
            if (!systemsAndComponents.get(system).has(component)) {
                systemsAndComponents.get(system).set(component, [])
            }
            systemsAndComponents.get(system).get(component).push(subComponent);
        } else {
            systemsAndComponents.set(system, new Map());
            systemsAndComponents.get(system).set(component, []);
            systemsAndComponents.get(system).get(component).push(subComponent);
        }
    }

    let orderedSystemKeys = Array.from(systemsAndComponents.keys()).sort((a, b) => {
        let compCountA = [...systemsAndComponents.get(a)].length;
        let compCountB = [...systemsAndComponents.get(b)].length;
        if (compCountA !== compCountB) {
            return compCountB - compCountA;
        }
        return a.localeCompare(b);
    });


    for (let key of orderedSystemKeys) {
        console.log(key);
        let components = systemsAndComponents.get(key);
        let sortedComponentsKeys = Array.from(components.keys()).sort((a, b) => [...components.get(b)].length - [...components.get(a)].length);
        for (let component of sortedComponentsKeys) {
            console.log('|||' + component);
            for (let subComponent of components.get(component)) {
                console.log('||||||' + subComponent);
            }
        }

    }
}

systemComponents(['SULS | Main Site | Home Page',
    'SULS | Main Site | Login Page',
    'SULS | Main Site | Register Page',
    'SULS | Judge Site | Login Page',
    'SULS | Judge Site | Submittion Page',
    'Lambda | CoreA | A23',
    'SULS | Digital Site | Login Page',
    'Lambda | CoreB | B24',
    'Lambda | CoreA | A24',
    'Lambda | CoreA | A25',
    'Lambda | CoreC | C4',
    'Indice | Session | Default Storage',
    'Indice | Session | Default Security']);
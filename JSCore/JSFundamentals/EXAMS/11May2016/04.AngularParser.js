function parseAngular(arr) {
    let modules = new Map();
    let elements = new Map();

    let appPattern = /^\$app='([^']+)'$/;
    let controllerPattern = /^\$controller='([^']+)'&app='([^']+)'$/;
    let modelPattern = /^\$model='([^']+)'&app='([^']+)'$/;
    let viewPattern = /^\$view='([^']+)'&app='([^']+)'$/;

    arr = arr.filter(e => e !== '');

    function newMapEntry(map, match) {
        map.set(match, new Map());
        map.get(match).set('controllers', new Set());
        map.get(match).set('models', new Set());
        map.get(match).set('views', new Set());
    }

    function addToMaps(match, type) {
        if (modules.has(match[2])) {
            modules.get(match[2]).get(type).add(match[1]);
        } else {
            if (elements.has(match[2])) {
                elements.get(match[2]).get(type).add(match[1]);
            } else {
                newMapEntry(elements, match[2]);
                elements.get(match[2]).get(type).add(match[1]);
            }
        }
    }

    for (let str of arr) {
        if (str.startsWith('$app')) {
            let match = appPattern.exec(str);
            newMapEntry(modules, match[1]);

            if (elements.has(match[1])) {
                modules.get(match[1]).set('controllers', elements.get(match[1]).get('controllers'));
                modules.get(match[1]).set('models', elements.get(match[1]).get('models'));
                modules.get(match[1]).set('views', elements.get(match[1]).get('views'));
                elements.delete(match[1]);
            }
            appPattern.lastIndex = 0;
        }

        if (str.startsWith('$controller')) {
            let match = controllerPattern.exec(str);
            addToMaps(match, 'controllers');
            controllerPattern.lastIndex = 0;
        }
        if (str.startsWith('$model')) {
            let match = modelPattern.exec(str);
            addToMaps(match, 'models');
            modelPattern.lastIndex = 0;
        }
        if (str.startsWith('$view')) {
            let match = viewPattern.exec(str);
            addToMaps(match, 'views');
            viewPattern.lastIndex = 0;
        }
    }

    let sortedModules = Array.from(modules.keys()).sort((a, b) => {
        if (modules.get(b).get('controllers').size !== modules.get(a).get('controllers').size) {
            return modules.get(b).get('controllers').size - modules.get(a).get('controllers').size;
        }
        if (modules.get(a).get('models').size !== modules.get(b).get('models').size) {
            return modules.get(a).get('models').size - modules.get(b).get('models').size;
        }
        return 0;
    });

    let output = '{';
    for (let module of sortedModules) {
        output += `"${module}":{"controllers":`;
        output += JSON.stringify(Array.from(modules.get(module).get('controllers').keys()).sort((a, b) => a.localeCompare(b)));
        output += ',"models":';
        output += JSON.stringify(Array.from(modules.get(module).get('models').keys()).sort((a, b) => a.localeCompare(b)));
        output += ',"views":';
        output += JSON.stringify(Array.from(modules.get(module).get('views').keys()).sort((a, b) => a.localeCompare(b)));
        output += '},';
    }
    output = output.substr(0, output.length - 1);
    output += '}';

    console.log(output);
}

parseAngular(['$app=\'MyApp\'',
    '$controller=\'My Controller\'&app=\'MyApp\'',
    '$model=\'My Model\'&app=\'MyApp\'',
    '$view=\'My View\'&app=\'MyApp\'']);

parseAngular(['$controller=\'PHPController\'&app=\'Language Parser\'',
    '$controller=\'JavaController\'&app=\'Language Parser\'',
    '$controller=\'C#Controller\'&app=\'Language Parser\'',
    '$controller=\'C++Controller\'&app=\'Language Parser\'',
    '$app=\'Garbage Collector\'',
    '$controller=\'GarbageController\'&app=\'Garbage Collector\'',
    '$controller=\'SpamController\'&app=\'Garbage Collector\'',
    '$app=\'Language Parser\'']);


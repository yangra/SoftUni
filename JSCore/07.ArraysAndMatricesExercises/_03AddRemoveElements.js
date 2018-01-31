function addRemoveElements(array) {
    let num = 1;
    let result = [];
    for (let i = 0; i < array.length; i++) {
        switch (array[i].toLowerCase()) {
            case 'add':
                result.push(num++);
                break;
            case 'remove':
                result.pop();
                num++;
                break;
            default:
                return 'error';
        }
    }

    result.length > 0 ? result.forEach(e => console.log(e)) : console.log('Empty');
}

addRemoveElements(['remve','remove','remove']);

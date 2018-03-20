let data = require('./data');

function sort(property) {
    if (data[0].hasOwnProperty(property)) {
        return data.sort((a, b) => {
            if (typeof a[property] === 'number') {
                return a[property] - b[property];
            } else {
                return a[property].localeCompare(b[property]);
            }
        });
    }
}

function filter(property, value) {
    if (data[0].hasOwnProperty(property)){
        return data.filter(o=>o[property] === value);
    }
}

module.exports = {sort, filter}
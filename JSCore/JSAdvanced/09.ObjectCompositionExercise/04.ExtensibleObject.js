function createObject() {
    let obj = {};
    obj.extend = function (template) {
        for (let key in template) {
            if(typeof template[key] === 'function'){
                obj.__proto__[key] = template[key];
                continue;
            }
            obj[key] = template[key];
        }
    };

    return obj;
}

result.extend({
    extensionMethod: function () {let a= 0; return a},
    extensionProperty: 'someString'
});
console.log(result);console.log(Object.getPrototypeOf(result));
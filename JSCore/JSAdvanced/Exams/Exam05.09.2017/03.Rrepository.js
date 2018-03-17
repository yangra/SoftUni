class Repository {
    constructor(props) {
        this.props = props;
        this.id = 0;
        this.data = new Map();
    }

    get count() {
        return this.data.size;
    }

    add(entity) {
        Repository._veryfyEntity(entity, this.props);
        this.data.set(this.id++, entity);
        return this.id - 1;
    }

    get(id) {
        Repository._verifyId(id, this.data);
        return this.data.get(id);
    }

    update(id, newEntity) {
        Repository._verifyId(id, this.data);
        Repository._veryfyEntity(newEntity, this.props);
        this.data.set(id, newEntity);
    }

    del(id) {
        Repository._verifyId(id, this.data);
        this.data.delete(id);
    }

    static _veryfyEntity(entity, props) {
        for (let prop in props) {
            if (!entity.hasOwnProperty(prop)) {
                throw new Error(`Property ${prop} is missing from the entity!`);
            }
            if (typeof entity[prop] !== props[prop]) {
                throw new Error(`Property ${prop} is of incorrect type!`);
            }
        }
    }

    static _verifyId(id, data) {
        if (typeof id !== 'number' || id < 0 || id >= data.size) {
            throw new Error(`Entity with id: ${id} does not exist!`);
        }
    }
}

// Initialize props object
let properties = {
    name: "string",
    age: "number",
    birthday: "object"
};
//Initialize the repository
let repository = new Repository(properties);
// Add two entities
let entity = {
    name: "Kiril",
    age: 19,
    birthday: new Date(1998, 0, 7)
};
repository.add(entity); // Returns 0
console.log(repository.add(entity)); // Returns 1
console.log(repository.get(0));
// {"name":"Kiril","age":19,"birthday":"1998-01-06T22:00:00.000Z"}
console.log(repository.get(1));
// {"name":"Kiril","age":19,"birthday":"1998-01-06T22:00:00.000Z"}
//Update an entity
entity = {
    name: 'Valio',
    age: 19,
    birthday: new Date(1998, 0, 7)
};
repository.update(1, entity);
console.log(repository.get(1));
// {"name":"Valio","age":19,"birthday":"1998-01-06T22:00:00.000Z"}
// Delete an entity
repository.del(0);
console.log(repository.count); // Returns 1
let anotherEntity = {
    name1: 'Nakov',
    age: 26,
    birthday: new Date(1991, 0, 21)
};
//repository.add(anotherEntity); // should throw an Error
anotherEntity = {
    name: 'Nakov',
    age: 26,
    birthday: 1991
};
//repository.add(anotherEntity); // should throw a TypeError
//repository.del(-1); // should throw Error for invalid id

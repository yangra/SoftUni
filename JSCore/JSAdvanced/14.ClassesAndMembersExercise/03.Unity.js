class Rat {
    constructor(name) {
        this.name = name;
        this.unitedRats = [];
    }

    unite(other) {
        if (other instanceof Rat) {
            this.unitedRats.push(other);
        }
    }

    getRats() {
        return this.unitedRats;
    }

    toString() {
        return this.name +'\n'+ this.unitedRats.map(s=>'##'+s.name).join('\n');
    }
}

let test = new Rat("Pesho");
console.log(test.toString());

console.log(test.getRats());

test.unite(new Rat("Gosho"));
test.unite(new Rat("Sasho"));
console.log(test.getRats());

console.log(test.toString());

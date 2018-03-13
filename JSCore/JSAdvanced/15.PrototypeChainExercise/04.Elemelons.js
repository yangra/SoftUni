function solve() {
    class Melon {
        constructor(weight, melonSort) {

            if (new.target === Melon) {
                throw new TypeError();
            }
            this.melonSort = melonSort;
            this.weight = weight;
        }

        toString() {
            return `Element: ${this.getType()}` + '\n' +
                `Sort: ${this.melonSort}` + '\n' +
                `Element Index: ${this.getElementIndex()}`
        }

        getType() {
            return this.constructor.name.slice(0,-5);
        }

        getElementIndex() {
            return this.elementIndex;
        }

    }

    class Watermelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.elementIndex = this.weight * this.melonSort.length;
        }
    }

    class Earthmelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.elementIndex = this.weight * this.melonSort.length;
        }
    }

    class Firemelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.elementIndex = this.weight * this.melonSort.length;
        }
    }

    class Airmelon extends Melon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.elementIndex = this.weight * this.melonSort.length;
        }
    }

    class Melolemonmelon extends Watermelon {
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.type = 'Water';
            this.types = ['Fire', 'Earth', 'Air', 'Water'];
        }

        morph() {
            this.type = this.types[0];
            let move = this.types.shift();
            this.types.push(move);
        }

        getType() {
            return this.type;
        }
    }

    return {Melon, Melolemonmelon, Watermelon, Airmelon, Earthmelon, Firemelon}
}

let sol = solve();

let Wat = sol.Watermelon;
let Fir = sol.Firemelon;
let Air = sol.Airmelon;
let Earth = sol.Earthmelon;
let Morph = sol.Melolemonmelon;

let mo = new Morph(15, 'dadida');
console.log(mo.toString());
mo.morph();
console.log(mo.toString());
mo.morph();
console.log(mo.toString());
mo.morph();
console.log(mo.toString());
mo.morph();
console.log(mo.toString());
mo.morph();
console.log(mo.toString());
mo.morph();
console.log(mo.toString());
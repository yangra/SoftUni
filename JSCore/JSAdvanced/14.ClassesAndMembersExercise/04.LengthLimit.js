class Stringer {
    constructor(string, length) {
        this.innerString = string;
        this.innerLength = length;
    }

    increase(value) {
        if (value < 0) {
            this.innerLength = 0;
            return;
        }
        this.innerLength += value;
    }

    decrease(value){
        this.innerLength -= value;
        if(this.innerLength<0){
            this.innerLength = 0;
        }
    }

    toString() {
        if (this.innerLength < this.innerString.length) {
            return this.innerString.slice(0,this.innerLength) + '...';
        }
        return this.innerString;
    }
}

let test = new Stringer("Test", 5);
console.log(test.toString()); //Test

test.decrease(3);
console.log(test.toString()); //Te...

test.decrease(5);
console.log(test.toString()); //...

test.increase(4);
console.log(test.toString()); //Test

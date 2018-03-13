class SortedList {
    constructor() {
        this.arr = [];
        this.size = 0;
    }

    add(element) {
        if (typeof element === 'number') {
            this.arr.push(element);
            this.arr.sort((a, b) => a - b);
            this.size++;
        }
    }


    remove(index) {
        if (index >= 0 && index < this.size) {
            this.arr.splice(index, 1);
            this.size--;
        }
    }

    get(index) {
        if (index >= 0 && index <= this.size) {
            return this.arr[index];
        }
    }

    get _size() {
        return this.size;
    }
}
let myList = new SortedList();
myList.add(5);
console.log(myList.get(0));//.to.equal(5, "Element wasn't added");

myList.add(3);
console.log(myList.get(0));//.to.equal(3, "Collection wasn't sorted");

myList.remove(0);
console.log(myList.get(0));//.to.equal(5, "Element wasn't removed");
console.log(myList.size);//.to.equal(1, "Element wasn't removed");
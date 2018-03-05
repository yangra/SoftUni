function sortedList() {
    let arr = [];
    return {
        add: function (element) {
            if (typeof element !== 'number') {
                throw new Error();
            }
            arr.push(element);
            arr.sort((a, b) => a - b);
            this.size++;
        },

        remove: function (index) {
            if (index < 0 || index >= arr.length) {
                throw new Error();
            }

            for (let i = index; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr.pop();
            this.size--;
        },

        get: function (index) {
            if (index < 0 || index >= arr.length) {
                throw new Error();
            }
            return arr[index];
        },
        size: arr.length
    }
}

let sorted = sortedList();
sorted.add(5);
console.log(sorted.size);
console.log(sorted.get(0));
sorted.add(3);
console.log(sorted.get(0));
console.log(sorted.size);
sorted.remove(0);
console.log(sorted.get(0));
console.log(sorted.size);


// expect(myList.hasOwnProperty('size')).to.equal(true, "Property size was not found");
//
// myList.add(5);
// expect(myList.get(0)).to.equal(5, "Element wasn't added");
//
// myList.add(3);
// expect(myList.get(0)).to.equal(3, "Collection wasn't sorted");
//
// myList.remove(0);
// expect(myList.get(0)).to.equal(5, "Element wasn't removed");
// expect(myList.size).to.equal(1, "Element wasn't removed");
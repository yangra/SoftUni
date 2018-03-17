let expect = require('chai').expect;
let SortedList = require('../02.SortedList');

describe('Testing SortedList class', function () {
    let sl;
    beforeEach(function () {
        sl = new SortedList();
    });

    it('is class initialized with all methods', function () {
        expect(SortedList.prototype.hasOwnProperty('add')).to.be.equal(true);
        expect(SortedList.prototype.hasOwnProperty('get')).to.be.equal(true);
        expect(SortedList.prototype.hasOwnProperty('remove')).to.be.equal(true);
        expect(SortedList.prototype.hasOwnProperty('size')).to.be.equal(true);
        expect(typeof sl.size).to.not.equal('function');
    });

    it('should add a number', function () {
        sl.add(12.2);
        expect(sl.get(0)).to.be.equal(12.2);
    });

    it('should add several elements', function () {
        sl.add(12.2);
        sl.add(18);
        sl.add(5);
        sl.add(77);
        expect(sl.size).to.be.equal(4);
    });

    it('should keep added elements sorted', function () {
        let result = [];
        sl.add(12.2);
        result.push(12.2);
        sl.add(18);
        result.push(18);
        sl.add(5);
        result.push(5);
        sl.add(77);
        result.push(77);
        result.sort((a, b) => a - b);
        for (let i = 0; i < result.length; i++) {
            expect(sl.get(i)).to.be.equal(result[i]);
        }
    });

    it('should keep elements sorted after remove', function () {
        sl.add(18);
        sl.add(5);
        sl.add(77);
        sl.remove(1);
        expect(sl.get(0)).to.be.equal(5);
        expect(sl.get(1)).to.be.equal(77);

    });

    it('should remove element at potsition', function () {
        sl.add(12.2);
        sl.add(18);
        sl.add(5);
        sl.add(77);
        let removed = sl.get(0);
        sl.remove(0);
        expect(sl.get(0)).to.be.equal(12.2);

    });

    it('should throw if collection is empty and get', function () {
        expect(() => {
            sl.get(1)
        }).to.throw(Error);
    });

    it('should throw if collection is empty and remove', function () {
        expect(() => {
            sl.remove(1)
        }).to.throw(Error);
    });

    it('should throw on invalid index get', function () {
        sl.add(12.2);
        sl.add(18);
        sl.add(5);
        sl.add(77);
        expect(() => {
            sl.get(12)
        }).to.throw(Error);
    });

    it('should throw on invalid index remove', function () {
        sl.add(12.2);
        sl.add(18);
        sl.add(5);
        sl.add(77);
        expect(() => {
            sl.remove(12)
        }).to.throw(Error);
    });
    it('should throw on negative index get', function () {
        sl.add(12.2);
        expect(() => {
            sl.get(-5)
        }).to.throw(Error);
    });

    it('should throw on negative index remove', function () {
        sl.add(12.2);
        expect(() => {
            sl.remove(-5)
        }).to.throw(Error);
    });

    it('should resize after remove', function () {
        sl.add(12.2);
        sl.add(5);
        sl.add(16);
        expect(sl.size).to.be.equal(3);
        sl.remove(1);
        expect(sl.size).to.be.equal(2);
    });

});
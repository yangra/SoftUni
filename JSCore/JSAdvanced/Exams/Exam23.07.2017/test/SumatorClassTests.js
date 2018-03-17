let expect = require('chai').expect;
let Sumator = require('../02.SumatorClass');

describe("List Functionality tests", function () {
    let sumator;
    beforeEach(function () {
        sumator = new Sumator();
    });

    it("should have all functions", function () {
        expect(Sumator.prototype.hasOwnProperty('add')).to.be.true;
        expect(typeof sumator.add === 'function').to.be.true;
        expect(Sumator.prototype.hasOwnProperty('sumNums')).to.be.true;
        expect(typeof sumator.sumNums === 'function').to.be.true;
        expect(Sumator.prototype.hasOwnProperty('removeByFilter')).to.be.true;
        expect(typeof sumator.removeByFilter === 'function').to.be.true;
        expect(Sumator.prototype.hasOwnProperty('toString')).to.be.true;
        expect(typeof sumator.toString === 'function').to.be.true;
        expect(sumator.hasOwnProperty('data')).to.be.true;
        expect(sumator.data.constructor).to.be.equal(Array);
    });

    it("should have all functions", function () {
        sumator.add(12);
        sumator.add('abc');
        sumator.add({a: 12});
        sumator.add([1, 2, 3]);
        expect(sumator.toString()).to.be.equal('12, abc, [object Object], 1,2,3');
    });

    it("should return (empty) on empty data", function () {
        expect(sumator.toString()).to.be.equal('(empty)');
    });

    it("should sum all numbers", function () {
        sumator.add(12);
        sumator.add('abc');
        sumator.add(5.6);
        sumator.add({a: 12});
        sumator.add([1, 2, 3]);
        expect(sumator.sumNums()).to.be.equal(17.6);
    });

    it("should return 0 on sumNums without numbers", function () {
        sumator.add('12');
        sumator.add('abc');
        sumator.add({a: 12});
        sumator.add([1, 2, 3]);
        expect(sumator.sumNums()).to.be.equal(0);
    });

    it("should filter objects out", function () {
        sumator.add('12');
        sumator.add('abc');
        sumator.add({a: 12});
        sumator.add([1, 2, 3]);
        sumator.removeByFilter(a => typeof a === 'object');
        expect(sumator.toString()).to.be.equal('12, abc');
    });

    it("should filter primitives out", function () {
        sumator.add('12');
        sumator.add('abc');
        sumator.add({a: 12});
        sumator.add([1, 2, 3]);
        sumator.removeByFilter(a => typeof a !== 'object');
        expect(sumator.toString()).to.be.equal('[object Object], 1,2,3');
    });

    it("should find nothing to filter out", function () {
        sumator.add('abc');
        sumator.add({a: 12});
        sumator.add([1, 2, 3]);
        sumator.removeByFilter(a => typeof a === 'number');
        expect(sumator.toString()).to.be.equal('abc, [object Object], 1,2,3');
    });
});
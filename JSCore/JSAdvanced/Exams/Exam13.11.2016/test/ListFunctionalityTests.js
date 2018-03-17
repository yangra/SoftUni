let expect = require('chai').expect;
let createList = require('../02.ListFunctionality');

describe("List Functionality tests", function() {
    let list;
    beforeEach(function () {
        list = createList();
    });
    it("should have all functions", function() {
        expect(list.hasOwnProperty('add')).to.be.true;
        expect(typeof list.add === 'function').to.be.true;
        expect(list.hasOwnProperty('shiftLeft')).to.be.true;
        expect(typeof list.shiftLeft === 'function').to.be.true;
        expect(list.hasOwnProperty('shiftRight')).to.be.true;
        expect(typeof list.shiftRight === 'function').to.be.true;
        expect(list.hasOwnProperty('swap')).to.be.true;
        expect(typeof list.swap === 'function').to.be.true;
        expect(list.hasOwnProperty('toString')).to.be.true;
        expect(typeof list.toString === 'function').to.be.true;
    });

    it("should add properly", function() {
        list.add({a:12});
        expect(list.toString()).to.be.equal('[object Object]');
    });
    it("should add properly", function() {
        list.add(12);
        expect(list.toString()).to.be.equal('12');
    });
    it("should add properly", function() {
        list.add([12,13,14]);
        expect(list.toString()).to.be.equal('12,13,14');
    });

    it("should add properly", function() {
        list.add('two');
        list.add(4);
        list.add({a:12});
        expect(list.toString()).to.be.equal("two, 4, [object Object]");
    });

    it("should add several values properly", function() {
        list.add(12);
        list.add(18);
        list.add('summer');
        expect(list.toString()).to.be.equal('12, 18, summer');
    });

    it("shift left should work properly", function() {
        list.add(12);
        list.add('two');
        list.add({a:4});
        list.shiftLeft();
        expect(list.toString()).to.be.equal('two, [object Object], 12');
    });

    it("shift right should work properly", function() {
        list.add(12);
        list.add('two');
        list.add({a:4});
        list.shiftRight();
        expect(list.toString()).to.be.equal('[object Object], 12, two');
    });

    it("equal indexes swap should return false", function() {
        list.add(12);
        list.add(18);
        list.add(21);
        expect(list.swap(2,2)).to.be.false;
        expect(list.toString()).to.be.equal('12, 18, 21');
    });

    it("non existing indexes swap should return false", function() {
        list.add(12);
        list.add(18);
        list.add(21);
        expect(list.swap(1,8)).to.be.false;
        expect(list.toString()).to.be.equal('12, 18, 21');
    });

    it("non existing indexes swap should return false", function() {
        list.add(12);
        list.add(18);
        list.add(21);
        expect(list.swap(8,1)).to.be.false;
        expect(list.toString()).to.be.equal('12, 18, 21');
    });

    it("negative first index swap should return false", function() {
        list.add(12);
        list.add(18);
        list.add(21);
        expect(list.swap(1,-8)).to.be.false;
        expect(list.toString()).to.be.equal('12, 18, 21');

    });

    it("negative second index swap should return false", function() {
        list.add(12);
        list.add(18);
        list.add(21);
        expect(list.swap(-5,1)).to.be.false;
        expect(list.toString()).to.be.equal('12, 18, 21');

    });
    it("non numeric first index swap should return false", function() {
        list.add(12);
        list.add(18);
        list.add(21);
        expect(list.swap('0',2)).to.be.false;
        expect(list.toString()).to.be.equal('12, 18, 21');

    });
    it("non numeric second index swap should return false", function() {
        list.add(12);
        list.add(18);
        list.add(21);
        expect(list.swap(0,'2')).to.be.false;
        expect(list.toString()).to.be.equal('12, 18, 21');

    });

    it("swap should work properly", function() {
        list.add(12);
        list.add(18);
        list.add(21);
        expect(list.swap(0,2)).to.be.true;
        expect(list.toString()).to.be.equal('21, 18, 12');

    });

    it("swap should work properly", function() {
        list.add(12);
        list.add(18);
        list.add(21);
        expect(list.swap(2,0)).to.be.true;
        expect(list.toString()).to.be.equal('21, 18, 12');

    });

    it("first index equal to length", function() {
        list.add(12);
        list.add(18);
        list.add(21);
        expect(list.swap(3,0)).to.be.false;
        expect(list.toString()).to.be.equal('12, 18, 21');

    });

    it("first index equal to length", function() {
        list.add(12);
        list.add(18);
        list.add(21);
        expect(list.swap(0,3)).to.be.false;
        expect(list.toString()).to.be.equal('12, 18, 21');

    });

});

let expect = require('chai').expect;
let makeList = require('../02.AddLeftRightClearList');

describe("List Functionality tests", function() {
    let list;
    beforeEach(function () {
        list = makeList();
    });

    it("should have all functions", function () {
        expect(list.hasOwnProperty('addLeft')).to.be.true;
        expect(typeof list.addLeft === 'function').to.be.true;
        expect(list.hasOwnProperty('addRight')).to.be.true;
        expect(typeof list.addRight === 'function').to.be.true;
        expect(list.hasOwnProperty('clear')).to.be.true;
        expect(typeof list.clear === 'function').to.be.true;
        expect(list.hasOwnProperty('toString')).to.be.true;
        expect(typeof list.toString === 'function').to.be.true;
    });

    it("should add to the left", function () {
        list.addLeft(12);
        list.addLeft({a:2});
        list.addLeft([1,2,3]);
        list.addLeft('str');
        expect(list.toString()).to.be.equal('str, 1,2,3, [object Object], 12');
    });

    it("should add to the right", function () {
        list.addRight(12);
        list.addRight({a:2});
        list.addRight([1,2,3]);
        list.addRight('str');
        expect(list.toString()).to.be.equal('12, [object Object], 1,2,3, str');
    });

    it("should clear properly", function () {
        list.addLeft(12);
        list.addLeft({a:2});
        list.addRight([1,2,3]);
        list.addRight('str');
        list.clear();
        expect(list.toString()).to.be.equal('');
    });

    it("should add to left and right", function () {
        list.addLeft(12);
        list.addLeft({a:2});
        list.addRight([1,2,3]);
        list.addRight('str');
        expect(list.toString()).to.be.equal('[object Object], 12, 1,2,3, str');
    });

});
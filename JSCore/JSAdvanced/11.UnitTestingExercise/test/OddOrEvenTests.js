let expect = require("chai").expect;
const isOddOrEven = require('../02.OddOrEven');

describe("IsOddOrEven", function() {
    it("should return even", function() {
        expect(isOddOrEven('ab')).to.be.equal('even');
    });
    it("should return odd", function() {
        expect(isOddOrEven('abc')).to.be.equal('odd');
    });

    it("should return undefined", function() {
        expect(isOddOrEven(undefined)).to.be.equal(undefined);
    });
});
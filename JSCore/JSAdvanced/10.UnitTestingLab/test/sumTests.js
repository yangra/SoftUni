let expect = require("chai").expect;

const SUM = require('../04.Sum');

describe("Sum tests", function() {
    it("should return 3 for [1, 2]", function() {
        expect(SUM([1, 2])).to.be.equal(3);
    });
    it("should return 1 for [1]", function() {
        expect(SUM([1])).to.be.equal(1);
    });
    it("should return 0 for []", function() {
        expect(SUM([])).to.be.equal(0);
    });
    it("should return 3.15 for [-1, 3.15, 1]", function() {
        expect(SUM([-1, 3.15, 1])).to.be.equal(3.15);
    });
    it("should return NaN for string", function() {
        expect(SUM('test')).to.be.NaN;
    });
});
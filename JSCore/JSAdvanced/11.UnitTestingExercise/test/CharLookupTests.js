let expect = require("chai").expect;

const lookupChar = require('../03.CharLookup');

describe("LookupChar", function() {
    it("should return undefined if first parameter is not a string", function () {
        expect(lookupChar(3,3)).to.be.equal(undefined);
    });
    it("should return undefined if first parameter is not a string", function () {
        expect(lookupChar({a:3},3)).to.be.equal(undefined);
    });
    it("should return undefined if first parameter is not a string", function () {
        expect(lookupChar(['ab'],3)).to.be.equal(undefined);
    });
    it("should return undefined if second parameter is not an integer", function () {
        expect(lookupChar('ab',3.5)).to.be.equal(undefined);
    });
    it("should return undefined if second parameter is not an integer", function () {
        expect(lookupChar('ab',3.5)).to.be.equal(undefined);
    });
    it("should return undefined if second parameter is not an integer", function () {
        expect(lookupChar('ab',[3])).to.be.equal(undefined);
    });
    it("should return undefined if no parameters are given", function () {
        expect(lookupChar()).to.be.equal(undefined);
    });
    it("should return Incorrect index if index is bigger than string length", function () {
        expect(lookupChar('ab', 3)).to.be.equal("Incorrect index");
    });
    it("should return Incorrect index if index is equal to string length", function () {
        expect(lookupChar('ab', 2)).to.be.equal("Incorrect index");
    });
    it("should return Incorrect index if index is negative", function () {
        expect(lookupChar('ab', -3)).to.be.equal("Incorrect index");
    });
    it("should return a when string 'ab' and index 0", function () {
        expect(lookupChar('ab', 0)).to.be.equal('a');
    });
    it("should return b when string 'ab' and index 1", function () {
        expect(lookupChar('ab', 1)).to.be.equal('b');
    });
});
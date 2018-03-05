let expect = require("chai").expect;

const rgbToHexColor = require('../06.RGBtoHEX');

describe("RGBtoHEXTests", function () {
    describe("Normal cases (valid input)", function () {
        it("should return #FFFFFF for 255, 255, 255", function () {
            expect(rgbToHexColor(255, 255, 255)).to.be.equal('#FFFFFF');
        });
        it("should return #000000 for 0, 0, 0", function () {
            expect(rgbToHexColor(0, 0, 0)).to.be.equal('#000000');
        });
        it("should return #7F0000 for 127, 0, 0", function () {
            expect(rgbToHexColor(127, 0, 0)).to.be.equal('#7F0000');
        });
        it("should return #007F00 for 0, 127, 0", function () {
            expect(rgbToHexColor(0, 127, 0)).to.be.equal('#007F00');
        });
        it("should return #00007F for 0, 0, 127", function () {
            expect(rgbToHexColor(0, 0, 127)).to.be.equal('#00007F');
        });
    });
    describe("Special cases (invalid input)", function () {
        it("should return undefined for 'red', 255, 255", function () {
            expect(rgbToHexColor('red', 255, 255)).to.be.equal(undefined);
        });
        it("should return undefined for '255', green, 255", function () {
            expect(rgbToHexColor('255', 'green', 255)).to.be.equal(undefined);
        });
        it("should return undefined for 255, 255, 'blue'", function () {
            expect(rgbToHexColor(255, 255, 'blue')).to.be.equal(undefined);
        });
        it("should return undefined for -3, 255, 255", function () {
            expect(rgbToHexColor(-3, 255, 255)).to.be.equal(undefined);
        });
        it("should return undefined for 255, 255, 257", function () {
            expect(rgbToHexColor(255, 255, 257)).to.be.equal(undefined);
        });
        it("should return undefined for 255, 255, -3", function () {
            expect(rgbToHexColor(255, 255, -3)).to.be.equal(undefined);
        });
        it("should return undefined for 255, 258, 255", function () {
            expect(rgbToHexColor(255, 258, 255)).to.be.equal(undefined);
        });
        it("should return undefined for 255, -3, 255", function () {
            expect(rgbToHexColor(255, -3, 255)).to.be.equal(undefined);
        });
        it("should return undefined for 0, 0, 5.12", function () {
            expect(rgbToHexColor(0, 0, 5.12)).to.be.equal(undefined);
        });
        it("should return undefined for 0, 5.12, 0", function () {
            expect(rgbToHexColor(0, 5.12, 0)).to.be.equal(undefined);
        });
        it("should return undefined for 5.12, 0, 0", function () {
            expect(rgbToHexColor(5.12, 0, 0)).to.be.equal(undefined);
        });
        it("should return undefined for {a}, [1, 2], 'blessed'", function () {
            expect(rgbToHexColor({a: 5}, [1, 2], 'blessed')).to.be.equal(undefined);
        });
        it("should return undefined for empty input", function () {
            expect(rgbToHexColor()).to.be.equal(undefined);
        });
    });
});
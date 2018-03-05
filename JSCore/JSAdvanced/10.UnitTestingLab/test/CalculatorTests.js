let expect = require('chai').expect;

let createCalculator = require('../07.Calaculator');

describe("Add/Subtract tests", function () {
    let calc;
    beforeEach(function () {
        calc = createCalculator();
    });


    it("should return 8 for twice adding 5 and 3", function () {
        calc.add(5);
        calc.add(3);
        let value = calc.get();
        expect(value).to.be.equal(8);
    });

    it("should return 0 for adding 5 and subtracting 5", function () {
        calc.add(5);
        calc.subtract(5);
        let value = calc.get();
        expect(value).to.be.equal(0);
    });

    it("should return 5 for subtracting -5", function () {
        calc.subtract(-5);
        let value = calc.get();
        expect(value).to.be.equal(5);
    });

    it("should return -5 for adding -5", function () {
        calc.add(-5);
        let value = calc.get();
        expect(value).to.be.equal(-5);
    });
    it("should return 5 for subtracting 2 and subtract 3", function () {
        calc.subtract(2);
        calc.subtract(3);
        let value = calc.get();
        expect(value).to.be.equal(-5);
    });
    it("should return 0 when created", function () {
        let value = calc.get();
        expect(value).to.be.equal(0);
    });

    it("should return 11 for subtracting -5, adding 6", function () {
        calc.subtract(-5);
        calc.add(6);
        let value = calc.get();
        expect(value).to.be.equal(11);
    });

    it("should return 5.1 for subtracting 2.2, adding 7.3", function () {
        calc.subtract(2.2);
        calc.add(7.3);
        let value = calc.get();
        expect(value).to.be.equal(5.1);
    });
    describe("Invalid input", function () {
        it("should return NaN for subtracting 'hello'", function () {
            calc.subtract('hello');
            let value = calc.get();
            expect(value).to.be.NaN;
        });
        it("should return NaN for adding 'hello'", function () {
            calc.add('hello');
            let value = calc.get();
            expect(value).to.be.NaN;
        });

        it("should return NaN for empty input", function () {
            calc.add();
            let value = calc.get();
            expect(value).to.be.NaN;
        });

        it("should return NaN when input is object", function () {
            calc.add({a:2});
            calc.subtract({b:10});
            let value = calc.get();
            expect(value).to.be.NaN;
        });
    });


    it("should return 12", function () {
        calc.add(6);
        calc.subtract(18);
        calc.add(-16);
        calc.subtract(-8);
        let value = calc.get();
        expect(value).to.be.equal(-20);
    });

    it("should return 12 when input is number string", function () {
        calc.add(6);
        calc.subtract('18');
        calc.add('16');
        calc.subtract('-8');
        let value = calc.get();
        expect(value).to.be.equal(12);
    });


    it("should return 0 when add or subtract 0", function () {
        calc.add(0);
        calc.subtract(0);
        let value = calc.get();
        expect(value).to.be.equal(0);
    });
});
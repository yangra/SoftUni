let expect = require('chai').expect;

const mathEnforcer = require('../04.MathEnforcer');

describe('MathEnforcer', function () {
    it('Should return undefined if not number is given to addFive', function () {
        expect(mathEnforcer.addFive([3])).to.be.equal(undefined);
    });
    it('Should return undefined if not number is given to addFive', function () {
        expect(mathEnforcer.addFive({a:3})).to.be.equal(undefined);
    });
    it('Should return undefined if not number is given to addFive', function () {
        expect(mathEnforcer.addFive('3')).to.be.equal(undefined);
    });
    it('Should return undefined if no parameter is given to addFive', function () {
        expect(mathEnforcer.addFive()).to.be.equal(undefined);
    });
    it('Should return 7.13 if 2.13 is given to addFive', function () {
        expect(mathEnforcer.addFive(2.13)).to.be.equal(7.13);
    });
    it('Should return -3 if -8 is given to addFive', function () {
        expect(mathEnforcer.addFive(-8)).to.be.equal(-3);
    });
    it('Should return undefined if not number is given to subtractTen', function () {
        expect(mathEnforcer.subtractTen([3])).to.be.equal(undefined);
    });
    it('Should return undefined if not number is given to subtractTen', function () {
        expect(mathEnforcer.subtractTen({a:3})).to.be.equal(undefined);
    });
    it('Should return undefined if not number is given to subtractTen', function () {
        expect(mathEnforcer.subtractTen('3')).to.be.equal(undefined);
    });
    it('Should return undefined if no parameter is given to subtractTen', function () {
        expect(mathEnforcer.subtractTen()).to.be.equal(undefined);
    });
    it('Should return 5.18 if -4.82 is given to subtractTen', function () {
        expect(mathEnforcer.subtractTen(5.18)).to.be.equal(-4.82);
    });
    it('Should return -14 if -4 is given to subtractTen', function () {
        expect(mathEnforcer.subtractTen(-4)).to.be.equal(-14);
    });
    it('Should return undefined if not number is given to first parameter in sum', function () {
        expect(mathEnforcer.sum([4],4)).to.be.equal(undefined);
    });
    it('Should return undefined if not number is given to first parameter in sum', function () {
        expect(mathEnforcer.sum({a:4},5)).to.be.equal(undefined);
    });
    it('Should return undefined if not number is given to first parameter in sum', function () {
        expect(mathEnforcer.sum('4',6)).to.be.equal(undefined);
    });
    it('Should return undefined if no parameter is given to sum', function () {
        expect(mathEnforcer.sum()).to.be.equal(undefined);
    });
    it('Should return undefined if not number is given to second parameter in sum', function () {
        expect(mathEnforcer.sum(3, [4])).to.be.equal(undefined);
    });
    it('Should return undefined if not number is given to second parameter in sum', function () {
        expect(mathEnforcer.sum(5, {a:4})).to.be.equal(undefined);
    });
    it('Should return undefined if not number is given to second parameter in sum', function () {
        expect(mathEnforcer.sum(6, '4')).to.be.equal(undefined);
    });
    it('Should return 0.36 if 5.18, -4.82 is given to sum', function () {
        expect(mathEnforcer.sum(5.1, -4.8)).to.be.equal(0.2999999999999998);
    });
    it('Should return 39 if 18, 21 is given to sum', function () {
        expect(mathEnforcer.sum(18,21)).to.be.equal(39);
    });

    it('Should return 0 if 0,0 is given to sum', function () {
        expect(mathEnforcer.sum(0,0)).to.be.equal(0);
    });

});
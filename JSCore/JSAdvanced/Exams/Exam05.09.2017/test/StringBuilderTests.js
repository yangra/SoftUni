let expect = require('chai').expect;
let StringBuilder = require('../02.StringBuilder');

describe('Add Delete List tests', function () {

    let sb;
    beforeEach(function () {
        sb = new StringBuilder();
    });

    it('should be initialized properly', function () {
        expect(StringBuilder.prototype.hasOwnProperty('append')).to.be.true;
        expect(typeof sb.append === 'function').to.be.true;
        expect(StringBuilder.prototype.hasOwnProperty('prepend')).to.be.true;
        expect(typeof sb.prepend === 'function').to.be.true;
        expect(StringBuilder.prototype.hasOwnProperty('insertAt')).to.be.true;
        expect(typeof sb.insertAt === 'function').to.be.true;
        expect(StringBuilder.prototype.hasOwnProperty('remove')).to.be.true;
        expect(typeof sb.remove === 'function').to.be.true;
        expect(StringBuilder.prototype.hasOwnProperty('toString')).to.be.true;
        expect(typeof sb.toString === 'function').to.be.true;
    });

    it('should instantiate with string', function () {
        let sb = new StringBuilder('start');
        expect(sb.toString()).to.be.equal('start');
    });

    it('should append properly', function () {
        sb.append('abc');
        sb.append('bcd');
        expect(sb.toString()).to.be.equal('abcbcd');
    });

    it('should throw with no string', function () {
        expect(()=>{sb.append(12)}).to.throw(TypeError);
    });

    it('should throw with no string', function () {
        expect(()=>{sb.append({a:12})}).to.throw(TypeError);
    });

    it('should throw with no string', function () {
        expect(()=>{sb.append([1,2,3])}).to.throw(TypeError);
    });

    it('should prepend properly', function () {
        sb.prepend('abc');
        sb.prepend('bcd');
        expect(sb.toString()).to.be.equal('bcdabc');
    });

    it('should throw with no string', function () {
        expect(()=>{sb.prepend(12)}).to.throw(TypeError);
    });

    it('should throw with no string', function () {
        expect(()=>{sb.prepend({a:12})}).to.throw(TypeError);
    });

    it('should throw with no string', function () {
        expect(()=>{sb.prepend([1,2,3])}).to.throw(TypeError);
    });

    it('should insert properly', function () {
        sb.prepend('abc');
        sb.append('bcd');
        sb.insertAt('ABC',0);
        sb.insertAt('ABC',9);
        sb.insertAt('BCA',4);
        expect(sb.toString()).to.be.equal('ABCaBCAbcbcdABC');
    });

    it('should throw with no string', function () {
        expect(()=>{sb.insertAt(12, 2)}).to.throw(TypeError);
    });

    it('should throw with no string', function () {
        expect(()=>{sb.insertAt({a:12},2)}).to.throw(TypeError);
    });

    it('should throw with no string', function () {
        expect(()=>{sb.insertAt([1,2,3],2)}).to.throw(TypeError);
    });

    it('should insert properly', function () {
        sb.prepend('abc');
        sb.append('bcd');
        sb.remove(0,2);
        sb.remove(3,1);
        sb.remove(1,1);
        expect(sb.toString()).to.be.equal('cc');
    });

});
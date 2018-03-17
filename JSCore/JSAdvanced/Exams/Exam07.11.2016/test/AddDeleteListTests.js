let expect = require('chai').expect;
let list = require('../02.AddDeleteInList');

describe('Add Delete List tests', function () {

    it('should be initialized properly', function () {
        expect(list.hasOwnProperty('add')).to.be.true;
        expect(list.hasOwnProperty('delete')).to.be.true;
        expect(list.hasOwnProperty('toString')).to.be.true;
    });

    it('should add properly', function () {
        list.add(12);
        expect(list.toString()).to.be.equal('12');
    });

    it('should add properly elements of all types', function () {
        list.add(12);
        list.add({a: 12});
        list.add([11,12,18]);
        list.add('hi');
        expect(list.toString()).to.be.equal('12, [object Object], 11,12,18, hi');
    });

    it('should delete properly ', function () {
        list.add(12);
        list.add({a: 12});
        list.add([11,12,18]);
        list.add('hi');
        expect(list.delete(1)).to.be.equal({a:12});
        expect(list.toString()).to.be.equal('12, 11,12,18, hi');
    });

    it('should not delete on not existing index', function () {
        list.add(12);
        list.add({a: 12});
        list.add([11,12,18]);
        list.add('hi');
        expect(list.delete(12)).to.be.equal(undefined);
        expect(list.toString()).to.be.equal('12, [object Object], 11,12,18, hi');
    });

    it('should not delete on not number index', function () {
        list.add(12);
        list.add({a: 12});
        list.add([11,12,18]);
        list.add('hi');
        expect(list.delete('12')).to.be.equal(undefined);
        expect(list.toString()).to.be.equal('12, [object Object], 11,12,18, hi');
    });

    it('should not delete on negative index', function () {
        list.add(12);
        list.add({a: 12});
        list.add([11,12,18]);
        list.add('hi');
        expect(list.delete(-12)).to.be.equal(undefined);
        expect(list.toString()).to.be.equal('12, [object Object], 11,12,18, hi');
    });

    it('should not delete on list.length index', function () {
        list.add(12);
        list.add({a: 12});
        list.add([11,12,18]);
        list.add('hi');
        expect(list.delete(4)).to.be.equal(undefined);
        expect(list.toString()).to.be.equal('12, [object Object], 11,12,18, hi');
    });

    it('should not delete on 0 index', function () {
        list.add(12);
        list.add({a: 12});
        list.add([11,12,18]);
        list.add('hi');
        expect(list.delete(0)).to.be.equal(12);
        expect(list.toString()).to.be.equal('[object Object], 11,12,18, hi');
    });
});
let expect = require("chai").expect;
let jsdom = require('jsdom-global')();
let $ = require('jquery');


const nuke = require('../06.ArmageDOM');

describe("Armage DOM", function () {

    beforeEach(function () {
        document.body.innerHTML = `<div id="target">
    <div class="nested target">
        <p>This is some text</p>
    </div>
    <div class="target">
        <p>Empty div</p>
    </div>
    <div class="inside">
        <span class="nested">Some more text</span>
        <span class="target">Some more text</span>
    </div>
</div>`;
    });

    describe("Selectors should be strings", function () {

        it("should not work if selector1 is not string", function () {
            let before = document.body.innerHTML;
            nuke(12, 'abc');
            let after = document.body.innerHTML;
            expect(before).to.be.equal(after);
        });
        it("should not work if selector1 is not string", function () {
            let before = document.body.innerHTML;
            nuke({a: 12}, 'abc');
            let after = document.body.innerHTML;
            expect(before).to.be.equal(after);
        });
        it("should not work if selector1 is not string", function () {
            let before = document.body.innerHTML;
            nuke([12], 'abc');
            let after = document.body.innerHTML;
            expect(before).to.be.equal(after);
        });
        it("should not work if selector2 is not string", function () {
            let before = document.body.innerHTML;
            nuke('abc', 12);
            let after = document.body.innerHTML;
            expect(before).to.be.equal(after);
        });
        it("should not work if selector2 is not string", function () {
            let before = document.body.innerHTML;
            nuke('abc', {a: 12});
            let after = document.body.innerHTML;
            expect(before).to.be.equal(after);
        });
        it("should not work if selector2 is not string", function () {
            let before = document.body.innerHTML;
            nuke('abc', [12]);
            let after = document.body.innerHTML;
            expect(before).to.be.equal(after);
        });
    });
    describe("Does nothing if selector is invalid or omitted", function () {
        it("should not work if selector2 is invalid", function () {
            let before = document.body.innerHTML;
            nuke('#target', 'abc');
            let after = document.body.innerHTML;
            expect(before).to.be.equal(after);
        });
        it("should not work if selector1 is invalid", function () {
            let before = document.body.innerHTML;
            nuke('abc', '#target');
            let after = document.body.innerHTML;
            expect(before).to.be.equal(after);
        });
        it("should not work if selectors are missing", function () {
            let before = document.body.innerHTML;
            nuke();
            let after = document.body.innerHTML;
            expect(before).to.be.equal(after);
        });
        it("should not work if selectors are missing", function () {
            let before = document.body.innerHTML;
            nuke('#target');
            let after = document.body.innerHTML;
            expect(before).to.be.equal(after);
        });
    });
    describe("Does nothing if selectors are the same", function () {
        it("should not work if selectors are the same", function () {
            let before = document.body.innerHTML;
            nuke('#target', '#target');
            let after = document.body.innerHTML;
            expect(before).to.be.equal(after);
        });
    });
    describe("Upon execution deletes all nodes that match both selectors", function () {
        it('should remove nodes with correct selectors', function()  {
            let before = document.body.innerHTML;
            let selector1 = '.target';
            let selector2 = '.nested';
            nuke(selector1, selector2);
            let after = document.body.innerHTML;
            expect(after).to.not.equal(before);
        });

        it('should not change content if it matches only one selector', function () {

            let selector1 = '.nested';
            let selector2 = '.target';
            let before = $('.inside').html();
            nuke(selector1, selector2);
            let after = $('.inside').html();
            expect(before).to.be.equal(after);

        });

        it('should not change if first selector doesnt contain the second', function()  {
            let before = document.body.innerHTML;
            let selector1 = '.nested';
            let selector2 = '#target';
            nuke(selector1, selector2);
            let after = document.body.innerHTML;
            expect(before).to.be.equal(after);
        });
    });
});
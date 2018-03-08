let expect = require("chai").expect;
let jsdom = require('jsdom-global')();
let $ = require('jquery');

document.body.innerHTML = `<div id="wrapper">
    <input type="text" id="name">
    <input type="text" id="income">
</div>`;

const sharedObject = require('../shared-object');

describe("Shared Object", function () {
    describe("Shared Object initial nulls", function () {
        it("initial value of name should be null", function () {
            expect(sharedObject.name).to.be.equal(null);
        });
        it("initial value of income should be null", function () {
            expect(sharedObject.income).to.be.equal(null);
        });
    });
    describe("Shared Object changeName tests", function () {
        it("should change name", function () {
            sharedObject.changeName('Pesho');
            expect(sharedObject.name).to.be.equal('Pesho');
            expect($('#name').val()).to.be.equal('Pesho');
        });

        it("should not change name if given empty string", function () {
            sharedObject.changeName('Gosho');
            sharedObject.changeName('');
            expect(sharedObject.name).to.be.equal('Gosho');
            expect($('#name').val()).to.be.equal('Gosho');
        });
    });

    describe("Shared Object changeIncome tests", function () {
        it("should change income if given positive integer", function () {
            sharedObject.changeIncome(201);
            expect(sharedObject.income).to.be.equal(201);
            expect($('#income').val()).to.be.equal('201');
        });
        it("should not change income if given negative integer", function () {
            sharedObject.changeIncome(18);
            sharedObject.changeIncome(-12);
            expect(sharedObject.income).to.be.equal(18);
        });
        it("should not change income if given zero", function () {
            sharedObject.changeIncome(18);
            sharedObject.changeIncome(0);
            expect(sharedObject.income).to.be.equal(18);
        });
        it("should not change income if given real number", function () {
            sharedObject.changeIncome(18);
            sharedObject.changeIncome(1.2);
            expect(sharedObject.income).to.be.equal(18);
        });
        it("should not change income if given string", function () {
            sharedObject.changeIncome(18);
            sharedObject.changeIncome('abc');
            expect(sharedObject.income).to.be.equal(18);
        });

        it("should not change income if given empty string", function () {
            sharedObject.changeIncome(12);
            sharedObject.changeIncome('');
            expect(sharedObject.income).to.be.equal(12);
        });

        it("should not change income if given object", function () {
            sharedObject.changeIncome(12);
            sharedObject.changeIncome({a: 3});
            expect(sharedObject.income).to.be.equal(12);
        });
        it("should not change income if given array", function () {
            sharedObject.changeIncome(12);
            sharedObject.changeIncome([2, 3]);
            expect(sharedObject.income).to.be.equal(12);
        });
    });

    describe("Shared Object updateName tests", function () {
        it("should update name if given in the textbox", function () {
            let nameTextbox = $('#name');
            nameTextbox.val('Abc');
            sharedObject.updateName();
            expect(sharedObject.name).to.be.equal('Abc');
            expect(nameTextbox.val()).to.be.equal('Abc');
        });

        it("should not update name if given textbox value is an empty string", function () {
            sharedObject.changeName('Hello');
            let nameTextbox = $('#name');
            nameTextbox.val('');
            sharedObject.updateName();
            expect(sharedObject.name).to.be.equal('Hello');
        });
    });

    describe("Shared Object updateIncome tests", function () {
        it("should update income if given positive integer", function () {
            let nameTextbox = $('#income');
            nameTextbox.val(251);
            sharedObject.updateIncome();
            expect(sharedObject.income).to.be.equal(251);
        });

        it("should update income if given positive integer string", function () {
            let nameTextbox = $('#income');
            nameTextbox.val('25');
            sharedObject.updateIncome();
            expect(sharedObject.income).to.be.equal(25);
        });

        it("should not update income if given negative integer string", function () {
            sharedObject.changeIncome(12);
            let nameTextbox = $('#income');
            nameTextbox.val('-25');
            sharedObject.updateIncome();
            expect(sharedObject.income).to.be.equal(12);
        });

        it("should not update income if given negative integer", function () {
            sharedObject.changeIncome(12);
            let nameTextbox = $('#income');
            nameTextbox.val(-27);
            sharedObject.updateIncome();
            expect(sharedObject.income).to.be.equal(12);
        });

        it("should not update income if given real number", function () {
            sharedObject.changeIncome(12);
            let nameTextbox = $('#income');
            nameTextbox.val(27.12);
            sharedObject.updateIncome();
            expect(sharedObject.income).to.be.equal(12);
        });

        it("should not update income if given zero", function () {
            sharedObject.changeIncome(12);
            let nameTextbox = $('#income');
            nameTextbox.val(0);
            sharedObject.updateIncome();
            expect(sharedObject.income).to.be.equal(12);
        });

        it("should not update income if given object", function () {
            sharedObject.changeIncome(12);
            let nameTextbox = $('#income');
            nameTextbox.val({a: 18});
            sharedObject.updateIncome();
            expect(sharedObject.income).to.be.equal(12);
        });

        it("should not update income if given array", function () {
            sharedObject.changeIncome(12);
            let nameTextbox = $('#income');
            nameTextbox.val([1, 2, 3]);
            sharedObject.updateIncome();
            expect(sharedObject.income).to.be.equal(12);
        });
    });
});
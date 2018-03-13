let result = (function () {

    class Textbox {
        constructor(selector, regexInvalidSymbols) {
            this.selector = selector;
            this._invalidSymbols = regexInvalidSymbols;
            this._elements = $(this.selector);
            this._elements.on('input', (e) => {
                this._value = $(e.target).val();
                this.updateElements();
            })
        }


        get value() {
            return this._value;
        }

        set value(newValue) {
            this._value = newValue;
            this.updateElements();
        }

        get elements() {
            return this._elements;
        }

        updateElements() {
            for (let element of this._elements) {
                $(element).val(this._value);
            }
        }

        isValid() {
            return !this._invalidSymbols.test(this._value)
        }
    }

    class Form {
        constructor(...textboxes) {
            this._element = $('<div>').addClass('form');
            this.textboxes = textboxes;
        }

        get textboxes() {
            return this._textboxes;
        }

        set textboxes(value) {
            for (let obj of value) {
                if (!obj instanceof Textbox) {
                    throw new Error();
                }
            }

            this._textboxes = value;

            for (let textbox of this._textboxes) {
                this._element.append(textbox.elements);
            }

            console.log(this._element);
        }

        submit() {
            let isValid = true;
            for (let textbox of this._textboxes) {
                if (textbox.isValid()) {
                    textbox.elements.css('border','2px solid green');
                } else {
                    textbox.elements.css('border','2px solid red');
                    isValid = false;
                }
            }
            return isValid;
        }

        attach(selector) {
            $(selector).append(this._element);
        }

    }

    return {
        Textbox: Textbox,
        Form: Form
    }
}());

let Textbox = result.Textbox;
let Form = result.Form;
let username = new Textbox("#username",/[^a-zA-Z0-9]/);
let password = new Textbox("#password",/[^a-zA-Z]/);
username.value = "username";
password.value = "password2";
let form = new Form(username,password);
form.attach("#root");
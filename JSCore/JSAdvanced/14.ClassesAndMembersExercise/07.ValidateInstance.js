class CheckingAccount {
    constructor(clientId, email, firstName, lastName) {
        this.privateMethods = {
            checkLength: function (value, isFirstName) {
                if (value.length < 3 || value.length > 20) {
                    let message = (isFirstName ? 'First' : 'Last') + ' name must be between 3 and 20 characters long';
                    throw new TypeError(message);
                }
            },

            checkValidity: function (value, isFirstName) {
                let pattern = /^[A-Za-z]+$/;
                if (!pattern.test(value)) {
                    let message = (isFirstName ? 'First' : 'Last') + ' name must contain only Latin characters';
                    throw new TypeError(message);
                }
            }
        };
        this.clientId = clientId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    get clientId() {
        return this._clientId;
    }

    get email() {
        return this._email;
    }

    get firstName() {
        return this._firstName;
    }

    get lastName() {
        return this._lastName;
    }

    set clientId(value) {
        let pattern = /^[0-9]{6}$/;
        if (!(typeof value === 'string') || !pattern.test(value)) {
            throw new TypeError('Client ID must be a 6-digit number');
        }
        this._clientId = value;
    }

    set email(value) {
        let pattern = /^[A-Za-z0-9]+@[a-zA-Z]+(\.[a-zA-Z]+)+$/;
        if (!(typeof value === 'string') || !pattern.test(value)) {
            throw new TypeError('Invalid e-mail');
        }
        this._email = value;
    }

    set firstName(value) {
        if (!(typeof value === 'string')) {
            throw new TypeError()
        }
        this.privateMethods.checkLength(value, true);
        this.privateMethods.checkValidity(value, true);
        this._firstName = value;
    }

    set lastName(value) {
        if (!(typeof value === 'string')) {
            throw new TypeError()
        }
        this.privateMethods.checkLength(value, false);
        this.privateMethods.checkValidity(value, false);
        this._lastName = value;
    }

}

let ca = new CheckingAccount('123456', 'abv@abv.bg', 'ab', 'sb');
console.log(ca.clientId);



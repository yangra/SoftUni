class Dialog {
    constructor(message, callback) {
        this.message = message;
        this.callback = callback;
        this._inputs = [];
        this._element = $('<div class="overlay">')
            .append($('<div class="dialog">')
                .append($(`<p>${this.message}</p>`)));
    }

    addInput(label, name, type) {
        let input = $(`<label for="${name}">${label}</label><input id="${name}" name="${name}" type="${type}"/>`);
        this._inputs.push(input);
    }

    render() {
        let divDialog = this._element.find('.dialog');
        for (let input of this._inputs) {
            divDialog.append(input);
        }

        let okBtn = $('<button>OK</button>').on('click', this._ok.bind(this));
        let cancelBtn = $('<button>Cancel</button>').on('click', this._cancel.bind(this));

        divDialog.append(okBtn).append(cancelBtn);
        $('body').append(this._element);
    }

    _cancel() {
        this._element.remove();
    }

    _ok() {
        let params = {};
        for (let input of this._inputs) {
            let name = $($(input)[1]).attr('name');
            params[name] = this._element.find('.dialog').find('#' + name).val();
        }

        this.callback(params);
        this._cancel();
    }
}
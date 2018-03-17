class Contact {
    constructor(firstName, lastName, phone, email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.online = false;
        this.element = this._buildElement();
    }


    get online() {
        return this._online;
    }

    set online(value) {
        $(this.element).find('.title').toggleClass('online',value);
        this._online = value;

    }

    render(id) {
        $('#' + id).append(this.element);
    }


    _buildElement() {
        let infoBtn = $('<button>&#8505;</button>');
        infoBtn.on('click',()=>
            $(this.element).find('.info').toggle());
        return $('<article>')
            .append($(`<div class="title">${this.firstName} ${this.lastName}</div>`).append(infoBtn))
            .append($(`<div class="info" style="display: none;"><span>&phone; ${this.phone}</span><span>&#9993; ${this.email}</span></div>`));
    }
}
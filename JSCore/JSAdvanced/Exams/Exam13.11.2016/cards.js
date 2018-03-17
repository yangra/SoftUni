function cardDeckBuilder(selector) {

    class CardDeckBuilder {
        constructor(selector) {
            this._suits = {
                'C': '\u2663',
                'D': '\u2666',
                'H': '\u2665 ',
                'S': '\u2660'
            };
            this._container = $(selector);
            this._deck = [];
        }

        _update() {
            this._container.children().detach();
            //let reversed = this._container.children().toArray().reverse();
            this._deck = this._deck.reverse();
             for (let card of this._deck) {
            //     console.log(card);
            //     card.on('click',()=>this._update());
                 this._container.append(card);
             }
            //this._container.append(reversed);
        }

        addCard(face, suit) {
            let card = $(`<div class="card">${face} ${this._suits[suit]}</div>`);
            card.on('click', () => this._update());
            this._deck.push(card);
            this._container.append(card);
        }
    }

    return new CardDeckBuilder(selector);

}

let result = (function () {
    const allowedFaces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];

    let Suits = {
        SPADES: '\u2660',
        HEARTS: '\u2665',
        DIAMONDS: '\u2666',
        CLUBS: '\u2663'
    };

    class Card {
        constructor(face, suit) {
            this.face = face;
            this.suit = suit;
        }

        get face() {
            return this._face;
        }

        set face(face) {
            if (!allowedFaces.includes(face)) {
                throw new Error('Invalid face')
            }

            this._face = face;
        }

        get suit() {
            return this._suit;
        }

        set suit(suit) {
            if (!Object.keys(Suits).map(k => Suits[k]).includes(suit)) {
                throw new Error('Invalid suit')
            }

            this._suit = suit;
        }

        toString() {
            return this._face + this._suit;
        }
    }

    return {Suits, Card};
})()

let Card = result.Card;
let Suits = result.Suits;

let card = new Card('Q', Suits.CLUBS);
console.log(card + '');
card.face = 'A';
console.log(card + '');
card.suit = Suits.DIAMONDS;
console.log(card + '');
let card2 = new Card('A', Suits.Pesho);
console.log(card2 + '');
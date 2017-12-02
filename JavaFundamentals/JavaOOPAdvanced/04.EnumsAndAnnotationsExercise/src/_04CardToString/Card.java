package _04CardToString;

public class Card {
    private CardSuit cardSuit;
    private CardRank cardRank;

    public Card(String cardRank, String cardSuit) {
        this.cardRank = CardRank.valueOf(cardRank.toUpperCase());
        this.cardSuit = CardSuit.valueOf(cardSuit.toUpperCase());
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d\n", this.cardRank, this.cardSuit,
                this.cardRank.getPower() + this.cardSuit.getPower());
    }
}

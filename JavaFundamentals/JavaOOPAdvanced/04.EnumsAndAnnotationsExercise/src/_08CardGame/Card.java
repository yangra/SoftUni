package _08CardGame;

public class Card implements Comparable<Card> {
    private CardSuit cardSuit;
    private CardRank cardRank;

    public Card(String cardRank, String cardSuit) {
        try {
            this.cardRank = CardRank.valueOf(cardRank.toUpperCase());
            this.cardSuit = CardSuit.valueOf(cardSuit.toUpperCase());
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("No such card exists.");
        }
    }

    public int getCardPower() {
        return this.cardRank.getPower() + this.cardSuit.getPower();
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.cardRank, this.cardSuit);
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.getCardPower(), other.getCardPower());
    }
}

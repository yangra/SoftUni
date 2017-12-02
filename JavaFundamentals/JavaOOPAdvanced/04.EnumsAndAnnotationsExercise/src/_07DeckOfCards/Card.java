package _07DeckOfCards;

public class Card implements Comparable<Card>{
    private CardSuit cardSuit;
    private CardRank cardRank;

    public Card(String cardRank, String cardSuit) {
        this.cardRank = CardRank.valueOf(cardRank.toUpperCase());
        this.cardSuit = CardSuit.valueOf(cardSuit.toUpperCase());
    }

    public int getCardPower() {
        return this.cardRank.getPower() + this.cardSuit.getPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d\n", this.cardRank, this.cardSuit, this.getCardPower());
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.getCardPower(), other.getCardPower());
    }
}

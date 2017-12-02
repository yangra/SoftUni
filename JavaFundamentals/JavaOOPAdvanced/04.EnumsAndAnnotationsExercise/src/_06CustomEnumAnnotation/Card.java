package _06CustomEnumAnnotation;

public class Card implements Comparable<Card>{
    private Suit cardSuit;
    private Rank cardRank;

    public Card(String cardRank, String cardSuit) {
        this.cardRank = Rank.valueOf(cardRank.toUpperCase());
        this.cardSuit = Suit.valueOf(cardSuit.toUpperCase());
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

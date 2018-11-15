public class Card {

    private Suits suit;
    private Rank cardRank;

    public Card(Suits suit, Rank cardRank) {
        this.suit = suit;
        this.cardRank = cardRank;
    }

    public Suits getSuit() {
        return suit;
    }

    public Rank getRank() {
        return cardRank;
    }
}

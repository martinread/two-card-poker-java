import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {

    private List<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
    }

    public void createDeck() {
        for (Suits s : Suits.values()) {
            for (Rank c : Rank.values()) {
                deck.add(new Card(s, c));
            }
        }
    }

    // randomly shuffles a deck of playing card objects
    public List<Card> shuffleDeck() {

        List<Card> shuffled = new ArrayList<>();

        while (deck.size() > 0) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, deck.size());
            shuffled.add(deck.remove(randomNum));
        }

        return shuffled;
    }

}

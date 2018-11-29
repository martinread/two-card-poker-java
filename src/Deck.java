import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {

//    private List<Card> deck;
//
//    public Deck() {
//        deck = new ArrayList<>();
//    }

//    public void createDeck() {
//        for (Suits s : Suits.values()) {
//            for (Rank c : Rank.values()) {
//                deck.add(new Card(s, c));
//            }
//        }
//    }

    public List<Card> createDeck() {
        List<Card> deck = new ArrayList<>();
        for (Suits s : Suits.values()) {
            for (Rank c : Rank.values()) {
                deck.add(new Card(s, c));
            }
        }
        return deck;
    }

    // randomly shuffles a deck of playing card objects
//    public List<Card> shuffleDeck() {
//
//        List<Card> shuffled = new ArrayList<>();
//
//        while (deck.size() > 0) {
//            int randomNum = ThreadLocalRandom.current().nextInt(0, deck.size());
//            shuffled.add(deck.remove(randomNum));
//        }
//
//        return shuffled;
//    }

    public void shuffleDeck(List<Card> orderedDeck) {
        Collections.shuffle(orderedDeck);
    }

}

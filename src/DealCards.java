import java.util.List;

public class DealCards {

    public void dealCards(List<Player> players, List<Card> shuffled, int handSize) {

        for (Player p : players) {

            Card[] playerHand = new Card[handSize];

            for (int i = 0; i < handSize; i++) {
                int topOfDeck = shuffled.size() - 1;
                playerHand[i] = shuffled.remove(topOfDeck);
            }

            p.setPlayerHand(playerHand);

        }
    }
}

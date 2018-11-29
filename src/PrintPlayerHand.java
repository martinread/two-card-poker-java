import java.util.List;

public class PrintPlayerHand {

    public void printCards(List<Player> players) {

        for (Player p : players) {
            System.out.print("Player " + p.getPlayerNumber() + "'s hand: ");
            Card[] cards = p.getPlayerHand();
            for (Card c : cards) {
                switch(c.getRank()) {
                    case ACE:
                        System.out.print("A");
                        break;
                    case KING:
                        System.out.print("K");
                        break;
                    case QUEEN:
                        System.out.print("Q");
                        break;
                    case JACK:
                        System.out.print("J");
                        break;
                    default:
                        System.out.print(c.getRank().getCardRank());
                        break;
                }

                switch(c.getSuit()) {
                    case SPADES:
                        System.out.print("\u2664" + " ");
                        break;
                    case CLUBS:
                        System.out.print("\u2667" + " ");
                        break;
                    case HEARTS:
                        System.out.print("\u2661" + " ");
                        break;
                    case DIAMONDS:
                        System.out.print("\u2662" + " ");
                        break;
                }
            }
            System.out.println("(" + p.getRoundRank() + ")");
        }
    }
}

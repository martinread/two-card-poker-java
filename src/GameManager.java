import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private Deck deck;
    protected List<Player> players;

    protected final int minPlayers = 2;
    protected final int maxPlayers = 6;
    private int handSize = 2;
    private int numberOfRounds;
    private int numberOfPlayers;

    public static void main(String[] args) {
        GameManager game = new GameManager();
        game.setup();
    }

    // GameManager constructor
    public GameManager() {
        deck = new Deck();
        players = new ArrayList<>();
    }

    private void setup() {

        GetUserInput userInput = new GetUserInput();

        numberOfPlayers = userInput.getNumberOfPlayers();
        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(new Player(i));
        }
        numberOfRounds = userInput.getNumberOfRounds();

        rounds();
    }

    private void rounds() {

        int round = 1;

        while (round <= numberOfRounds) {

            deck.createDeck();

            List<Card> shuffled = deck.shuffleDeck();

            printRoundIntro(round);

            // deal cards to each player & calculate their hand rank & best card
            DealCards dc = new DealCards(players);
            dc.dealCards(shuffled, handSize);

            for (Player p : players) {
                CalculatePlayerScore calc = new CalculatePlayerScore(p);
                calc.playerHandRank();
            }

            PrintPlayerHand ppc = new PrintPlayerHand(players);
            ppc.printCards();

            printSeparator();

            // compare each players hands
            ComparePlayerScores comp = new ComparePlayerScores(players);
            comp.assignRoundPoints();

            // print round and total scores to console
            PrintScores ps = new PrintScores(players, round, numberOfRounds);
            ps.printRoundScores();
            printSeparator();
            ps.printTotalScores();

            // increment rounds variable by 1
            round++;
        }

        DetermineOverallWinner dow = new DetermineOverallWinner(players);
        dow.outputFinalStandings();
    }

    private void printRoundIntro(int round) {
        System.out.println();
        System.out.println("\u2664" + "\u2667" + " ROUND " + round + " " + "\u2661" + "\u2662");
        System.out.println("------------------------------------------");
    }

    // outputs a unicode circle as a separator
    private void printSeparator() {
        System.out.println("\u25cf");
    }

}

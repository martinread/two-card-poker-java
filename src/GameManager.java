import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private final Deck deck = new Deck();
    private final List<Player> players = new ArrayList<>();

    private final int MIN_PLAYERS = 2;
    private final int MAX_PLAYERS = 6;
    private final int HAND_SIZE = 2;

    private int numberOfRounds;
    private int numberOfPlayers;

    public static void main(String[] args) {
        GameManager game = new GameManager();
        game.setupGame();
    }

    private void setupGame() {

        GetUserInput userInput = new GetUserInput();
        numberOfPlayers = userInput.getNumberOfPlayers(MIN_PLAYERS, MAX_PLAYERS);
        numberOfRounds = userInput.getNumberOfRounds();

        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(new Player(i));
        }

        startGame();
    }

    private void startGame() {

        int round = 1;

        List<Card> orderedDeck = deck.createDeck();

        while (round <= numberOfRounds) {

            deck.createDeck();

            deck.shuffleDeck(orderedDeck);

            printRoundIntro(round);

            // deal cards to each player & calculate their hand rank & best card
            DealCards dc = new DealCards();
            dc.dealCards(players, orderedDeck, HAND_SIZE);

            for (Player p : players) {
                CalculatePlayerScore calc = new CalculatePlayerScore();
                calc.playerHandRank(p);
            }

            PrintPlayerHand ppc = new PrintPlayerHand();
            ppc.printCards(players);

            printSectionSeparator();

            // compare each players hands
            ComparePlayerScores comp = new ComparePlayerScores();
            comp.assignRoundPoints(players);

            // print round and total scores to console
            PrintScores ps = new PrintScores();
            ps.printRoundScores(players, round);
            printSectionSeparator();
            ps.printTotalScores(players, round, numberOfRounds);

            // increment startGame variable by 1
            round++;
        }

        DetermineOverallWinner dow = new DetermineOverallWinner();
        dow.outputFinalStandings(players);
    }

    private void printRoundIntro(int round) {
        System.out.println();
        System.out.println("\u2664" + "\u2667" + " ROUND " + round + " " + "\u2661" + "\u2662");
        System.out.println("------------------------------------------");
    }

    // outputs a unicode circle as a separator
    private void printSectionSeparator() {
        System.out.println("\u25cf");
    }

}

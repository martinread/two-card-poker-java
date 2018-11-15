import java.util.List;

public class PrintScores {

    private List<Player> players;
    private int round;
    private int numberOfRounds;

    public PrintScores(List<Player> players, int round, int numberOfRounds) {
        this.players = players;
        this.round = round;
        this.numberOfRounds = numberOfRounds;
    }


    public void printRoundScores() {
        System.out.println("SCORES FOR ROUND " + round + ":");
        System.out.println("-------------------");
        for (Player p : players) {
            System.out.println("Player " + p.getPlayerNumber() + ": " + p.getRoundScore() + " points");
        }
    }

    public void printTotalScores() {

        // start showing total scores after round 1 onwards
        if (round > 1 & round != numberOfRounds) {
            System.out.println("TOTAL POINTS AFTER ROUND " + round + ":");
            System.out.println("---------------------------");
            for (Player p : players) {
                System.out.println("Player " + p.getPlayerNumber() + ": " + p.getPlayerTotalScore() + " points");
            }
        }
    }

}

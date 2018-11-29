import java.util.List;

public class PrintScores {

    public void printRoundScores(List<Player> players, int round) {
        System.out.println("SCORES FOR ROUND " + round + ":");
        System.out.println("-------------------");
        for (Player p : players) {
            System.out.println("Player " + p.getPlayerNumber() + ": " + p.getRoundScore() + " points");
        }
    }

    public void printTotalScores(List<Player> players, int round, int numberOfRounds) {

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

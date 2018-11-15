import java.util.List;
import java.util.TreeSet;

public class DetermineOverallWinner {

    private List<Player> players;

    public DetermineOverallWinner(List<Player> players) {
        this.players = players;
    }

    public void outputFinalStandings() {

        TreeSet<Integer> ascendingScores = new TreeSet<>();
        TreeSet<Integer> descendingScores;

        for (Player p : players) {
            ascendingScores.add(p.getPlayerTotalScore());
        }

        descendingScores = (TreeSet<Integer>)ascendingScores.descendingSet();

        System.out.println("---------------------------------");
        System.out.println("FINAL RESULTS:");
        System.out.println("---------------------------------");

        int place = 1;

        for (Integer i : descendingScores) {
            int count = 0;
            for (Player p : players) {
                if (p.getPlayerTotalScore() == i) {
                    System.out.print(place + ": Player " + p.getPlayerNumber() + " (" + p.getPlayerTotalScore() + " points)");
                    count++;
                    if (place == 1) {
                        System.out.println(" WINNER " + "\u2654");
                    } else {
                        System.out.println();
                    }

                }
            }
            place += count;
        }
    }

}

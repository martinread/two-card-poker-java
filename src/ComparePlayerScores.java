import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparePlayerScores {

    public void assignRoundPoints(List<Player> players) {

        Comparator<Player> playerComparator = new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {

                int o1_handRank = o1.getRoundRank().getHandRank();
                int o2_handRank = o2.getRoundRank().getHandRank();
                int o1_bestCardRank = o1.getRoundBestCard().getRank().getCardRank();
                int o2_bestCardRank = o2.getRoundBestCard().getRank().getCardRank();
                int o1_bestCardSuit = o1.getRoundBestCard().getSuit().getSuitRank();
                int o2_bestCardSuit = o2.getRoundBestCard().getSuit().getSuitRank();

                if (o1_handRank == o2_handRank) {
                    if (o1_bestCardRank == o2_bestCardRank) {
                        return o1_bestCardSuit - o2_bestCardSuit;
                    } else {
                        return o1_bestCardRank - o2_bestCardRank;
                    }
                } else {
                    return o1_handRank - o2_handRank;
                }
            }
        };

        Collections.sort(players, playerComparator);

        // assign player points per their position in the sorted List.
        for (int i = 0; i < players.size(); i++) {
            players.get(i).updatedPlayerScore(i);
        }

        // reorder the player List back to natural ascending order
        players.sort(Comparator.comparing(Player::getPlayerNumber));
    }
    
}

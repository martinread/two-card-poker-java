public class CalculatePlayerScore {

    private Player player;

    public CalculatePlayerScore(Player player) {
        this.player = player;
    }

    public void playerHandRank() {

        Card[] playerHand = player.getPlayerHand();
        Card card1 = playerHand[0];
        Card card2 = playerHand[1];

        int compareCardRanks = card1.getRank().getCardRank() - card2.getRank().getCardRank();
        int compareSuitRanks = card1.getSuit().getSuitRank() - card2.getSuit().getSuitRank();

        // find the player's best card (used for breaking ties with other players):
        if (compareCardRanks > 0) {
            player.setRoundBestCard(card1);
        } else if (compareCardRanks < 0) {
            player.setRoundBestCard(card2);
        } else if (compareSuitRanks > 0) {
            player.setRoundBestCard(card1);
        } else {
            player.setRoundBestCard(card2);
        }

        // if both cards have the same suit
        if (card1.getSuit() == card2.getSuit()) {
            // if difference in card ranks is -1/1 or -12/12 (for A/2) then it is a straight
            if (compareCardRanks == 1 || compareCardRanks == -1 || compareCardRanks == 12 || compareCardRanks == -12) {
                player.setRoundRank(HandRank.STRAIGHT_FLUSH);
            } else {
                player.setRoundRank(HandRank.FLUSH);
            }
        // else if difference in card ranks is -1/1 or -12/12 (for A/2) then it is a straight
        } else if (compareCardRanks == 1 || compareCardRanks == -1 || compareCardRanks == 12 || compareCardRanks == -12) {
            player.setRoundRank(HandRank.STRAIGHT);
        // else if player has a pair
        } else if (card1.getRank().getCardRank() == card2.getRank().getCardRank()) {
            player.setRoundRank(HandRank.ONE_PAIR);
        // else, player has a high card
        } else {
            player.setRoundRank(HandRank.HIGH_CARD);
        }
    }

}

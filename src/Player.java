public class Player {

    private int playerNumber;
    private int roundScore;
    private int playerTotalScore = 0;
    private Card[] playerHand;
    private HandRank roundRank;
    private Card roundBestCard;

    public Player(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getPlayerTotalScore() {
        return playerTotalScore;
    }

    public Card[] getPlayerHand() {
        return playerHand;
    }

    public void updatedPlayerScore(int roundScore) {
        this.roundScore = roundScore;
        playerTotalScore += roundScore;
    }

    public void setPlayerHand(Card[] playerHand) {
        this.playerHand = playerHand;
    }

    public void setRoundRank(HandRank roundRank) {
        this.roundRank = roundRank;
    }

    public Card getRoundBestCard() {
        return roundBestCard;
    }

    public void setRoundBestCard(Card roundBestCard) {
        this.roundBestCard = roundBestCard;
    }

    public HandRank getRoundRank() {
        return roundRank;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public int getRoundScore() {
        return roundScore;
    }
}

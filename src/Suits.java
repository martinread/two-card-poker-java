public enum Suits {
    SPADES (4),
    CLUBS (3),
    HEARTS (2),
    DIAMONDS (1);

    private final int suitRank;

    Suits(int suitRank) {
        this.suitRank = suitRank;
    }

    public int getSuitRank() {
        return suitRank;
    }
}


public enum HandRank {

    STRAIGHT_FLUSH (5),
    FLUSH (4),
    STRAIGHT (3),
    ONE_PAIR (2),
    HIGH_CARD (1);

    private final int handRank;

    HandRank(int handRank) {
        this.handRank = handRank;
    }

    public int getHandRank() {
        return handRank;
    }
}

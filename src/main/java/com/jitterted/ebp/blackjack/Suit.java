package com.jitterted.ebp.blackjack;

public enum Suit {
    SPADES("♠", false),
    DIAMONDS("♦", true),
    HEARTS("♥", true),
    CLUBS("♣", false);

    private final String symbol;
    private final boolean isRed;

    Suit(String symbol, boolean isRed) {
        this.symbol = symbol;
        this.isRed = isRed;
    }

    public String symbol() {
        return symbol;
    }

    boolean isRed() {
        return isRed;
    }
}

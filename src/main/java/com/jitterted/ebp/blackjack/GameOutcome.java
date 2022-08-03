package com.jitterted.ebp.blackjack;

public enum GameOutcome {
    PLAYER_WINS(2.0),
    PLAYER_LOSES(0),
    PLAYER_PUSHES(1.0),
    PLAYER_BLACKJACK(2.5);

    private final double payoffMultiplier;

    GameOutcome(double payoffMultiplier) {
        this.payoffMultiplier = payoffMultiplier;
    }

    public int payoffAmount(int playerBetAmount) {
        return (int) (playerBetAmount * payoffMultiplier);
    }
}

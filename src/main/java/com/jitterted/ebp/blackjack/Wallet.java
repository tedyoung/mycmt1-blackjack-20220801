package com.jitterted.ebp.blackjack;

public class Wallet {

    private int balance = 0;

    public boolean isEmpty() {
        return balance == 0;
    }

    public void addMoney(int amount) {
        requireGreaterThanZeroAmount(amount);
        balance += amount;
    }

    public int balance() {
        return balance;
    }

    public void bet(int betAmount) {
        requireSufficientBalanceToBet(betAmount);
        balance -= betAmount;
    }

    private void requireSufficientBalanceToBet(int betAmount) {
        if (betAmount > balance) {
            throw new IllegalStateException();
        }
    }

    private void requireGreaterThanZeroAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
    }
}

package com.jitterted.ebp.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.fusesource.jansi.Ansi.ansi;

public class Hand {
    private final List<Card> cards = new ArrayList<>();

    public Hand() {
    }

    public Hand(List<Card> cards) {
        this.cards.addAll(cards);
    }

    // not allowed to ask this question if one of the hands is Busted
    void drawCard(Deck deck) {
        cards.add(deck.draw());
    }

    int value() {
        int handValue = rawValue();

        // if the total hand value <= 11, then count the Ace as 11 by adding 10
        if (hasAce() && handValue <= 11) {
            handValue += 10;
        }

        return handValue;
    }

    void display() {
        System.out.println(cards.stream()
                                .map(Card::display)
                                .collect(Collectors.joining(
                                        ansi().cursorUp(6).cursorRight(1).toString())));
    }

    Card faceUpCard() {
        return cards.get(0);
    }

    private int rawValue() {
        return cards
                .stream()
                .mapToInt(Card::rankValue)
                .sum();
    }

    private boolean hasAce() {
        return cards
                .stream()
                .anyMatch(card -> card.rankValue() == 1);
    }

    // should not ask unless player is "done"
    boolean isBusted() {
        return value() > 21;
    }

    // not allowed to ask this question if one of the hands is Busted
    boolean pushes(Hand hand) {
        return value() == hand.value();
    }

    // not allowed to ask this question if one of the hands is Busted
    boolean beats(Hand hand) {
        return hand.value() < value();
    }

    boolean shouldHit() {
        return value() <= 16;
    }
}

package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

    private static final Suit DUMMY_SUIT = Suit.SPADES;

    @Test
    public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
        Hand hand = HandFactory.createHandWithRanksOf("A", "9");

        assertThat(hand.value())
                .isEqualTo(11 + 9); // EVIDENT DATA
    }

    @Test
    public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
        Hand hand = HandFactory.createHandWithRanksOf("A", "8", "3");

        assertThat(hand.value())
                .isEqualTo(1 + 8 + 3);
    }

    // Ace + 10 or Face Card (J/Q/K) should result in a total of 21 (Ace counts as 11)
    @Test
    public void handWithAceAndTenValueCardThenAceIsValuedAt11() throws Exception {
        Hand hand = HandFactory.createHandWithRanksOf("A", "Q");

        assertThat(hand.value())
                .isEqualTo(11 + 10);
    }

}

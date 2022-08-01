package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SuitTest {

    @Test
    public void heartsAreRed() throws Exception {
        assertThat(Suit.HEARTS.isRed())
                .isTrue();
    }

    @Test
    public void spadesAreBlack() throws Exception {
        assertThat(Suit.SPADES.isRed())
                .isFalse();
    }
}
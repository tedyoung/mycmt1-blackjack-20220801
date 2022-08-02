package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HandTest {

    @Test
    public void handWithValueOf21IsNotBusted() throws Exception {
        Hand hand = HandFactory.createHandWithRanksOf("6", "5", "10");

        assertThat(hand.isBusted())
                .isFalse();
    }

    @Test
    public void handWithValueOf22IsBusted() throws Exception {
        Hand hand = HandFactory.createHandWithRanksOf("6", "6", "10");

        assertThat(hand.isBusted())
                .isTrue();
    }


}

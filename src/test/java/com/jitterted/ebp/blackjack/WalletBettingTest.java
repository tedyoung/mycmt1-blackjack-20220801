package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WalletBettingTest {
    
    @Test
    public void walletWithBalance12WhenBet8BalanceIs4() throws Exception {
        Wallet wallet = createWalletWithInitialAmountOf(12);

        wallet.bet(8);

        assertThat(wallet.balance())
                .isEqualTo(12 - 8);
    }

    @Test
    public void walletWithBalance27WhenBet7And9BalanceIs11() throws Exception {
        Wallet wallet = createWalletWithInitialAmountOf(27);

        wallet.bet(7);
        wallet.bet(9);

        assertThat(wallet.balance())
                .isEqualTo(27 - 7 - 9);
    }



    private Wallet createWalletWithInitialAmountOf(int initialAmount) {
        Wallet wallet = new Wallet();
        wallet.addMoney(initialAmount);
        return wallet;
    }

}




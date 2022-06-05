package com.jantoni1.recruitmentapp.transaction.reward;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static com.jantoni1.recruitmentapp.transaction.reward.TestPurchaseCreator.createPurchase;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoTypeRewardCalculatorTest {

    private final TwoTypeRewardCalculator twoTypeRewardCalculator = new TwoTypeRewardCalculator();

    @Test
    @DisplayName(value = "Should calculate reward of 90 points for one $120 purchase")
    void should_calculate_90_point_reward_for_120_dollar_purchase() {
        //region given
        var purchase = createPurchase(BigDecimal.valueOf(120));
        //endregion

        //region when
        var bonusPoints = twoTypeRewardCalculator.calculatePurchaseReward(purchase);
        //endregion

        //region then
        assertEquals(BigInteger.valueOf(90), bonusPoints);
        //endregion
    }

    @Test
    @DisplayName(value = "Should calculate reward of 0 points for one $50 purchase")
    void should_calculate_0_point_reward_for_50_dollar_purchase() {
        //region given
        var purchase = createPurchase(BigDecimal.valueOf(50));
        //endregion

        //region when
        var bonusPoints = twoTypeRewardCalculator.calculatePurchaseReward(purchase);
        //endregion

        //region then
        assertEquals(BigInteger.ZERO, bonusPoints);
        //endregion
    }

    @Test
    @DisplayName(value = "Should calculate reward of 0 points for one $40 purchase")
    void should_calculate_0_point_reward_for_40_dollar_purchase() {
        //region given
        var purchase = createPurchase(BigDecimal.valueOf(40));
        //endregion

        //region when
        var bonusPoints = twoTypeRewardCalculator.calculatePurchaseReward(purchase);
        //endregion

        //region then
        assertEquals(BigInteger.ZERO, bonusPoints);
        //endregion
    }

    @Test
    @DisplayName(value = "Should calculate reward of 0 point for one $50.99 purchase")
    void should_calculate_0_point_reward_for_50_99_dollar_purchase() {
        //region given
        var purchase = createPurchase(BigDecimal.valueOf(50.99));
        //endregion

        //region when
        var bonusPoints = twoTypeRewardCalculator.calculatePurchaseReward(purchase);
        //endregion

        //region then
        assertEquals(BigInteger.ZERO, bonusPoints);
        //endregion
    }

    @Test
    @DisplayName(value = "Should calculate reward of 1 point for one $51.99 purchase")
    void should_calculate_1_point_reward_for_51_99_dollar_purchase() {
        //region given
        var purchase = createPurchase(BigDecimal.valueOf(51.99));
        //endregion

        //region when
        var bonusPoints = twoTypeRewardCalculator.calculatePurchaseReward(purchase);
        //endregion

        //region then
        assertEquals(BigInteger.ONE, bonusPoints);
        //endregion
    }

    @Test
    @DisplayName(value = "Should calculate reward of 50 points for one $100 purchase")
    void should_calculate_50_point_reward_for_100_dollar_purchase() {
        //region given
        var purchase = createPurchase(BigDecimal.valueOf(51.99));
        //endregion

        //region when
        var bonusPoints = twoTypeRewardCalculator.calculatePurchaseReward(purchase);
        //endregion

        //region then
        assertEquals(BigInteger.ONE, bonusPoints);
        //endregion
    }

}

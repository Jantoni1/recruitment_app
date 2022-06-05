package com.jantoni1.recruitmentapp.transaction.reward;

import com.jantoni1.recruitmentapp.transaction.customer.dto.Customer;
import com.jantoni1.recruitmentapp.transaction.reward.dto.CustomerRewardSummary;
import com.jantoni1.recruitmentapp.transaction.reward.dto.MonthlyReward;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

import static com.jantoni1.recruitmentapp.transaction.reward.TestPurchaseCreator.createPurchase;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoTypeRewardSummaryCalculatorTest {

    private final RewardSummaryCalculator rewardSummaryCalculator = new TwoTypeRewardSummaryCalculator();

    @Test
    @DisplayName(value = "Should calculate 0 bonus for 3 purchases $50 each")
    void should_calculate_0_bonus_for_3_purchases_50_dollar_each() {
        //region given
        var may2022 = LocalDate.of(2022, Month.MAY, 20).atStartOfDay();
        var customerId = UUID.randomUUID();

        var customerOnePurchases = List.of(
                createPurchase(BigDecimal.valueOf(50), may2022, customerId),
                createPurchase(BigDecimal.valueOf(50), may2022, customerId),
                createPurchase(BigDecimal.valueOf(50), may2022, customerId)
        );

        var customerWithPurchases = new Customer(customerId, "", "", customerOnePurchases);
        //endregion

        //region when
        var summary = rewardSummaryCalculator.calculateRewardSummaries(
                customerWithPurchases,
                LocalDate.of(2022, Month.MAY, 1)
        );
        //endregion

        //region then
        assertEquals(BigInteger.ZERO, summary.getTotalPoints());

        assertTotalPoints(
                BigInteger.ZERO,
                BigInteger.ZERO,
                BigInteger.ZERO
        ).accept(summary);
        //endregion
    }

    @Test
    @DisplayName(value = "Should calculate reward of 150 points for exactly one user")
    void should_calculate_rewards_for_one_month() {
        //region given
        var customerId = UUID.randomUUID();
        var may2022 = LocalDate.of(2022, Month.MAY, 20).atStartOfDay();
        var customerOnePurchases = List.of(
                createPurchase(BigDecimal.valueOf(100), may2022, customerId),
                createPurchase(BigDecimal.valueOf(100), may2022, customerId),
                createPurchase(BigDecimal.valueOf(100), may2022, customerId)
        );

        var customerWithPurchases = new Customer(customerId, "", "", customerOnePurchases);

        //endregion

        //region when
        var summary = rewardSummaryCalculator.calculateRewardSummaries(
                customerWithPurchases,
                LocalDate.of(2022, Month.MAY, 1)
        );
        //endregion

        //region then
        assertEquals(BigInteger.valueOf(150), summary.getTotalPoints());

        assertTotalPoints(
                BigInteger.valueOf(150),
                BigInteger.ZERO,
                BigInteger.ZERO
        ).accept(summary);
        //endregion
    }

    @Test
    @DisplayName(value = "Should calculate reward of 50 points for May and 50 points for June (100 points in total)")
    void should_calculate_points_for_two_different_months_separately() {
        //region given
        var customerId = UUID.randomUUID();
        var customerOnePurchases = List.of(
                createPurchase(BigDecimal.valueOf(100), LocalDate.of(2022, Month.MAY, 31).atTime(LocalTime.MAX), customerId),
                createPurchase(BigDecimal.valueOf(100), LocalDate.of(2022, Month.JUNE, 1).atStartOfDay(), customerId)
        );

        var customerWithPurchases = new Customer(customerId, "", "", customerOnePurchases);
        //endregion

        //region when
        var summary = rewardSummaryCalculator.calculateRewardSummaries(
                customerWithPurchases,
                LocalDate.of(2022, Month.MAY, 1)
        );
        //endregion

        //region then
        assertEquals(BigInteger.valueOf(100), summary.getTotalPoints());

        assertMonthlyPointsAndDate(
                tuple(
                        LocalDate.of(2022, Month.MAY, 1),
                        BigInteger.valueOf(50)
                ),
                tuple(
                        LocalDate.of(2022, Month.JUNE, 1),
                        BigInteger.valueOf(50)
                ),
                tuple(
                        LocalDate.of(2022, Month.JULY, 1),
                        BigInteger.ZERO
                )
        ).accept(summary);
        //endregion
    }

    @Test
    @DisplayName(value = "Should calculate 0 bonus for one $100 purchase before requested 3 month period")
    void should_calculate_0_bonus_for_one_100_dollar_purchase_made_before_requested_3_month_period() {
        //region given
        var may2022 = LocalDate.of(2022, Month.MAY, 20).atStartOfDay();
        var customerId = UUID.randomUUID();

        var customerOnePurchases = List.of(
                createPurchase(BigDecimal.valueOf(100), may2022, customerId)
        );

        var customerWithPurchases = new Customer(customerId, "", "", customerOnePurchases);
        //endregion

        //region when
        var summary = rewardSummaryCalculator.calculateRewardSummaries(
                customerWithPurchases,
                LocalDate.of(2022, Month.JUNE, 1)
        );
        //endregion

        //region then
        assertEquals(BigInteger.ZERO, summary.getTotalPoints());

        assertTotalPoints(
                BigInteger.ZERO,
                BigInteger.ZERO,
                BigInteger.ZERO
        ).accept(summary);
        //endregion
    }

    private Consumer<CustomerRewardSummary> assertTotalPoints(BigInteger ...points) {
        return summary -> assertThat(summary.getMonthlyRewardSummaries())
                .flatExtracting(MonthlyReward::getPoints)
                .containsExactly(points);
    }

    private Consumer<CustomerRewardSummary> assertMonthlyPointsAndDate(Tuple ...pointsAndDates) {
        return customerRewardSummary -> assertThat(customerRewardSummary.getMonthlyRewardSummaries())
                .extracting(
                        MonthlyReward::getStartDate,
                        MonthlyReward::getPoints
                )
                .containsExactly(
                        pointsAndDates
                );
    }

}

package com.jantoni1.recruitmentapp.transaction.reward;

import com.jantoni1.recruitmentapp.transaction.customer.dto.Customer;
import com.jantoni1.recruitmentapp.transaction.reward.dto.CustomerRewardSummary;
import com.jantoni1.recruitmentapp.transaction.reward.dto.MonthlyReward;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
class TwoTypeRewardSummaryCalculator implements RewardSummaryCalculator {

    private final TwoTypeRewardCalculator twoTypeRewardCalculator = new TwoTypeRewardCalculator();

    public CustomerRewardSummary calculateRewardSummaries(Customer customersWithPurchases, LocalDate threeMonthPeriodStart) {
        var customerRewardSummary = createCustomerRewardSummary(customersWithPurchases.getId(), threeMonthPeriodStart);
        customersWithPurchases.getPurchases().forEach(purchase -> {
            var purchaseDate = purchase.getPurchaseDate().toLocalDate();
            var rewardPoints = twoTypeRewardCalculator.calculatePurchaseReward(purchase);
            customerRewardSummary.addRewardPoints(purchaseDate, rewardPoints);
        });
        return customerRewardSummary;
    }

    private CustomerRewardSummary createCustomerRewardSummary(UUID customerId, LocalDate threeMonthPeriodStart) {
        var months = IntStream.range(0, 3)
                .mapToObj(shift -> threeMonthPeriodStart.with(TemporalAdjusters.firstDayOfMonth()).plusMonths(shift))
                .map(monthStart -> new MonthlyReward(monthStart, monthStart.plusMonths(1)))
                .collect(Collectors.toList());

        return new CustomerRewardSummary(customerId, months, BigInteger.ZERO);
    }

}

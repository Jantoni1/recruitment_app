package com.jantoni1.recruitmentapp.transaction.reward;

import com.jantoni1.recruitmentapp.transaction.customer.dto.Customer;
import com.jantoni1.recruitmentapp.transaction.reward.dto.CustomerRewardSummary;

import java.time.LocalDate;

interface RewardSummaryCalculator {

    CustomerRewardSummary calculateRewardSummaries(Customer customersWithPurchases, LocalDate threeMonthPeriodStart);

}

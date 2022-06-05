package com.jantoni1.recruitmentapp.transaction.reward;

import com.jantoni1.recruitmentapp.transaction.customer.CustomerFacade;
import com.jantoni1.recruitmentapp.transaction.customer.dto.Customer;
import com.jantoni1.recruitmentapp.transaction.customer.dto.CustomerPurchasesRequest;
import com.jantoni1.recruitmentapp.transaction.reward.dto.CustomerRewardSummary;
import com.jantoni1.recruitmentapp.transaction.reward.dto.RewardRequest;
import com.jantoni1.recruitmentapp.transaction.reward.dto.RewardSummaryAggregate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;

@RequiredArgsConstructor
@Slf4j
@Component
@Validated
class RewardCalculateUseCase {

    private final RewardSummaryCalculator rewardSummaryCalculator;

    private final CustomerFacade customerFacade;

    public RewardSummaryAggregate execute(@Valid RewardRequest request) {
        log.info("Executed RewardCalculateUseCase with payload {}", request);

        var threeMonthPeriodStart = LocalDate.of(request.getYear(), request.getMonth(), 1);

        var customerPurchasesRequest = new CustomerPurchasesRequest(threeMonthPeriodStart, threeMonthPeriodStart.plusMonths(3));
        var customersWithPurchases = customerFacade.findAll(customerPurchasesRequest);

        return customersWithPurchases.stream()
                .map(mapCustomerToRewardSummary(threeMonthPeriodStart))
                .collect(collectingAndThen(Collectors.toList(), RewardSummaryAggregate::new));
    }

    private Function<Customer, CustomerRewardSummary> mapCustomerToRewardSummary(LocalDate threeMonthPeriodStart) {
        return customerWithPurchases -> rewardSummaryCalculator.calculateRewardSummaries(customerWithPurchases, threeMonthPeriodStart);
    }

}

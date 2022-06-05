package com.jantoni1.recruitmentapp.transaction.reward.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class RewardSummaryAggregate {

    private final List<CustomerRewardSummary> rewardSummaries;

}

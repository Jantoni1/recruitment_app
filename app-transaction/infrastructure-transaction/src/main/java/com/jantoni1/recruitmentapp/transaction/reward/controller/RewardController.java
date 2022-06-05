package com.jantoni1.recruitmentapp.transaction.reward.controller;

import com.jantoni1.recruitmentapp.transaction.reward.RewardFacade;
import com.jantoni1.recruitmentapp.transaction.reward.dto.RewardRequest;
import com.jantoni1.recruitmentapp.transaction.reward.dto.RewardSummaryAggregate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RewardController implements RewardClient {

    private final RewardFacade facade;

    @Override
    public RewardSummaryAggregate getRewardsAggregate(
            @PathVariable(name = "firstMonth") Integer firstMonth,
            @PathVariable(name = "year") Integer year) {
        RewardRequest rewardRequest = new RewardRequest(firstMonth, year);
        return facade.getRewardSummary(rewardRequest);
    }

}

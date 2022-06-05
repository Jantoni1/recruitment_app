package com.jantoni1.recruitmentapp.transaction.reward;

import com.jantoni1.recruitmentapp.transaction.reward.dto.RewardRequest;
import com.jantoni1.recruitmentapp.transaction.reward.dto.RewardSummaryAggregate;

public interface RewardFacade {

    RewardSummaryAggregate getRewardSummary(RewardRequest rewardRequest);

}

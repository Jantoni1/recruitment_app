package com.jantoni1.recruitmentapp.transaction.reward;

import com.jantoni1.recruitmentapp.transaction.reward.dto.RewardRequest;
import com.jantoni1.recruitmentapp.transaction.reward.dto.RewardSummaryAggregate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
class DirectRewardFacade implements RewardFacade {

    private final RewardCalculateUseCase rewardCalculateUseCase;

    @Override
    public RewardSummaryAggregate getRewardSummary(RewardRequest rewardRequest) {
        return rewardCalculateUseCase.execute(rewardRequest);
    }

}

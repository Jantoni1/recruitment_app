package com.jantoni1.recruitmentapp.transaction.reward.dto;

import lombok.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class CustomerRewardSummary {

    private UUID customerId;

    private List<MonthlyReward> monthlyRewardSummaries;

    private BigInteger totalPoints = BigInteger.ZERO;

    public void addRewardPoints(LocalDate purchaseDate, BigInteger points) {
        getMonthlyRewardSummaries().stream()
                .filter(reward -> purchaseDate.isBefore(reward.getEndDateExclusive())
                        && !purchaseDate.isBefore(reward.getStartDate()))
                .findAny()
                .ifPresent(reward -> {
                    reward.setPoints(reward.getPoints().add(points));
                    setTotalPoints(totalPoints.add(points));
                });
    }
}

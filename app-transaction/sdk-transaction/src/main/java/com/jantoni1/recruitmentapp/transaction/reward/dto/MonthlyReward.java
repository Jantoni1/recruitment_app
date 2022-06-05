package com.jantoni1.recruitmentapp.transaction.reward.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
public class MonthlyReward {
    private final LocalDate startDate;
    private final LocalDate endDateExclusive;
    @Setter
    private BigInteger points = BigInteger.ZERO;
}

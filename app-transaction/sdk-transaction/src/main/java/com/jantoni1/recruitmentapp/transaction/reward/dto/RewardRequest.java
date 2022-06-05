package com.jantoni1.recruitmentapp.transaction.reward.dto;

import com.jantoni1.recruitmentapp.transaction.reward.validation.ValidMonth;
import com.jantoni1.recruitmentapp.transaction.reward.validation.ValidYear;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class RewardRequest implements Serializable {

    @ValidMonth
    private final Integer month;

    @ValidYear
    private final Integer year;

}

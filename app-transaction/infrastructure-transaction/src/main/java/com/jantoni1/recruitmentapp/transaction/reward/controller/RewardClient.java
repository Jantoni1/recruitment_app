package com.jantoni1.recruitmentapp.transaction.reward.controller;

import com.jantoni1.recruitmentapp.transaction.exception.error.ApiError;
import com.jantoni1.recruitmentapp.transaction.reward.dto.RewardSummaryAggregate;
import com.jantoni1.recruitmentapp.transaction.reward.validation.ValidMonth;
import com.jantoni1.recruitmentapp.transaction.reward.validation.ValidYear;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "reward")
@Api(tags = "Rewards")
@Validated
public interface RewardClient {

    @ApiOperation(value = "Get rewards aggregate containing a summary for each user of a given three month period rewards")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Generated summary successfully",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RewardSummaryAggregate.class)
                    )
            ),
            @ApiResponse(responseCode = "422", description = "Invalid month/year",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiError.class)
                    )),
    })
    @GetMapping("/summary/{firstMonth}/{year}")
    RewardSummaryAggregate getRewardsAggregate(
            @ValidMonth @PathVariable(name = "firstMonth") Integer firstMonth,
            @ValidYear @PathVariable(name = "year") Integer year
    );

}

package com.jantoni1.recruitmentapp.transaction.purchase.controller;

import com.jantoni1.recruitmentapp.transaction.exception.error.ApiError;
import com.jantoni1.recruitmentapp.transaction.purchase.dto.Purchase;
import com.jantoni1.recruitmentapp.transaction.purchase.dto.PurchaseCreate;
import com.jantoni1.recruitmentapp.transaction.purchase.dto.PurchaseUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping(value = "purchase")
@Api(tags = "Purchases")
public interface PurchaseClient {

    @ApiOperation(value = "Update Purchase")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Purchase has been updated",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Purchase.class)
                    )
            ),
            @ApiResponse(responseCode = "404", description = "Purchase/Customer not found",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiError.class)
                    )),
            @ApiResponse(responseCode = "422", description = "Invalid update request data",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiError.class)
                    )),
            @ApiResponse(responseCode = "422", description = "Invalid update request data",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiError.class)
                    )),
            @ApiResponse(responseCode = "400", description = "Invalid purchase id supplied", content = @Content)
    })
    @PutMapping(
            consumes = {"application/json"},
            value = {"/{id}"}
    )
    Purchase update(@PathVariable(value = "id") UUID id, @RequestBody() PurchaseUpdate update);

    @ApiOperation(value = "Create Purchase")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Purchase has been created",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Purchase.class)
                    )
            ),
            @ApiResponse(responseCode = "422", description = "Invalid update request data",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiError.class)
                    )),
            @ApiResponse(responseCode = "404", description = "Customer not found",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiError.class)
                    )),
    })

    @PostMapping(consumes = {"application/json"})
    Purchase create(@RequestBody() PurchaseCreate create);

}

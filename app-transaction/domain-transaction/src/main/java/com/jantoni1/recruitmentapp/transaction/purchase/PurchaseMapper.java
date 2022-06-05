package com.jantoni1.recruitmentapp.transaction.purchase;

import org.mapstruct.Mapper;
import com.jantoni1.recruitmentapp.transaction.purchase.dto.Purchase;
import com.jantoni1.recruitmentapp.transaction.purchase.dto.PurchaseCreate;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import com.jantoni1.recruitmentapp.transaction.purchase.dto.PurchaseUpdate;

@Mapper(componentModel = "spring")
abstract class PurchaseMapper {

    @Mapping(target = "withId", ignore = true)
    @Mapping(target = "id", ignore = true)
    public abstract Purchase toDto(PurchaseCreate model);

    @Mapping(target = "withId", ignore = true)
    @Mapping(target = "id", ignore = true)
    public abstract Purchase applyChanges(@MappingTarget() Purchase model, PurchaseUpdate update);
}

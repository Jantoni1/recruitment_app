package com.jantoni1.recruitmentapp.transaction.purchase;

import com.jantoni1.recruitmentapp.transaction.customer.CustomerEntity;
import org.mapstruct.Mapper;
import com.jantoni1.recruitmentapp.transaction.purchase.dto.Purchase;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class PurchaseEntityMapper {

    public abstract List<Purchase> toDtoList(List<PurchaseEntity> purchaseEntities);
    @Mapping(target = "withId", ignore = true)
    @Mapping(target = "customerId", source = "customer.id")
    public abstract Purchase toDto(PurchaseEntity entity);

    @Mapping(target = "customer", expression = "java(getCustomerEntity(model.getCustomerId()))")
    public abstract PurchaseEntity toEntity(Purchase model);
    @Mapping(target = "customer", expression = "java(getCustomerEntity(model.getCustomerId()))")
    public abstract PurchaseEntity applyChanges(@MappingTarget() PurchaseEntity entity, Purchase model);

    protected CustomerEntity getCustomerEntity(UUID customerId) {
        var customer = new CustomerEntity();
        customer.setId(customerId);
        return customer;
    }

}

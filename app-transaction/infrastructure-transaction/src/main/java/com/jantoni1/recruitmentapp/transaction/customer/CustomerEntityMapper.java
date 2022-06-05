package com.jantoni1.recruitmentapp.transaction.customer;

import com.jantoni1.recruitmentapp.transaction.customer.dto.Customer;
import com.jantoni1.recruitmentapp.transaction.purchase.PurchaseEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = PurchaseEntityMapper.class)
abstract class CustomerEntityMapper {

    public abstract Customer toDto(CustomerEntity entity);

}

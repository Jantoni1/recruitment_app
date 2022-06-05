package com.jantoni1.recruitmentapp.transaction.customer;

import com.jantoni1.recruitmentapp.transaction.customer.dto.CustomerPurchasesRequest;
import com.jantoni1.recruitmentapp.transaction.purchase.PurchaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

@RequiredArgsConstructor
class CustomerEntitySpec implements Specification<CustomerEntity> {

    private final CustomerPurchasesRequest spec;

    @Override
    public Predicate toPredicate(Root<CustomerEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        criteriaQuery.distinct(true);

        Join<CustomerEntity, PurchaseEntity> purchaseJoin = root.join("purchases", JoinType.LEFT);
        return criteriaBuilder.or(
                criteriaBuilder.isNull(purchaseJoin.get("purchaseDate")),
                criteriaBuilder.and(
                        criteriaBuilder.lessThan(purchaseJoin.get("purchaseDate"), spec.getTo().atStartOfDay()),
                        criteriaBuilder.greaterThanOrEqualTo(purchaseJoin.get("purchaseDate"), spec.getFrom().atStartOfDay())
                )
        );
    }

}

package com.jantoni1.recruitmentapp.transaction.purchase;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

interface PurchaseEntityRepository extends JpaRepository<PurchaseEntity, UUID>, JpaSpecificationExecutor<PurchaseEntity> {
}

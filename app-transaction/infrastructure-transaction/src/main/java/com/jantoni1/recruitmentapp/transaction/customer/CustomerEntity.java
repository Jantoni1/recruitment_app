package com.jantoni1.recruitmentapp.transaction.customer;

import com.jantoni1.recruitmentapp.transaction.purchase.PurchaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity(name = "customer")
@Setter
@Getter
public class CustomerEntity {

    @Id
    @Column(updatable = false)
    protected UUID id = new UUID(0,0);

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "customer")
    private List<PurchaseEntity> purchases;

}

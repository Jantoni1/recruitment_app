package com.jantoni1.recruitmentapp.jpa;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import java.util.UUID;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Column(updatable = false)
    protected UUID id = new UUID(0,0);

    @CreatedDate
    @Column(updatable = false)
    protected Timestamp createdAt;

    @LastModifiedDate
    @Column(insertable = false)
    protected Timestamp updatedAt;

    @CreatedBy
    @Column(updatable = false)
    protected UUID createdById;

    @LastModifiedBy
    @Column(insertable = false)
    protected UUID updatedById;
}

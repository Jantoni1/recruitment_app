package com.jantoni1.recruitmentapp.request.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
@Data
@NoArgsConstructor
public abstract class BaseRequest implements Serializable {
    protected int pageNumber = 0;
    protected int pageSize = 50;
    protected String sort;
}
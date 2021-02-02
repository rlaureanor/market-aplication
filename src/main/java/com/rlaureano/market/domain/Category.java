package com.rlaureano.market.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Category {

    private Integer categoryId;
    private String name;
    private Boolean active;
}

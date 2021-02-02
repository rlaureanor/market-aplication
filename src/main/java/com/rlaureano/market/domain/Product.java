package com.rlaureano.market.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {

    private Integer productId;
    private String name;
    private Double price;
    private Integer stock;
    private Boolean active;
    private Integer categoryId;
    private Category category;


}
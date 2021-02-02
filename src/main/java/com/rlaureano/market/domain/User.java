package com.rlaureano.market.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private Integer userId;
    private String name;
    private String lastName;
    private String password;
    private String status;
}

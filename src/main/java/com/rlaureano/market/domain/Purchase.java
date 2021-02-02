package com.rlaureano.market.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
public class Purchase {
    private int purchaseId;
    private LocalDateTime date;
    private String paymentMethod;
    private String comment;
    private String state;
    private String clientId;
    private List<PurchaseItem> items;
}

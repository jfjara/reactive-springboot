package com.jfjara.reactive.domain.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
@Getter
public class Invoice {

    private static final double VAT = .21D;

    private String id;

    private String reference;

    private Double amount;

    private Shop shop;

    private String shopId;

    @Getter(AccessLevel.NONE)
    private LocalDateTime date;

    public LocalDateTime getDate() {
        return LocalDateTime.from(date);
    }

    public Double getTotalAmount() {
        return amount + getTotalVAT();
    }

    public Double getTotalVAT() {
        return amount * VAT;
    }


}

package com.jfjara.reactive.infrastucture.api.model;

import com.jfjara.reactive.domain.model.Shop;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExtendedInvoiceApi {

    private String id;

    private String reference;

    private Double amount;

    private Shop shop;

    private Double totalAmount;

    private Double totalVAT;

    private LocalDateTime date;


}

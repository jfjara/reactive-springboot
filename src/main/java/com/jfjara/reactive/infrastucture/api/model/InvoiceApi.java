package com.jfjara.reactive.infrastucture.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvoiceApi {

    private String id;
    private String reference;
    private Double amount;
    private LocalDateTime date;

}

package com.jfjara.reactive.infrastucture.mockserver.repository.util;

import com.jfjara.reactive.domain.model.Invoice;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class MockServerInvoiceFactory {

    public Invoice createInvoice(final int referenceCounter) {
        return Invoice.builder()
                .id(UUID.randomUUID().toString())
                .date(LocalDateTime.now())
                .amount(createAmount())
                .shopId(UUID.randomUUID().toString())
                .reference("REF-SERV-00" + referenceCounter)
                .build();
    }

    public Invoice createInvoice(final String id) {
        return Invoice.builder()
                .id(id)
                .date(LocalDateTime.now())
                .amount(createAmount())
                .reference("REF-SERV-001")
                .build();
    }

    public List<Invoice> createInvoiceCollection() {
        return IntStream.range(0, 10)
                .mapToObj(this::createInvoice) // or x -> new Object(x).. or any other constructor
                .collect(Collectors.toList());
    }

    private Double createAmount() {
        Random r = new Random();
        return 0.99 + (199.99 - 0.99) * r.nextDouble();
    }

}

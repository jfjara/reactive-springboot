package com.jfjara.reactive.application.usecase;

import com.jfjara.reactive.domain.model.Invoice;
import com.jfjara.reactive.domain.ports.FindInvoiceByIdPort;
import reactor.core.publisher.Mono;

public class FindInvoiceByIdUseCase {

    private final FindInvoiceByIdPort findInvoiceByIdPort;

    public FindInvoiceByIdUseCase(final FindInvoiceByIdPort findInvoiceByIdPort) {
        this.findInvoiceByIdPort = findInvoiceByIdPort;
    }

    public Mono<Invoice> execute(final String id) {
        return findInvoiceByIdPort.find(id);
    }
}

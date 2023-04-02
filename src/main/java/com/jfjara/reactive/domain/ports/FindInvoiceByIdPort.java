package com.jfjara.reactive.domain.ports;

import com.jfjara.reactive.domain.model.Invoice;
import reactor.core.publisher.Mono;

public interface FindInvoiceByIdPort {

    Mono<Invoice> find(final String id);

}

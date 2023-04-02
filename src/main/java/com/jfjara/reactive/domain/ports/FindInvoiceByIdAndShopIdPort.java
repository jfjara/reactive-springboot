package com.jfjara.reactive.domain.ports;

import com.jfjara.reactive.domain.model.Invoice;
import reactor.core.publisher.Mono;

public interface FindInvoiceByIdAndShopIdPort {

    Mono<Invoice> find(final String invoiceId, final String shopId);

}

package com.jfjara.reactive.application.usecase;

import com.jfjara.reactive.domain.model.Invoice;
import com.jfjara.reactive.domain.ports.FindInvoiceByIdAndShopIdPort;
import reactor.core.publisher.Mono;

public class FindInvoiceByIdAndShopUsecase {

    private final FindInvoiceByIdAndShopIdPort findInvoiceByIdAndShopId;

    public FindInvoiceByIdAndShopUsecase(final FindInvoiceByIdAndShopIdPort findInvoiceByIdAndShopId) {
        this.findInvoiceByIdAndShopId = findInvoiceByIdAndShopId;
    }

    public Mono<Invoice> execute(final String invoiceId, final String shopId) {
        return findInvoiceByIdAndShopId.find(invoiceId, shopId);
    }

}

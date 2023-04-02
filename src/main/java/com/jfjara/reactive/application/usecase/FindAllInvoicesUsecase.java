package com.jfjara.reactive.application.usecase;

import com.jfjara.reactive.domain.model.Invoice;
import com.jfjara.reactive.domain.ports.FindAllInvoicesPort;
import reactor.core.publisher.Flux;

public class FindAllInvoicesUsecase {

    private final FindAllInvoicesPort findAllInvoices;

    private final FindAllInvoicesPort findAllInvoicesMockServer;


    public FindAllInvoicesUsecase(final FindAllInvoicesPort findAllInvoices,
                                  final FindAllInvoicesPort findAllInvoicesMockServer) {
        this.findAllInvoices = findAllInvoices;
        this.findAllInvoicesMockServer = findAllInvoicesMockServer;
    }

    public Flux<Invoice> execute() {
        var invoicesFromCache = findAllInvoices.find();
        var invoicesFromMockServer = findAllInvoicesMockServer.find();
        return Flux.merge(invoicesFromCache, invoicesFromMockServer);
    }

}

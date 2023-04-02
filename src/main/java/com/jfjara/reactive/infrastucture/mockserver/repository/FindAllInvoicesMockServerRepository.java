package com.jfjara.reactive.infrastucture.mockserver.repository;

import com.jfjara.reactive.domain.model.Invoice;
import com.jfjara.reactive.domain.ports.FindAllInvoicesPort;
import com.jfjara.reactive.infrastucture.mockserver.repository.util.MockServerInvoiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Repository
public class FindAllInvoicesMockServerRepository implements FindAllInvoicesPort {

    @Autowired
    private MockServerInvoiceFactory factory;

    @Override
    public Flux<Invoice> find() {
        return Flux.fromIterable(factory.createInvoiceCollection())
                .delayElements(Duration.ofSeconds(1));
    }

}

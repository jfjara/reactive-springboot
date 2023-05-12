package com.jfjara.reactive.infrastucture.cache.repository;

import com.jfjara.reactive.domain.model.Invoice;
import com.jfjara.reactive.domain.ports.FindInvoiceByIdPort;
import com.jfjara.reactive.infrastucture.cache.repository.util.CacheInvoiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Repository("findInvoiceByIdCacheRepository")
public class FindInvoiceByIdCacheRepository implements FindInvoiceByIdPort {

    @Autowired
    private CacheInvoiceFactory factory;

    @Override
    public Mono<Invoice> find(final String id) {
        return Mono.fromCallable(() -> factory.createInvoice(id))
                .subscribeOn(Schedulers.parallel());
    }

}

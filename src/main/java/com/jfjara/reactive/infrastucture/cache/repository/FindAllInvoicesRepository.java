package com.jfjara.reactive.infrastucture.cache.repository;

import com.jfjara.reactive.domain.model.Invoice;
import com.jfjara.reactive.domain.ports.FindAllInvoicesPort;
import com.jfjara.reactive.infrastucture.cache.repository.util.CacheInvoiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@Repository
public class FindAllInvoicesRepository implements FindAllInvoicesPort {

    @Autowired
    private CacheInvoiceFactory factory;

    @Override
    public Flux<Invoice> find() {
        return Mono.fromCallable(() -> factory.createInvoiceCollection())
                .subscribeOn(Schedulers.parallel())
                .flatMapMany(Flux::fromIterable)
                .delayElements(Duration.ofSeconds(1));
    }

}

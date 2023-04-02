package com.jfjara.reactive.infrastucture.cache.repository;

import com.jfjara.reactive.domain.model.Invoice;
import com.jfjara.reactive.domain.ports.FindInvoiceByIdAndShopIdPort;
import com.jfjara.reactive.domain.ports.FindInvoiceByIdPort;
import com.jfjara.reactive.domain.ports.FindShopByIdPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository("findInvoiceByIdAndShopIdCacheRepository")
public class FindInvoiceByIdAndShopIdCacheRepository implements FindInvoiceByIdAndShopIdPort {

    @Autowired
    @Qualifier("findInvoiceByIdCacheRepository")
    private FindInvoiceByIdPort findInvoiceById;

    @Autowired
    @Qualifier("findShopByIdRepository")
    private FindShopByIdPort findShopById;


    @Override
    public Mono<Invoice> find(final String invoiceId, final String shopId) {

        var invoiceResult = findInvoiceById.find(invoiceId);
        var shopResult = findShopById.find(shopId);

        return Mono.zip(invoiceResult, shopResult)
                .map(result -> result.getT1().toBuilder().shop(result.getT2()).build());
    }

}

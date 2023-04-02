package com.jfjara.reactive.infrastucture.cache.repository;

import com.jfjara.reactive.domain.model.Shop;
import com.jfjara.reactive.domain.ports.FindShopByIdPort;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository("findShopByIdRepository")
public class FindShopByIdRepository implements FindShopByIdPort {

    @Override
    public Mono<Shop> find(final String id) {
        return Mono.just(Shop.builder()
                .id(id)
                .shopReference("SH-0001")
                .build());
    }

}

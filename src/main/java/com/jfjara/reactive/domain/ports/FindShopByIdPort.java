package com.jfjara.reactive.domain.ports;

import com.jfjara.reactive.domain.model.Shop;
import reactor.core.publisher.Mono;

public interface FindShopByIdPort {

    Mono<Shop> find(final String id);

}

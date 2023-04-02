package com.jfjara.reactive.domain.ports;

import com.jfjara.reactive.domain.model.Invoice;
import reactor.core.publisher.Flux;

public interface FindAllInvoicesPort {

    Flux<Invoice> find();

}

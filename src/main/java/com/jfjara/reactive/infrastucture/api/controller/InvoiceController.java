package com.jfjara.reactive.infrastucture.api.controller;

import com.jfjara.reactive.application.usecase.FindAllInvoicesUsecase;
import com.jfjara.reactive.application.usecase.FindInvoiceByIdAndShopUsecase;
import com.jfjara.reactive.application.usecase.FindInvoiceByIdUseCase;
import com.jfjara.reactive.infrastucture.api.model.ExtendedInvoiceApi;
import com.jfjara.reactive.infrastucture.api.model.InvoiceApi;
import com.jfjara.reactive.infrastucture.api.model.mapper.ExtendedInvoiceApiMapper;
import com.jfjara.reactive.infrastucture.api.model.mapper.InvoiceApiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private FindAllInvoicesUsecase findAllInvoicesUsecase;

    @Autowired
    private FindInvoiceByIdUseCase findInvoiceByIdUseCase;

    @Autowired
    private FindInvoiceByIdAndShopUsecase findInvoiceByIdAndShop;

    @Autowired
    private InvoiceApiMapper invoiceApiMapper;

    @Autowired
    private ExtendedInvoiceApiMapper extendedInvoiceApiMapper;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<ResponseEntity<InvoiceApi>> getInvoice(
            @PathVariable("id") String id) {
        return findInvoiceByIdUseCase.execute(id)
                .map(invoiceApiMapper::toApiModel)
                .map(ResponseEntity::ok);
    }

    @GetMapping(value = "/{idInvoice}/shop/{idShop}")
    public Mono<ResponseEntity<ExtendedInvoiceApi>> getInvoice(
            @PathVariable("idInvoice") String idInvoice,
            @PathVariable("idShop") String idShop) {
        return findInvoiceByIdAndShop.execute(idInvoice, idShop)
                .map(extendedInvoiceApiMapper::toApiModel)
                .map(ResponseEntity::ok);
    }

    @GetMapping(produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<ResponseEntity<InvoiceApi>> getInvoices() {
        return findAllInvoicesUsecase.execute()
                .map(invoiceApiMapper::toApiModel)
                .map(ResponseEntity::ok);
    }

}

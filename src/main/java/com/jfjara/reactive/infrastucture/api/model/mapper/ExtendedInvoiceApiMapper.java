package com.jfjara.reactive.infrastucture.api.model.mapper;

import com.jfjara.reactive.infrastucture.api.model.ExtendedInvoiceApi;
import com.jfjara.reactive.domain.model.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = ShopApiMapper.class)
public interface ExtendedInvoiceApiMapper {

    @Mapping(target = "totalAmount", expression = "java(invoice.getTotalAmount())")
    @Mapping(target = "totalVAT", expression = "java(invoice.getTotalVAT())")
    ExtendedInvoiceApi toApiModel(final Invoice invoice);

}

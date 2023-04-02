package com.jfjara.reactive.infrastucture.api.model.mapper;

import com.jfjara.reactive.domain.model.Invoice;
import com.jfjara.reactive.infrastucture.api.model.InvoiceApi;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceApiMapper {

    InvoiceApi toApiModel(final Invoice invoice);

}

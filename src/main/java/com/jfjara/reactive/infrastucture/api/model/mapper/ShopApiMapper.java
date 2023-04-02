package com.jfjara.reactive.infrastucture.api.model.mapper;

import com.jfjara.reactive.domain.model.Shop;
import com.jfjara.reactive.infrastucture.api.model.ShopApi;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShopApiMapper {

    ShopApi toApiModel(final Shop shop);

}

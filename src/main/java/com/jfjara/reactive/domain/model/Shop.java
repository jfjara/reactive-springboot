package com.jfjara.reactive.domain.model;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class Shop {

    private String id;
    private String shopReference;

}

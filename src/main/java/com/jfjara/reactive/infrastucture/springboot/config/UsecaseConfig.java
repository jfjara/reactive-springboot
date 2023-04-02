package com.jfjara.reactive.infrastucture.springboot.config;

import com.jfjara.reactive.application.usecase.FindAllInvoicesUsecase;
import com.jfjara.reactive.application.usecase.FindInvoiceByIdAndShopUsecase;
import com.jfjara.reactive.application.usecase.FindInvoiceByIdUseCase;
import com.jfjara.reactive.domain.ports.FindInvoiceByIdAndShopIdPort;
import com.jfjara.reactive.infrastucture.cache.repository.FindAllInvoicesRepository;
import com.jfjara.reactive.infrastucture.cache.repository.FindInvoiceByIdCacheRepository;
import com.jfjara.reactive.infrastucture.mockserver.repository.FindAllInvoicesMockServerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsecaseConfig {

    @Bean
    public FindAllInvoicesUsecase findAllInvoicesUsecase(final FindAllInvoicesRepository findAllInvoicesFromCache,
                                                         final FindAllInvoicesMockServerRepository findAllInvoicesMockServer) {
        return new FindAllInvoicesUsecase(findAllInvoicesFromCache, findAllInvoicesMockServer);
    }

    @Bean
    public FindInvoiceByIdUseCase findInvoiceByIdUseCase(final FindInvoiceByIdCacheRepository findInvoiceBy) {
        return new FindInvoiceByIdUseCase(findInvoiceBy);
    }

    @Bean
    public FindInvoiceByIdAndShopUsecase findInvoiceByIdAndShopUsecase(
            final FindInvoiceByIdAndShopIdPort findInvoiceByIdAndShopId) {
        return new FindInvoiceByIdAndShopUsecase(findInvoiceByIdAndShopId);
    }

}

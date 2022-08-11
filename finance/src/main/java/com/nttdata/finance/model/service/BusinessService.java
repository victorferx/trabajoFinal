package com.nttdata.finance.model.service;

import com.nttdata.finance.model.document.Business;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BusinessService {
    Flux<Business> getAll();
    Mono<Business> findById(String id);
    Mono<Boolean> existsById(String id);
    Mono<Boolean> existsByRuc(String ruc);
    Mono<Business> save(Business business);
    Mono<Business> update(Business business);
    Mono<Void> deleteById(String id);
}

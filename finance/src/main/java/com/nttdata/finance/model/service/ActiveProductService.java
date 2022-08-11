package com.nttdata.finance.model.service;

import com.nttdata.finance.model.document.ActiveProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ActiveProductService {
    Flux<ActiveProduct> getAll();
    Mono<ActiveProduct> findById(String id);
    Mono<ActiveProduct> save(ActiveProduct activeProduct);
    Mono<ActiveProduct> update(ActiveProduct activeProduct);
    Mono<Void> deleteById(String id);
}

package com.nttdata.finance.model.service;

import com.nttdata.finance.model.document.Holder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HolderService {
    Flux<Holder> getAll();
    Mono<Holder> findById(String id);
    Mono<Boolean> existsById(String id);
    Mono<Holder> save(Holder holder);
    Mono<Holder> update(Holder holder);
    Mono<Void> deleteById(String id);
}

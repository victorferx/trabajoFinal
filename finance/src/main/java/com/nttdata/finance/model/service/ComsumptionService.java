package com.nttdata.finance.model.service;

import com.nttdata.finance.model.document.ActiveAccount;
import com.nttdata.finance.model.document.Comsumption;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ComsumptionService {
    Flux<Comsumption> getAll();
    Mono<Comsumption> findById(String id);
    Mono<Boolean> existsById(String id);
    Mono<Boolean> existsByActiveAccount(ActiveAccount activeAccount);
    Mono<Comsumption> save(Comsumption comsumption);
    Mono<Comsumption> update(Comsumption comsumption);
    Mono<Void> deleteById(String id);
}

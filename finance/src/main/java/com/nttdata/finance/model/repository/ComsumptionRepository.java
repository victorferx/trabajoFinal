package com.nttdata.finance.model.repository;

import com.nttdata.finance.model.document.ActiveAccount;
import com.nttdata.finance.model.document.Comsumption;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ComsumptionRepository extends ReactiveMongoRepository<Comsumption, String> {
    Mono<Boolean> existsByActiveAccount(ActiveAccount activeAccount);
}

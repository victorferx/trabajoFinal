package com.nttdata.finance.model.repository;

import com.nttdata.finance.model.document.Deposit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * Interfaz DepositRepository.
 */
public interface DepositRepository extends ReactiveMongoRepository<Deposit, String> {
  Mono<Boolean> existsByPassiveAccount(String passiveAccount);
}

package com.nttdata.finance.model.service;

import com.nttdata.finance.model.document.Deposit;
import com.nttdata.finance.model.document.PassiveAccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interfaz DepositService.
 */
public interface DepositService {
  Flux<Deposit> getAll();

  Mono<Deposit> findById(String id);

  Mono<Boolean> existsById(String id);

  Mono<Boolean> existsByPassiveAccount(String passiveAccount);

  Mono<Deposit> save(Deposit deposit);

  Mono<Deposit> update(Deposit deposit);

  Mono<Void> deleteById(String id);

}

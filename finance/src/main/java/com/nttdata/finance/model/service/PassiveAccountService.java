package com.nttdata.finance.model.service;

import com.nttdata.finance.model.document.PassiveAccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interfaz PassiveAccountService.
 */
public interface PassiveAccountService {
  Flux<PassiveAccount> getAll();

  Mono<PassiveAccount> findById(String id);

  Mono<Boolean> existsById(String id);

  Mono<PassiveAccount> save(PassiveAccount passiveAccount);

  Mono<PassiveAccount> update(PassiveAccount passiveAccount);

  Mono<Void> deleteById(String id);

}

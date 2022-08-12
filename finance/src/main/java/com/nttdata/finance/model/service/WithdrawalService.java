package com.nttdata.finance.model.service;

import com.nttdata.finance.model.document.Withdrawal;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interfaz WithdrawalService.
 */
public interface WithdrawalService {
  Flux<Withdrawal> getAll();

  Mono<Withdrawal> findById(String id);

  Mono<Boolean> existsById(String id);

  Mono<Withdrawal> save(Withdrawal withdrawal);

  Mono<Withdrawal> update(Withdrawal withdrawal);

  Mono<Void> deleteById(String id);
}

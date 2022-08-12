package com.nttdata.finance.model.service;

import com.nttdata.finance.model.document.ActiveAccount;
import com.nttdata.finance.model.document.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interfaz ActiveAccountService.
 */
public interface ActiveAccountService {
  Flux<ActiveAccount> getAll();

  Mono<ActiveAccount> findById(String id);

  Mono<ActiveAccount> findByNumber(String number);

  Mono<Boolean> existsById(String id);

  Mono<Boolean> existsByCustomer(Customer customer);

  Mono<ActiveAccount> save(ActiveAccount activeAccount);

  Mono<ActiveAccount> update(ActiveAccount activeAccount);

  Mono<Void> deleteById(String id);

}

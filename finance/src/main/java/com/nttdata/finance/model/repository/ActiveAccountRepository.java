package com.nttdata.finance.model.repository;

import com.nttdata.finance.model.document.ActiveAccount;
import com.nttdata.finance.model.document.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * Interfaz ActiveAccountRepository.
 */
public interface ActiveAccountRepository extends ReactiveMongoRepository<ActiveAccount, String> {
  Mono<Boolean> existsByCustomer(Customer customer);

  Mono<ActiveAccount> findByNumber(String number);

}

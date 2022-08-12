package com.nttdata.finance.model.repository;

import com.nttdata.finance.model.document.Business;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * Interfaz BusinessRepository.
 */
public interface BusinessRepository extends ReactiveMongoRepository<Business, String> {
  Mono<Boolean> existsByRuc(String ruc);
}

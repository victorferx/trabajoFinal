package com.nttdata.finance.model.service;

import com.nttdata.finance.model.document.PassiveProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interfaz PassiveProductService.
 */
public interface PassiveProductService {
  Flux<PassiveProduct> getAll();

  Mono<PassiveProduct> findById(String id);

  Mono<Boolean> existsById(String id);

  Mono<PassiveProduct> save(PassiveProduct passiveProduct);

  Mono<PassiveProduct> update(PassiveProduct passiveProduct);

  Mono<Void> deleteById(String id);
}

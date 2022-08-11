package com.nttdata.finance.model.service;

import com.nttdata.finance.model.document.Payment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PaymentService {
  Flux<Payment> getAll();
  Mono<Payment> findById(String id);
  Mono<Boolean> existsById(String id);
  Mono<Payment> save(Payment payment);
  Mono<Payment> update(Payment payment);
  Mono<Void> deleteById(String id);
}

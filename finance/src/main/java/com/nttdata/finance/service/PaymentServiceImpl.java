package com.nttdata.finance.service;

import com.nttdata.finance.model.document.Payment;
import com.nttdata.finance.model.repository.PaymentRepository;
import com.nttdata.finance.model.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase PaymentServiceImpl.
 */
@Service
public class PaymentServiceImpl implements PaymentService {
  @Autowired
  private PaymentRepository paymentRepository;

  @Override
  public Flux<Payment> getAll() {
    return paymentRepository.findAll();
  }

  @Override
  public Mono<Payment> findById(String id) {
    return paymentRepository.findById(id)
            .switchIfEmpty(Mono.error(new Exception("No existe el pago seleccioando.")));
  }

  @Override
  public Mono<Boolean> existsById(String id) {
    return paymentRepository.existsById(id);
  }

  @Override
  public Mono<Payment> save(Payment payment) {
    return paymentRepository.save(payment);
  }

  @Override
  public Mono<Payment> update(Payment payment) {
    return paymentRepository.findById(payment.getId())
            .map(p -> payment)
            .flatMap(paymentRepository::save);
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return paymentRepository.deleteById(id);
  }
}

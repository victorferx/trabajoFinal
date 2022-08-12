package com.nttdata.finance.model.repository;

import com.nttdata.finance.model.document.Payment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Interfaz PaymentRepository.
 */
public interface PaymentRepository extends ReactiveMongoRepository<Payment, String> {

}

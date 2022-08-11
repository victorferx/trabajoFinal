package com.nttdata.finance.model.repository;

import com.nttdata.finance.model.document.Payment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PaymentRepository extends ReactiveMongoRepository<Payment, String> {

}

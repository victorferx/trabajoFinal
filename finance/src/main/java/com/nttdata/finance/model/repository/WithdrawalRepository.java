package com.nttdata.finance.model.repository;

import com.nttdata.finance.model.document.Withdrawal;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Interfaz WithdrawalRepository.
 */
public interface WithdrawalRepository extends ReactiveMongoRepository<Withdrawal, String> {

}

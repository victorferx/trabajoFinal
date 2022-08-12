package com.nttdata.finance.model.repository;

import com.nttdata.finance.model.document.PassiveAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Interfaz PassiveAccountRepository.
 */
public interface PassiveAccountRepository extends ReactiveMongoRepository<PassiveAccount, String> {

}

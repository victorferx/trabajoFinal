package com.nttdata.finance.service;

import com.nttdata.finance.model.document.Deposit;
import com.nttdata.finance.model.document.PassiveAccount;
import com.nttdata.finance.model.repository.DepositRepository;
import com.nttdata.finance.model.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase DepositServiceImpl.
 */
@Service
public class DepositServiceImpl implements DepositService {

  @Autowired
  private DepositRepository depositRepository;

  @Override
  public Flux<Deposit> getAll() {
    return depositRepository.findAll();
  }

  @Override
  public Mono<Deposit> findById(String id) {
    return depositRepository.findById(id);
  }

  @Override
  public Mono<Boolean> existsById(String id) {
    return depositRepository.existsById(id);
  }

  @Override
  public Mono<Boolean> existsByPassiveAccount(String passiveAccount) {
    return depositRepository.existsByPassiveAccount(passiveAccount);
  }

  @Override
  public Mono<Deposit> save(Deposit deposit) {
    return depositRepository.save(deposit);
  }

  @Override
  public Mono<Deposit> update(Deposit deposit) {
    return depositRepository.findById(deposit.getId())
            .map(d -> deposit)
            .flatMap(depositRepository::save);
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return depositRepository.deleteById(id);
  }
}

package com.nttdata.finance.service;

import com.nttdata.finance.model.document.PassiveAccount;
import com.nttdata.finance.model.repository.PassiveAccountRepository;
import com.nttdata.finance.model.service.PassiveAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase PassiveAccountServiceImpl.
 */
@Service
public class PassiveAccountServiceImpl implements PassiveAccountService {
  @Autowired
  private PassiveAccountRepository passiveAccountRepository;

  @Override
  public Flux<PassiveAccount> getAll() {
    return passiveAccountRepository.findAll();
  }

  @Override
  public Mono<PassiveAccount> findById(String id) {
    return passiveAccountRepository.findById(id)
            .switchIfEmpty(Mono.error(new Exception("No existe la cuenta pasiva")));
  }

  @Override
  public Mono<Boolean> existsById(String id) {
    return passiveAccountRepository.existsById(id);
  }

  @Override
  public Mono<PassiveAccount> save(PassiveAccount passiveAccount) {
    return passiveAccountRepository.save(passiveAccount);
  }

  @Override
  public Mono<PassiveAccount> update(PassiveAccount passiveAccount) {
    return passiveAccountRepository.findById(passiveAccount.getId())
            .map(p -> passiveAccount)
            .flatMap(passiveAccountRepository::save);
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return passiveAccountRepository.deleteById(id);
  }
}

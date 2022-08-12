package com.nttdata.finance.service;

import com.nttdata.finance.model.document.Withdrawal;
import com.nttdata.finance.model.repository.WithdrawalRepository;
import com.nttdata.finance.model.service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase WithdrawalServiceImpl.
 */
@Service
public class WithdrawalServiceImpl implements WithdrawalService {

  @Autowired
  private WithdrawalRepository withdrawalRepository;

  @Override
  public Flux<Withdrawal> getAll() {
    return withdrawalRepository.findAll();
  }

  @Override
  public Mono<Withdrawal> findById(String id) {
    return withdrawalRepository.findById(id);
  }

  @Override
  public Mono<Boolean> existsById(String id) {
    return withdrawalRepository.existsById(id);
  }

  @Override
  public Mono<Withdrawal> save(Withdrawal withdrawal) {
    return withdrawalRepository.save(withdrawal);
  }

  @Override
  public Mono<Withdrawal> update(Withdrawal withdrawal) {
    return withdrawalRepository.findById(withdrawal.getId())
            .map(w -> withdrawal)
            .flatMap(withdrawalRepository::save);
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return withdrawalRepository.deleteById(id);
  }
}

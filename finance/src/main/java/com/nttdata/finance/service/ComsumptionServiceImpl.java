package com.nttdata.finance.service;

import com.nttdata.finance.model.document.ActiveAccount;
import com.nttdata.finance.model.document.Comsumption;
import com.nttdata.finance.model.repository.ComsumptionRepository;
import com.nttdata.finance.model.service.ComsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase ComsumptionServiceImpl.
 */
@Service
public class ComsumptionServiceImpl implements ComsumptionService {

  @Autowired
  private ComsumptionRepository comsumptionRepository;

  @Override
  public Flux<Comsumption> getAll() {
    return comsumptionRepository.findAll();
  }

  @Override
  public Mono<Comsumption> findById(String id) {
    return comsumptionRepository.findById(id);
  }

  @Override
  public Mono<Boolean> existsById(String id) {
    return comsumptionRepository.existsById(id);
  }

  @Override
  public Mono<Boolean> existsByActiveAccount(ActiveAccount activeAccount) {
    return comsumptionRepository.existsByActiveAccount(activeAccount);
  }

  @Override
  public Mono<Comsumption> save(Comsumption comsumption) {
    return comsumptionRepository.save(comsumption);
  }

  @Override
  public Mono<Comsumption> update(Comsumption comsumption) {
    return comsumptionRepository.findById(comsumption.getId())
            .map(c -> comsumption)
            .flatMap(comsumptionRepository::save);
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return comsumptionRepository.deleteById(id);
  }
}

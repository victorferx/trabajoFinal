package com.nttdata.finance.service;

import com.nttdata.finance.model.document.Business;
import com.nttdata.finance.model.repository.BusinessRepository;
import com.nttdata.finance.model.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase BusinessServiceImpl.
 */
@Service
public class BusinessServiceImpl implements BusinessService {

  @Autowired
  private BusinessRepository businessRepository;

  @Override
  public Flux<Business> getAll() {
    return this.businessRepository.findAll();
  }

  @Override
  public Mono<Business> findById(String id) {
    return businessRepository.findById(id);
  }

  @Override
  public Mono<Boolean> existsById(String id) {
    return businessRepository.existsById(id);
  }

  @Override
  public Mono<Boolean> existsByRuc(String ruc) {
    return businessRepository.existsByRuc(ruc);
  }

  @Override
  public Mono<Business> save(Business business) {
    return businessRepository.save(business);
  }

  @Override
  public Mono<Business> update(Business business) {
    return businessRepository.findById(business.getId())
            .map(b -> business)
            .flatMap(businessRepository::save);
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return businessRepository.deleteById(id);
  }
}

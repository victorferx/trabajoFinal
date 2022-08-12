package com.nttdata.finance.service;

import com.nttdata.finance.model.document.ActiveProduct;
import com.nttdata.finance.model.repository.ActiveProductRepository;
import com.nttdata.finance.model.service.ActiveProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase ActiveProductServiceImpl.
 */
@Service
public class ActiveProductServiceImpl implements ActiveProductService {

  @Autowired
  private ActiveProductRepository activeProductRepository;

  @Override
  public Flux<ActiveProduct> getAll() {
    return activeProductRepository.findAll();
  }

  @Override
  public Mono<ActiveProduct> findById(String id) {
    return activeProductRepository.findById(id);
  }

  @Override
  public Mono<ActiveProduct> save(ActiveProduct activeProduct) {
    return activeProductRepository.save(activeProduct);
  }

  @Override
  public Mono<ActiveProduct> update(ActiveProduct activeProduct) {
    return activeProductRepository.findById(activeProduct.getId())
            .map(a -> activeProduct)
            .flatMap(activeProductRepository::save);
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return activeProductRepository.deleteById(id);
  }
}

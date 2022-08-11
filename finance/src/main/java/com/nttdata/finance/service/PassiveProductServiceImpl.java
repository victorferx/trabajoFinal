package com.nttdata.finance.service;

import com.nttdata.finance.model.document.PassiveProduct;
import com.nttdata.finance.model.repository.PassiveProductRepository;
import com.nttdata.finance.model.service.PassiveProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PassiveProductServiceImpl implements PassiveProductService {
  @Autowired
  private PassiveProductRepository passiveProductRepository;

  @Override
  public Flux<PassiveProduct> getAll() {
    return passiveProductRepository.findAll();
  }

  @Override
  public Mono<PassiveProduct> findById(String id) {
    return passiveProductRepository.findById(id)
            .switchIfEmpty(Mono.error(new Exception("No existe el producto pasivo.")));
  }

  @Override
  public Mono<Boolean> existsById(String id) {
    return passiveProductRepository.existsById(id);
  }

  @Override
  public Mono<PassiveProduct> save(PassiveProduct passiveProduct) {
    return passiveProductRepository.save(passiveProduct);
  }

  @Override
  public Mono<PassiveProduct> update(PassiveProduct passiveProduct) {
    return passiveProductRepository.findById(passiveProduct.getId())
            .map(p -> passiveProduct)
            .flatMap(passiveProductRepository::save);
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return passiveProductRepository.deleteById(id);
  }
}

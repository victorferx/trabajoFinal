package com.nttdata.finance.service;

import com.nttdata.finance.model.document.Holder;
import com.nttdata.finance.model.repository.HolderRepository;
import com.nttdata.finance.model.service.HolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HolderServiceImpl implements HolderService {

  @Autowired
  private HolderRepository holderRepository;

  @Override
  public Flux<Holder> getAll() {
    return holderRepository.findAll();
  }

  @Override
  public Mono<Holder> findById(String id) {
    return holderRepository.findById(id)
            .switchIfEmpty(Mono.error(new Exception("No existe el representante con código " + id)));
  }

  @Override
  public Mono<Boolean> existsById(String id) {
    return holderRepository.existsById(id);
  }

  @Override
  public Mono<Holder> save(Holder holder) {
    return holderRepository.save(holder);
  }

  @Override
  public Mono<Holder> update(Holder holder) {
    return holderRepository.findById(holder.getId())
            .map(h -> holder)
            .flatMap(holderRepository::save);
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return holderRepository.deleteById(id);
  }
}

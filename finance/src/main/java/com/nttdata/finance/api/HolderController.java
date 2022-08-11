package com.nttdata.finance.api;

import com.nttdata.finance.model.document.Holder;
import com.nttdata.finance.model.service.HolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/holders")
public class HolderController {
  @Autowired
  private HolderService holderService;

  @GetMapping
  public Flux<Holder> getAll() {
    return holderService.getAll();
  }

  @GetMapping(path= {"{id}"})
  public Mono<Holder> findById(@PathVariable("id") String id) {
    return holderService.findById(id);
  }

  @GetMapping(path= {"/exists/{id}"})
  public Mono<Boolean> existsById(@PathVariable("id") String id) {
    return holderService.existsById(id);
  }

  @PostMapping
  public Mono<Holder> save(@RequestBody Holder holder) {
    return holderService.save(holder);
  }

  @PutMapping
  public Mono<Holder> update(@RequestBody Holder holder) {
    return holderService.update(holder);
  }

  @DeleteMapping(path= {"{id}"})
  public Mono<Void> deleteById(@PathVariable("id") String id) {
    return holderService.deleteById(id);
  }


}

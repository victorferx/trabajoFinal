package com.nttdata.finance.api;

import com.nttdata.finance.model.document.PassiveProduct;
import com.nttdata.finance.model.service.PassiveProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/passiveProducts")
public class PassiveProductController {

  @Autowired
  private PassiveProductService passiveProductService;

  @GetMapping
  public Flux<PassiveProduct> getAll() {
    return passiveProductService.getAll();
  }

  @GetMapping(path= {"{id}"})
  public Mono<PassiveProduct> findById(@PathVariable("id") String id) {
    return passiveProductService.findById(id);
  }

  @GetMapping(path= {"/exists/{id}"})
  public Mono<Boolean> existsById(@PathVariable("id") String id) {
    return passiveProductService.existsById(id);
  }

  @PostMapping
  public Mono<PassiveProduct> save(@RequestBody PassiveProduct passiveProduct) {
    return passiveProductService.save(passiveProduct);
  }

  @PutMapping
  public Mono<PassiveProduct> update(@RequestBody PassiveProduct passiveProduct) {
    return passiveProductService.update(passiveProduct);
  }

  @DeleteMapping(path= {"{id}"})
  public Mono<Void> deleteById(@PathVariable("id") String id) {
    return passiveProductService.deleteById(id);
  }

}

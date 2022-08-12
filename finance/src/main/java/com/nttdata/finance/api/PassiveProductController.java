package com.nttdata.finance.api;

import com.nttdata.finance.model.document.PassiveProduct;
import com.nttdata.finance.model.service.PassiveProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Controlador PassiveProductController.
 */
@RestController
@RequestMapping("/api/passiveProducts")
public class PassiveProductController {

  @Autowired
  private PassiveProductService passiveProductService;

  @GetMapping
  public Flux<PassiveProduct> getAll() {
    return passiveProductService.getAll();
  }

  @GetMapping(path = {"{id}"})
  public Mono<PassiveProduct> findById(@PathVariable("id") String id) {
    return passiveProductService.findById(id);
  }

  @GetMapping(path = {"/exists/{id}"})
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

  @DeleteMapping(path = {"{id}"})
  public Mono<Void> deleteById(@PathVariable("id") String id) {
    return passiveProductService.deleteById(id);
  }

}

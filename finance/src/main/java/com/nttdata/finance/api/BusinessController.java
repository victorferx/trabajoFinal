package com.nttdata.finance.api;

import com.nttdata.finance.model.document.Business;
import com.nttdata.finance.model.service.BusinessService;
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
 * Controlador BusinessController.
 */
@RestController
@RequestMapping("/api/businesses")
public class BusinessController {

  @Autowired
  private BusinessService businessService;

  @GetMapping
  public Flux<Business> getAll() {
    return  businessService.getAll();
  }

  @GetMapping(path = {"{id}"})
  public Mono<Business> findById(@PathVariable("id") String id) {
    return businessService.findById(id);
  }

  @GetMapping(path = {"/exists/{id}"})
  public Mono<Boolean> existsById(@PathVariable("id") String id) {
    return businessService.existsById(id);
  }

  @GetMapping(path = {"/existsRuc/{ruc}"})
  public Mono<Boolean> existsByDni(@PathVariable("ruc") String ruc) {
    return businessService.existsByRuc(ruc);
  }

  @PostMapping
  public Mono<Business> register(@RequestBody Business business) {
    return businessService.save(business);
  }

  @PutMapping
  public Mono<Business> update(@RequestBody Business business) {
    return businessService.update(business);
  }

  @DeleteMapping(path = {"{id}"})
  public Mono<Void> delete(@PathVariable("id") String id) {
    return businessService.deleteById(id);
  }

}

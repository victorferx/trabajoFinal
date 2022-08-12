package com.nttdata.finance.api;

import com.nttdata.finance.model.document.ActiveAccount;
import com.nttdata.finance.model.document.Comsumption;
import com.nttdata.finance.model.service.ComsumptionService;
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
 * Controlador ComsumptionController.
 */
@RestController
@RequestMapping("/api/comsumptions")
public class ComsumptionController {

  @Autowired
  private ComsumptionService comsumptionService;

  @GetMapping
  public Flux<Comsumption> getAll() {
    return comsumptionService.getAll();
  }

  @GetMapping(path = {"{id}"})
  public Mono<Comsumption> findById(@PathVariable("id") String id) {
    return comsumptionService.findById(id);
  }

  @GetMapping(path = {"/exists/{id}"})
  public Mono<Boolean> existsById(@PathVariable("id") String id) {
    return comsumptionService.existsById(id);
  }

  @GetMapping(path = {"/existsActiveAccount"})
  public Mono<Boolean> existsByActiveAccount(@RequestBody ActiveAccount activeAccount) {
    return comsumptionService.existsByActiveAccount(activeAccount);
  }

  @PostMapping
  public Mono<Comsumption> register(@RequestBody Comsumption comsumption) {
    return comsumptionService.save(comsumption);
  }

  @PutMapping
  public Mono<Comsumption> update(@RequestBody Comsumption comsumption) {
    return comsumptionService.update(comsumption);
  }

  @DeleteMapping(path = {"{id}"})
  public Mono<Void> delete(@PathVariable("id") String id) {
    return comsumptionService.deleteById(id);
  }
}

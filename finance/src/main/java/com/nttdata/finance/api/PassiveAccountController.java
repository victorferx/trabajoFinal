package com.nttdata.finance.api;

import com.nttdata.finance.model.document.PassiveAccount;
import com.nttdata.finance.model.service.PassiveAccountService;
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
 * Controlador PassiveAccountController.
 */
@RestController
@RequestMapping("/api/passiveAccounts")
public class PassiveAccountController {

  @Autowired
  private PassiveAccountService passiveAccountService;

  @GetMapping
  public Flux<PassiveAccount> getAll() {
    return passiveAccountService.getAll();
  }

  @GetMapping(path = {"{id}"})
  public Mono<PassiveAccount> findById(@PathVariable("id") String id) {
    return passiveAccountService.findById(id);
  }

  @GetMapping(path = {"/exists/{id}"})
  public Mono<Boolean> existsById(@PathVariable("id") String id) {
    return passiveAccountService.existsById(id);
  }

  @PostMapping
  public Mono<PassiveAccount> save(@RequestBody PassiveAccount passiveAccount) {
    return passiveAccountService.save(passiveAccount);
  }

  @PutMapping
  public Mono<PassiveAccount> update(@RequestBody PassiveAccount passiveAccount) {
    return passiveAccountService.update(passiveAccount);
  }

  @DeleteMapping(path = {"{id}"})
  public Mono<Void> deleteById(@PathVariable("id") String id) {
    return passiveAccountService.deleteById(id);
  }





}

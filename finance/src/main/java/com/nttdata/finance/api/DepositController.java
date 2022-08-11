package com.nttdata.finance.api;

import com.nttdata.finance.model.document.Deposit;
import com.nttdata.finance.model.document.PassiveAccount;
import com.nttdata.finance.model.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/deposits")
public class DepositController {

  @Autowired
  private DepositService depositService;

  @GetMapping
  public Flux<Deposit> getAll() {
    return depositService.getAll();
  }

  @GetMapping(path= {"{id}"})
  public Mono<Deposit> findById(@PathVariable("id") String id) {
    return depositService.findById(id);
  }

  @GetMapping(path= {"/exists/{id}"})
  public Mono<Boolean> existsById(@PathVariable("id") String id) {
    return depositService.existsById(id);
  }

  @GetMapping(path= {"/existsPassiveAccount/{passiveAccount}"})
  public Mono<Boolean> existsByPassiveAccount(@PathVariable("passiveAccount") String passiveAccount) {
    return depositService.existsByPassiveAccount(passiveAccount);
  }

  @PostMapping
  public Mono<Deposit> save(@RequestBody Deposit deposit) {
    return depositService.save(deposit);
  }

  @PutMapping
  public Mono<Deposit> update(@RequestBody Deposit deposit) {
    return depositService.update(deposit);
  }

  @DeleteMapping(path= {"{id}"})
  public Mono<Void> deleteById(@PathVariable("id") String id) {
    return depositService.deleteById(id);
  }

}

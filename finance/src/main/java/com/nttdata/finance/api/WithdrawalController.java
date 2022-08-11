package com.nttdata.finance.api;

import com.nttdata.finance.model.document.Withdrawal;
import com.nttdata.finance.model.service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/withdrawales")
public class WithdrawalController {

  @Autowired
  private WithdrawalService withdrawalService;

  @GetMapping
  public Flux<Withdrawal> getAll() {
    return withdrawalService.getAll();
  }

  @GetMapping(path= {"{id}"})
  public Mono<Withdrawal> findById(@PathVariable("id") String id) {
    return withdrawalService.findById(id);
  }

  @GetMapping(path= {"/exists/{id}"})
  public Mono<Boolean> existsById(@PathVariable("id") String id) {
    return withdrawalService.existsById(id);
  }

  @PostMapping
  public Mono<Withdrawal> save(@RequestBody Withdrawal withdrawal) {
    return withdrawalService.save(withdrawal);
  }

  @PutMapping
  public Mono<Withdrawal> update(@RequestBody Withdrawal withdrawal) {
    return withdrawalService.update(withdrawal);
  }

  @DeleteMapping(path= {"{id}"})
  public Mono<Void> deleteById(@PathVariable("id") String id) {
    return withdrawalService.deleteById(id);
  }

}

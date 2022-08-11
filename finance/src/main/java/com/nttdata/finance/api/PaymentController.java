package com.nttdata.finance.api;


import com.nttdata.finance.model.document.Payment;
import com.nttdata.finance.model.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

  @Autowired
  private PaymentService paymentService;

  @GetMapping
  public Flux<Payment> getAll() {
    return paymentService.getAll();
  }

  @GetMapping(path= {"{id}"})
  public Mono<Payment> findById(@PathVariable("id") String id) {
    return paymentService.findById(id);
  }

  @GetMapping(path= {"/exists/{id}"})
  public Mono<Boolean> existsById(@PathVariable("id") String id) {
    return paymentService.existsById(id);
  }

  @PostMapping
  public Mono<Payment> save(@RequestBody Payment payment) {
    return paymentService.save(payment);
  }

  @PutMapping
  public Mono<Payment> update(@RequestBody Payment payment) {
    return paymentService.update(payment);
  }

  @DeleteMapping(path= {"{id}"})
  public Mono<Void> deleteById(@PathVariable("id") String id) {
    return paymentService.deleteById(id);
  }
}

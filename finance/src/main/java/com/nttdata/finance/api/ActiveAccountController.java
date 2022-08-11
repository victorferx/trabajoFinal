package com.nttdata.finance.api;


import com.nttdata.finance.model.document.ActiveAccount;
import com.nttdata.finance.model.document.Customer;
import com.nttdata.finance.model.service.ActiveAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/activeAccounts")
public class ActiveAccountController {

    @Autowired
    private ActiveAccountService activeAccountService;

    @GetMapping
    public Flux<ActiveAccount> getAll() {
        return activeAccountService.getAll();
    }

    @GetMapping(path= {"{id}"})
    public Mono<ActiveAccount> findById(@PathVariable("id") String id) {
        return activeAccountService.findById(id);
    }

    @GetMapping(path= {"/exists/{id}"})
    public Mono<Boolean> existsById(@PathVariable("id") String id) {
        return activeAccountService.existsById(id);
    }

    @GetMapping(path= {"/existsCustomer"})
    public Mono<Boolean> existsByDni(@RequestBody Customer customer) {
        return activeAccountService.existsByCustomer(customer);
    }

    @PostMapping
    public Mono<ActiveAccount> register(@RequestBody ActiveAccount activeAccount) {
        return activeAccountService.save(activeAccount);
    }

    @PutMapping
    public Mono<ActiveAccount> update(@RequestBody ActiveAccount activeAccount) {
        return activeAccountService.update(activeAccount);
    }

    @DeleteMapping(path= {"{id}"})
    public Mono<Void> delete(@PathVariable("id") String id) {
        return activeAccountService.deleteById(id);
    }

}

package com.nttdata.finance.api;

import com.nttdata.finance.model.document.ActiveProduct;
import com.nttdata.finance.model.service.ActiveProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/activeProducts")
public class ActiveProductController {

    @Autowired
    private ActiveProductService activeProductService;

    @GetMapping
    public Flux<ActiveProduct> getAll() {
        return activeProductService.getAll();
    }

    @GetMapping(path= {"{id}"})
    public Mono<ActiveProduct> findById(@PathVariable("id") String id) {
        return activeProductService.findById(id);
    }

    @PostMapping
    public Mono<ActiveProduct> register(@RequestBody ActiveProduct activeProduct) {
        return activeProductService.save(activeProduct);
    }

    @PutMapping
    public Mono<ActiveProduct> update(@RequestBody ActiveProduct activeProduct) {
        return activeProductService.update(activeProduct);
    }

    @DeleteMapping(path= {"{id}"})
    public Mono<Void> delete(@PathVariable("id") String id) {
        return activeProductService.deleteById(id);
    }
}

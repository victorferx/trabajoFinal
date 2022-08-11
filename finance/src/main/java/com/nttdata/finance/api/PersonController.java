package com.nttdata.finance.api;

import com.nttdata.finance.model.document.Person;
import com.nttdata.finance.model.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public Flux<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping(path= {"{id}"})
    public Mono<Person> findById(@PathVariable("id") String id) {
        return personService.findById(id);
    }

    @GetMapping(path= {"/exists/{id}"})
    public Mono<Boolean> existsById(@PathVariable("id") String id) {
        return personService.existsById(id);
    }

    @GetMapping(path= {"/existsDni/{dni}"})
    public Mono<Boolean> existsByDni(@PathVariable("dni") String dni) {
        return personService.existsByDni(dni);
    }

    @PostMapping
    public Mono<Person> register(@RequestBody Person person) {
        return personService.save(person);
    }

    @PutMapping
    public Mono<Person> update(@RequestBody Person person) {
        return personService.update(person);
    }

    @DeleteMapping(path= {"{id}"})
    public Mono<Void> delete(@PathVariable("id") String id) {
        return personService.deleteById(id);
    }
}

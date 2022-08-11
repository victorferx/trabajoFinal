package com.nttdata.finance.model.service;

import com.nttdata.finance.model.document.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {
    Flux<Person> getAll();
    Mono<Person> findById(String id);
    Mono<Boolean> existsById(String id);
    Mono<Boolean> existsByDni(String dni);
    Mono<Person> save(Person person);
    Mono<Person> update(Person person);
    Mono<Void> deleteById(String id);
}

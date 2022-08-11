package com.nttdata.finance.model.repository;

import com.nttdata.finance.model.document.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface PersonRepository extends ReactiveMongoRepository<Person, String> {
    Mono<Boolean> existsByDni(String dni);
}

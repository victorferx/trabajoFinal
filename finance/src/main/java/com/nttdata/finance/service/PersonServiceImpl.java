package com.nttdata.finance.service;

import com.nttdata.finance.model.document.Person;
import com.nttdata.finance.model.repository.PersonRepository;
import com.nttdata.finance.model.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Flux<Person> getAll() {
        return this.personRepository.findAll();
    }

    @Override
    public Mono<Person> save(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public Mono<Person> findById(String id) {
        return this.personRepository.findById(id);
    }

    @Override
    public Mono<Boolean> existsById(String id) {
        return this.personRepository.existsById(id);
    }

    @Override
    public Mono<Boolean> existsByDni(String dni) {
        return this.personRepository.existsByDni(dni);
    }

    @Override
    public Mono<Person> update(Person person) {
        return this.personRepository.findById(person.getId())
                .map(p -> person)
                .flatMap(this.personRepository::save);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return this.personRepository.deleteById(id);
    }
}

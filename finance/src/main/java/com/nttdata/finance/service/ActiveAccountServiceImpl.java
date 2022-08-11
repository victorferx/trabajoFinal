package com.nttdata.finance.service;

import com.nttdata.finance.model.document.ActiveAccount;
import com.nttdata.finance.model.document.Customer;
import com.nttdata.finance.model.repository.ActiveAccountRepository;
import com.nttdata.finance.model.service.ActiveAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class ActiveAccountServiceImpl implements ActiveAccountService {

    @Autowired
    private ActiveAccountRepository activeAccountRepository;

    @Override
    public Flux<ActiveAccount> getAll() {
        return activeAccountRepository.findAll();
    }

    @Override
    public Mono<ActiveAccount> findById(String id) {
        return activeAccountRepository.findById(id);
    }

    @Override
    public Mono<ActiveAccount> findByNumber(String number) {
        //return activeAccountRepository.findAll().filter(x -> x.getNumber().equals(number)).doFirst();
        return activeAccountRepository.findByNumber(number);
    }

    @Override
    public Mono<Boolean> existsById(String id) {
        return activeAccountRepository.existsById(id);
    }

    @Override
    public Mono<Boolean> existsByCustomer(Customer customer) {
        return activeAccountRepository.existsByCustomer(customer);
    }

    @Override
    public Mono<ActiveAccount> save(ActiveAccount activeAccount) {
        return activeAccountRepository.save(activeAccount);
    }

    @Override
    public Mono<ActiveAccount> update(ActiveAccount activeAccount) {
        return activeAccountRepository.findById(activeAccount.getId())
                .map(a -> activeAccount)
                .flatMap(activeAccountRepository::save);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return activeAccountRepository.deleteById(id);
    }
}

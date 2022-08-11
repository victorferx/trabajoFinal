package com.nttdata.finance.model.repository;

import com.nttdata.finance.model.document.Holder;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface HolderRepository extends ReactiveMongoRepository<Holder, String> {

}

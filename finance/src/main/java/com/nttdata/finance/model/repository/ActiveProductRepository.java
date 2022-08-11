package com.nttdata.finance.model.repository;

import com.nttdata.finance.model.document.ActiveProduct;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ActiveProductRepository extends ReactiveMongoRepository<ActiveProduct, String> {
}

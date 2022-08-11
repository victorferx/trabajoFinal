package com.nttdata.finance.model.repository;

import com.nttdata.finance.model.document.PassiveProduct;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PassiveProductRepository extends ReactiveMongoRepository<PassiveProduct, String> {

}

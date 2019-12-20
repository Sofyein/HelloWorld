package com.auto.repository;
import org.springframework.stereotype.Repository;
import com.auto.model.Customer_Test;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface Customer_TestRepository extends MongoRepository<Customer_Test,String> {
}
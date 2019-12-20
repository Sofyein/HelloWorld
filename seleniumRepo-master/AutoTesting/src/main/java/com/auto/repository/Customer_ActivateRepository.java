package com.auto.repository;
import org.springframework.stereotype.Repository;
import com.auto.model.Customer_Activate;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface Customer_ActivateRepository extends MongoRepository<Customer_Activate,String> {
}
package com.vijay.springbootlearning.repository;

import com.vijay.springbootlearning.model.Customer;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CouchbaseRepository<Customer, String> {

}

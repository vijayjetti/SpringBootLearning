package com.vijay.springbootlearning.service;

import com.vijay.springbootlearning.model.Customer;

import java.util.List;
import java.util.Set;


public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomer(String id);

    void updateCustomer(Customer customer);

    void deleteCustomer(Integer customerId);

    void deleteBulkCustomers(Set<String> customerIds);

    List<Customer> getCustomerList();

    void addCustomers(List<Customer> customers);
}

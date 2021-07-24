package com.vijay.springbootlearning.service;

import com.vijay.springbootlearning.model.Customer;

import java.util.List;

public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomer(String id);

    void updateCustomer(Customer customer);

    void deleteCustomer(Integer customerId);

    List<Customer> getCustomerList();

    void addCustomers(List<Customer> customers);
}

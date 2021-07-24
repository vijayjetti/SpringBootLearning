package com.vijay.springbootlearning.service;

import com.vijay.springbootlearning.aop.PerformanceTracker;
import com.vijay.springbootlearning.model.Customer;
import com.vijay.springbootlearning.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.vijay.springbootlearning.constants.ApplicationConstants.DATA_BASE_TIMER_KEY;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @PerformanceTracker(timerKey = DATA_BASE_TIMER_KEY)
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    @PerformanceTracker(timerKey = DATA_BASE_TIMER_KEY)
    public Customer getCustomer(String id) {
        return customerRepository.findById(id).orElse(Customer.builder().build());
    }

    @Override
    @PerformanceTracker(timerKey = DATA_BASE_TIMER_KEY)
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    @PerformanceTracker(timerKey = DATA_BASE_TIMER_KEY)
    public void deleteCustomer(Integer customerId) {
        customerRepository.deleteById(customerId.toString());
    }

    @Override
    @PerformanceTracker(timerKey = DATA_BASE_TIMER_KEY)
    public List<Customer> getCustomerList() {
        return new ArrayList<>(customerRepository.findAll());
    }

    @Override
    @PerformanceTracker(timerKey = DATA_BASE_TIMER_KEY)
    public void addCustomers(List<Customer> customers) {
        customerRepository.saveAll(customers);
    }


}

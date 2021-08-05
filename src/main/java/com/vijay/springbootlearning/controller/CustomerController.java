package com.vijay.springbootlearning.controller;

import com.vijay.springbootlearning.model.Customer;
import com.vijay.springbootlearning.model.DeleteByCustomerIds;
import com.vijay.springbootlearning.service.CustomerService;
import com.vijay.springbootlearning.service.CustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import static com.vijay.springbootlearning.constants.URLConstants.*;

@Slf4j
@RestController
@RequestMapping(value = CUSTOMER_BASE_URL)
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = ADD)
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @PostMapping(value = ADD_LIST)
    public void addCustomers(@RequestBody List<Customer> customers) {
        customerService.addCustomers(customers);
    }

    @GetMapping(value = GET)
    public Customer getCustomer(@PathVariable String id) {
        return customerService.getCustomer(id);
    }

    /** TODO not working, Have to look into it**/
    @GetMapping(value = GET_LIST)
    public List<Customer> getCustomerList() {
        return customerService.getCustomerList();

    }

    @PutMapping(value = UPDATE)
    public void updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
    }

    @DeleteMapping(value = DELETE)
    public void deleteCustomer(@PathVariable Integer customerId) {
        customerService.deleteCustomer(customerId);
    }

    @DeleteMapping(value = DELETE_BY_IDS)
    public void deleteCustomers(@RequestBody DeleteByCustomerIds deleteByCustomerIds) {
        Set<String> tobeDeletedCustomerIds = deleteByCustomerIds.getCustomerIds();
        if(CollectionUtils.isNotEmpty(tobeDeletedCustomerIds)){
            customerService.deleteBulkCustomers(tobeDeletedCustomerIds);
        }
    }
}

package com.phl.business.domain.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerSerivceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public Customer createCustomer(CustomerDto customerDto) {
        Customer customer =customerMapper.customerDtoToCustomer(customerDto);
    return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getOneCustomer(String uuid) {
        return customerRepository.findById(uuid).orElse(null);
    }

    @Override
    public String deleteCustomer(String uuid) {
         customerRepository.deleteById(uuid);
         return uuid;
    }

    @Override
    public Customer updateCustomer(String uuid,CustomerDto customerDto) {
        Customer existingCustomer = customerRepository.findById(uuid).orElseThrow(NoSuchElementException::new);
        existingCustomer.updateFrom(customerDto);
        customerRepository.save(existingCustomer);
        return existingCustomer;
    }
}

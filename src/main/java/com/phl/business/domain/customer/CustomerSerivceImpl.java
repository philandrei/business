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
    public CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = customerMapper.customerDtoToCustomer(customerRequestDto);
        customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDto(customer);
    }

    @Override
    public CustomerResponseDto updateCustomer(String uuid, CustomerRequestDto customerRequestDto) {
        Customer existingCustomer = customerRepository.findById(uuid).orElseThrow(NoSuchElementException::new);
        existingCustomer.updateFrom(customerRequestDto);
        customerRepository.save(existingCustomer);
        return customerMapper.customerToCustomerResponseDto(existingCustomer);
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


}

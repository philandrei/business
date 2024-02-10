package com.phl.business.domain.customer;


import java.util.List;

public interface CustomerService {

    CustomerResponseDto createCustomer(CustomerRequestDto customer);
    CustomerResponseDto updateCustomer(String uuid, CustomerRequestDto customerRequestDto);

    List<Customer> getAllCustomers();

    Customer getOneCustomer(String uuid);

    String deleteCustomer(String uuid);


}

package com.phl.business.domain.customer.service;


import com.phl.business.domain.customer.dto.CustomerRequestDto;
import com.phl.business.domain.customer.dto.CustomerResponseDto;
import com.phl.business.domain.customer.model.Customer;

import java.util.List;

public interface CustomerService {

    CustomerResponseDto createCustomer(CustomerRequestDto customer);
    CustomerResponseDto updateCustomer(String uuid, CustomerRequestDto customerRequestDto);

    List<Customer> getAllCustomers();

    Customer getOneCustomer(String uuid);

    String deleteCustomer(String uuid);


}

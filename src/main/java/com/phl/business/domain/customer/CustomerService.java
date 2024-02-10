package com.phl.business.domain.customer;


import java.util.List;

public interface CustomerService {

    Customer createCustomer(CustomerDto customer);

    List<Customer> getAllCustomers();

    Customer getOneCustomer(String uuid);

    String deleteCustomer(String uuid);

    Customer updateCustomer(String uuid,CustomerDto customerDto);

}

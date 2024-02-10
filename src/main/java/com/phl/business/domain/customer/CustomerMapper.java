package com.phl.business.domain.customer;

import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer customerDtoToCustomer(CustomerDto customerDto) {
        Customer customer = Customer.builder()
                                    .email(customerDto.getEmail())
                                    .mobileNumber(customerDto.getMobileNumber())
                                    .firstName(customerDto.getFirstName())
                                    .lastName(customerDto.getLastName())
                                    .build();
        return customer;
    }

    public CustomerDto customerToCustomerDto(Customer customer){
        CustomerDto customerDto = CustomerDto.builder()
                                          .email(customer.getEmail())
                                          .firstName(customer.getFirstName())
                                          .lastName(customer.getLastName())
                                          .mobileNumber(customer.getMobileNumber())
                                          .build();

        return customerDto;
    }
}

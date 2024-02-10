package com.phl.business.domain.customer.mapper;

import com.phl.business.domain.customer.dto.CustomerRequestDto;
import com.phl.business.domain.customer.dto.CustomerResponseDto;
import com.phl.business.domain.customer.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer customerDtoToCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = Customer.builder()
                                    .email(customerRequestDto.getEmail())
                                    .mobileNumber(customerRequestDto.getMobileNumber())
                                    .firstName(customerRequestDto.getFirstName())
                                    .lastName(customerRequestDto.getLastName())
                                    .build();
        return customer;
    }

    public CustomerRequestDto customerToCustomerDto(Customer customer) {
        CustomerRequestDto customerRequestDto = CustomerRequestDto.builder()
                                                        .email(customer.getEmail())
                                                        .firstName(customer.getFirstName())
                                                        .lastName(customer.getLastName())
                                                        .mobileNumber(customer.getMobileNumber())
                                                        .build();
        return customerRequestDto;
    }

    public CustomerResponseDto customerToCustomerResponseDto(Customer customer) {
        CustomerResponseDto customerResponseDto = CustomerResponseDto.builder()
                                                          .uuid(customer.getUuid())
                                                          .email(customer.getEmail())
                                                          .firstName(customer.getFirstName())
                                                          .lastName(customer.getLastName())
                                                          .mobileNumber(customer.getMobileNumber())
                                                          .uuid(customer.getUuid())
                                                          .build();
        return customerResponseDto;
    }
}

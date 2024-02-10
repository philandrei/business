package com.phl.business.domain.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public CustomerResponseDto createCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        return customerService.createCustomer(customerRequestDto);
    }

    @PutMapping("/{uuid}")
    public CustomerResponseDto updateCustomer(@PathVariable String uuid,@RequestBody CustomerRequestDto customerRequestDto){
        return customerService.updateCustomer(uuid, customerRequestDto);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{uuid}")
    public Customer getOneCustomer(@PathVariable String uuid) {
        return customerService.getOneCustomer(uuid);
    }

    @DeleteMapping("/{uuid}")
    public String deleteCustomer(@PathVariable String uuid){ return customerService.deleteCustomer(uuid);}




}

package com.phl.business.domain.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public Customer createCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.createCustomer(customerDto);
    }

    @PutMapping("/{uuid}")
    public Customer updateCustomer(@PathVariable String uuid,@RequestBody CustomerDto customerDto){
        return customerService.updateCustomer(uuid,customerDto);
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

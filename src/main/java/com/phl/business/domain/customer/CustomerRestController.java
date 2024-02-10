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
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping("/{uuid}")
    public Customer updateCustomer(@PathVariable String uuid,@RequestBody Customer customer){
        return customerService.updateCustomer(uuid,customer);
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
